package com.example.kafka.serde;

import java.util.Map;

import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonPojoSerializer<T> implements Serializer<T>{
	
	private final ObjectMapper objectMapper = new ObjectMapper();
	private Class<T> tClass;

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
		tClass = (Class<T>) configs.get("messageClass");
	}

	@Override
	public byte[] serialize(String topic, T data) {
		if(data==null){
			return null;
		}
		try{
			return objectMapper.writeValueAsBytes(data);
		}catch(Exception e){
			throw new SerializationException("Error serializing JSON message", e);
		}
	}

	@Override
	public void close() {
		
	}
	
}

package com.example.kafka.serde;

import java.util.Map;

import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonPojoDeserializer<T> implements Deserializer<T>{
	
	private final ObjectMapper objectMapper = new ObjectMapper();
	private Class<T> tClass;

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
		tClass = (Class<T>) configs.get("messageClass");
	}
	
	@Override
	public T deserialize(String topic, byte[] data) {
		if(data==null ){
			return null;
		}
		try{
			return objectMapper.readValue(data,tClass);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void close() {
		
	}

}

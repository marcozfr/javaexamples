package com.example.kafka.serde;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.serialization.Serializer;

public class SerdeFactory {
	
	public static <T> Serde createJsonSerde(T tClass){
		Map<String, Object> serdeProps = new HashMap<>();
		serdeProps.put("messageClass", tClass);
		
        final Serializer<T> messageSerializer = new JsonPojoSerializer<>();
        
        messageSerializer.configure(serdeProps, false);
        
        final Deserializer<T> messageDeserializer = new JsonPojoDeserializer<>();
        messageDeserializer.configure(serdeProps, false);

        return Serdes.serdeFrom(messageSerializer, messageDeserializer);
	}

}

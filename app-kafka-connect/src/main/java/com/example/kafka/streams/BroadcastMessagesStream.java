package com.example.kafka.streams;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.serialization.Serializer;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KStreamBuilder;

import com.example.kafka.model.Message;
import com.example.kafka.model.User;
import com.example.kafka.serde.JsonPojoDeserializer;
import com.example.kafka.serde.JsonPojoSerializer;
import com.example.kafka.serde.SerdeFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BroadcastMessagesStream {
	
	public static final Long LOWEST = 500l;
	public static final Long HIGHEST = 700l;
	public static final Long LIMIT = 10l;

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {

		Properties streamsConfiguration = new Properties();
		streamsConfiguration.put(StreamsConfig.APPLICATION_ID_CONFIG, "broadcast-messages-example");
		streamsConfiguration.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		streamsConfiguration.put(StreamsConfig.COMMIT_INTERVAL_MS_CONFIG, "30000");
		streamsConfiguration.put(StreamsConfig.NUM_STREAM_THREADS_CONFIG, "2");
		
//		Create serializer and deserializer for Messages object
		
		Serde<Message> messageSerde = SerdeFactory.createJsonSerde(Message.class);

//      Load set of users from json file in classpath
		InputStream usernamesStream = BroadcastMessagesStream.class.getClassLoader()
				.getResourceAsStream("users.json");
		
		ObjectMapper mapper = new ObjectMapper();
		
		List<User> usernames = mapper.readValue(usernamesStream, new TypeReference<List<User>>(){});
		
//		Build the Kstream
		KStreamBuilder builder = new KStreamBuilder();
		
		KStream broadcastKStream = builder.stream(Serdes.String(),messageSerde,"stream-broadcast-input").flatMapValues((value) -> {
			
			if(value == null){
				return Collections.EMPTY_LIST;
			}
			
			Message message = (Message) value;
			long randomRange = ThreadLocalRandom.current().nextLong(LOWEST, HIGHEST);
			
//			Create predicate to select a given number of users that will receive the message
//			in a random fashion
			Predicate<User> filterRandomKey = (user) -> {
				long start = randomRange;
				long end = start + LIMIT; 
				return user.getUserId() > start && user.getUserId() <= end;
			};
			
//			Create a copy of the message containing each selected user
			Function<User, Message> addUserToMessage = (user) -> {
				Message messageCopy = message.copy();
				messageCopy.setUser(user);
				return messageCopy;
			};
			
			// apply functions to global list of usernames
			return usernames.stream().filter(filterRandomKey).map(addUserToMessage).collect(Collectors.toList());
			
		});
		
		broadcastKStream.to(Serdes.String(),messageSerde,"stream-broadcast-output");
		
		KafkaStreams kafkaStream1 = new KafkaStreams(builder, streamsConfiguration);

		kafkaStream1.start();
		
		Runtime.getRuntime().addShutdownHook(new Thread(kafkaStream1::close));
		
	}

}

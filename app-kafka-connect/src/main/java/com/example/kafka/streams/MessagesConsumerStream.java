package com.example.kafka.streams;

import java.util.Properties;

import org.apache.kafka.common.Metric;
import org.apache.kafka.common.MetricName;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStreamBuilder;

public class MessagesConsumerStream {
	
	public static void main(String[] args) {
		
		Properties streamsConfiguration = new Properties();
		streamsConfiguration.put(StreamsConfig.APPLICATION_ID_CONFIG, "consumer-messages-example");
		streamsConfiguration.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		
		KStreamBuilder builder = new KStreamBuilder();
		
		builder.stream(Serdes.String(),Serdes.String(),"stream-broadcast-output").foreach( (key,value) -> {
			System.out.println(value);
			
		});
		
		KafkaStreams kafkaStream2 = new KafkaStreams(builder, streamsConfiguration);

		kafkaStream2.start();
		
		Runtime.getRuntime().addShutdownHook(new Thread(kafkaStream2::close));
		
	}

}

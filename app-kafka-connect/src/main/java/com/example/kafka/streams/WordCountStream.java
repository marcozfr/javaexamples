package com.example.kafka.streams;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KStreamBuilder;

public class WordCountStream {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    Properties streamsConfiguration = new Properties();
	    // Give the Streams application a unique name.  The name must be unique in the Kafka cluster
	    // against which the application is run.
	    streamsConfiguration.put(StreamsConfig.APPLICATION_ID_CONFIG, "wordcount-lambda-example");
	    // Where to find Kafka broker(s).
	    streamsConfiguration.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
	    // commit interval in ms for record caches http://docs.confluent.io/3.2.0/streams/architecture.html#record-caches
	    streamsConfiguration.put(StreamsConfig.COMMIT_INTERVAL_MS_CONFIG, "10000");
	    // Where to find the corresponding ZooKeeper ensemble.
//	    streamsConfiguration.put(StreamsConfig.ZOOKEEPER_CONNECT_CONFIG, "localhost:2181");
	    // Specify default (de)serializers for record keys and for record values.
	    streamsConfiguration.put(StreamsConfig.KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
	    streamsConfiguration.put(StreamsConfig.VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());

	    // Set up serializers and deserializers, which we will use for overriding the default serdes
	    // specified above.
	    final Serde<String> stringSerde = Serdes.String();
	    final Serde<Long> longSerde = Serdes.Long();

	    // In the subsequent lines we define the processing topology of the Streams application.
	    KStreamBuilder builder = new KStreamBuilder();

	    // Construct a `KStream` from the input topic "TextLinesTopic", where message values
	    // represent lines of text (for the sake of this example, we ignore whatever may be stored
	    // in the message keys).
	    //
	    // Note: We could also just call `builder.stream("TextLinesTopic")` if we wanted to leverage
	    // the default serdes specified in the Streams configuration above, because these defaults
	    // match what's in the actual topic.  However we explicitly set the deserializers in the
	    // call to `stream()` below in order to show how that's done, too.

	    KStream<String, Long> wordCounts = builder.stream(stringSerde, stringSerde, "streams-file-input")  	// null:"hello world bye world"
	    	    // Split each text line, by whitespace, into words.  The text lines are the message
	    	    // values, i.e. we can ignore whatever data is in the message keys and thus invoke
	    	    // `flatMapValues` instead of the more generic `flatMap`.
	    	    .flatMapValues(value -> Arrays.asList(value.toLowerCase().split("\\W+"))) 					// "null:hello" , "null:world" , "null:bye" , "null:world"
	    	    // We use `groupBy` to ensure the words are available as message keys
	    	    .groupBy((key, value) -> value)  															// "hello:hello", "bye:bye", "world:world", "world:world" (wordcount-lambda-example-Counts-repartition)
	    	    // Count the occurrences of each word (message key).
	    	    .count("Counts")																			// "hello:1" , "bye:1" , "world:2"	(wordcount-lambda-example-Counts-changelog)
	    	    // Convert the `KTable<String, Long>` into a `KStream<String, Long>`.
	    	    .toStream();																			   

	 // Write the `KStream<String, Long>` to the output topic.
	    wordCounts.to(stringSerde, longSerde, "streams-wordcount-output");

	    // Now that we have finished the definition of the processing topology we can actually run
	    // it via `start()`.  The Streams application as a whole can be launched just like any
	    // normal Java application that has a `main()` method.
	    KafkaStreams streams = new KafkaStreams(builder, streamsConfiguration);
	    streams.start();
	    
	    // Add shutdown hook to respond to SIGTERM and gracefully close Kafka Streams
	    Runtime.getRuntime().addShutdownHook(new Thread(streams::close));
	}
	

}

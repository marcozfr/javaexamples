package com.example.kafka.producer;

import java.util.Arrays;

import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KStreamBuilder;
import org.apache.kafka.streams.kstream.KTable;

public class Group0StreamProd {

	final Serde<String> stringSerde = Serdes.String();
	final Serde<Long> longSerde = Serdes.Long();
	
	public void produce(){
		
		KStreamBuilder builder = new KStreamBuilder();
		KStream<String,String> textLines = builder.stream(stringSerde, stringSerde, "streams-file-input");
		
		KTable<String,Long> wordCounts = textLines.flatMapValues(value -> Arrays.asList(value.toLowerCase().split("\\W+")))
													.groupBy((key,value) -> value)
													.count("Counts");
		
		wordCounts.to(stringSerde, longSerde,"streams-wordcount-output");
		
	}
	
}

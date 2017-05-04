package com.example.kafka;

import java.util.ArrayList;
import java.util.List;

import com.example.kafka.model.Message;

public class Main {
	
	public static void main(String[] args) {
		
		Message m = new Message();
		m.setMessageId("23");
		m.setMessageContent("ello");
		
		List<Message> lists = new ArrayList<>();
		
		for(int i = 0; i< 10 ; i ++){
			lists.add(m);
		}
		
		System.out.println(lists);
	}

}

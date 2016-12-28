package com.example.designpatterns.observer.builtin;

import java.io.IOException;
import java.util.Scanner;

public class NewsStation {
	
	public static void main(String[] args) throws IOException {
		EuSubscriber sub1 = new EuSubscriber();
		LatamSubscriber sub2 = new LatamSubscriber();
		
		Publisher publisher = new Publisher();
		publisher.addObserver(sub1);
		publisher.addObserver(sub2);
		
		Scanner scanner = new Scanner(System.in);
		
		while(true){
			String nes = scanner.next();
			publisher.setNewInfo(nes);
		}
		
	}

}

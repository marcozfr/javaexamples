package com.example.designpatterns.decorator.stream;

import java.io.FileOutputStream;
import java.io.IOException;

public class Writer {
	
	public static void main(String[] args) throws IOException {
		String url = "http://localhost/test/url?encoded=false&jsonRequest={\"test\" : \"global\"}";
		UrlEncodeOutputStream oss = new UrlEncodeOutputStream(new FileOutputStream("test.txt"));
		oss.writeString(url);
		oss.close();
	}

}

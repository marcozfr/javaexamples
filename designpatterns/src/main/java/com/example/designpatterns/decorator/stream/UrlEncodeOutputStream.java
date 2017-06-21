package com.example.designpatterns.decorator.stream;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

public class UrlEncodeOutputStream extends FilterOutputStream {

	public UrlEncodeOutputStream(OutputStream out) {
		super(out);
	}
	
	public void writeString(String s) throws IOException{
		String encodedString = URLEncoder.encode(s,"ISO-8859-1");
		write(encodedString.getBytes());
	}

}

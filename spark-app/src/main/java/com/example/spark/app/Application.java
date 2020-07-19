package com.example.spark.app;

import static spark.Spark.get;

import java.net.InetAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {
	
	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(Application.class);
		SparkUtils.createServerWithRequestLog(logger);
		
		get("/hello", (req, res) -> "Request serviced. Hostname : " + InetAddress.getLocalHost().getHostName());
		
	}

}

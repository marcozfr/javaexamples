package com.example.ws.init;

public class ServerInit {
	
	public static void main(String[] args) throws Exception {
		ServerInstance instance = new TomcatInstance();
		instance.start();
	}

}

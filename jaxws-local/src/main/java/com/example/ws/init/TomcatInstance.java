package com.example.ws.init;

import java.util.Optional;

import org.apache.catalina.startup.Tomcat;

public class TomcatInstance implements ServerInstance {
	
	public static final Optional<String> PORT = Optional.ofNullable(System.getenv("PORT"));
	public static final String APP_BASE = "../";
	public static final String CONTEXT_PATH = "/";
	
	private Tomcat tomcat;
	
	public TomcatInstance() {
		tomcat = new Tomcat();
		tomcat.setPort(Integer.valueOf(PORT.orElse("8180")));
		tomcat.getHost().setAppBase(APP_BASE);
	}

	@Override
	public void start() throws Exception {
		tomcat.addWebapp(CONTEXT_PATH, APP_BASE);	
		tomcat.start();
        tomcat.getServer().await();
	}

}

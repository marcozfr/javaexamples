package com.example.ejb.jms;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JmsManager {
	
	public static final String JMS_FACTORY = "java:jboss/exported/jms/RemoteConnectionFactory";
	public static final String JMS_DEFAULT_USER = "jms-user";
	public static final String JMS_DEFAULT_PWD = "password";
	public static final String JMS_QUEUE = "java:/jms/queue/CatalogQueue";
	
	@Produces
	@ApplicationScoped
	public Context initialContext(){
		try {
			return new InitialContext();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Produces
	@ApplicationScoped
	public ConnectionFactory connectionFactory(Context jndiContext){
		try {
			ConnectionFactory connectionFactory = (ConnectionFactory)jndiContext.lookup(JMS_FACTORY);
			return connectionFactory; 
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Connection getConnection(ConnectionFactory jmsFactory, String user, String password){
		Connection connection = null;
		try {
			connection = jmsFactory.createConnection(user,password);
		} catch (JMSException e) {
			e.printStackTrace();
		}
		return connection;
	}

}

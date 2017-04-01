package com.example.ejb.jms;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RequestScoped
public class JmsMessageProducer {
	
	public static Logger logger = LogManager.getLogger(JmsMessageProducer.class);

	@Inject
	ConnectionFactory connectionFactory;
	
	@Inject
	Context initialContext;
	
	Connection connection = null;
	
	@PostConstruct
	public void init(){
		connection = JmsManager.getConnection(connectionFactory, JmsManager.JMS_DEFAULT_USER, JmsManager.JMS_DEFAULT_PWD);
	}
	
	public void sendMessage(String message, String origin){
		try {
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Queue queue = (Queue) initialContext.lookup(JmsManager.JMS_QUEUE);
			MessageProducer producer = session.createProducer(queue);
			
			TextMessage textMessage = session.createTextMessage();
			textMessage.setStringProperty("origin", origin);
			textMessage.setText(message);
			producer.send(textMessage);
			logger.info("Sending message to queue" + queue.getQueueName() + ": " + message);
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	@PreDestroy
	public void close(){
		if(connection!=null){
    		try {
				connection.close();
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
	}
	
}

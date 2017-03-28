package com.example.ejb.jms;

import java.util.Date;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSConsumer;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@ApplicationScoped
public class DefaultJmsMessageConsumer implements Runnable {
	
	public static Logger logger = LogManager.getLogger(DefaultJmsMessageConsumer.class);
	
	@Resource(name=JmsManager.JMS_FACTORY)
	ConnectionFactory connectionFactory;
	
	@Resource(name=JmsManager.JMS_QUEUE,type=javax.jms.Queue.class)
	Destination destination;
	
	public void run(){
        
		while(true){
			try(JMSConsumer consumer = connectionFactory.createContext(
				JmsManager.JMS_DEFAULT_USER,JmsManager.JMS_DEFAULT_PWD).createConsumer(destination,"origin = 'servlet'")){
//					consumer.setMessageListener(new JmsDefaultListener()); // 1st listener // cannot use in JEE Container
				Message message = consumer.receive(); // blocks undefinitely / 2nd listener
				showMessage(message);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public static void showMessage(Message message) throws JMSException{
		logger.info("# Message received #");
		if(message!=null){
			logger.info("Message: {}",message.getBody(String.class));
			logger.info("CorrelationID: {}",message.getJMSCorrelationID());
			logger.info("MessageID: {}",message.getJMSMessageID());
			logger.info("TimeStamp: {}",new Date(message.getJMSTimestamp()));
			logger.info("JMSType: {}",message.getJMSType());
		}else{
			logger.warn("Message null received (?)");
		}
	}
	
	static class JmsDefaultListener implements MessageListener {

		@Override
		public void onMessage(Message message) {
			try {
				DefaultJmsMessageConsumer.showMessage(message);
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}

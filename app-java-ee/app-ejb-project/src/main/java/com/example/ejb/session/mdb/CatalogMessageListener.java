package com.example.ejb.session.mdb;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@MessageDriven(mappedName="java:/jms/queue/CatalogQueue",activationConfig={
		@ActivationConfigProperty(propertyName="acknowledgeMode",propertyValue="Auto-acknowledge"),
		@ActivationConfigProperty(propertyName="messageSelector",propertyValue="origin = 'servlet'"),
		@ActivationConfigProperty(propertyName="destination",propertyValue="java:/jms/queue/CatalogQueue"),
		@ActivationConfigProperty(propertyName="destinationType",propertyValue="javax.jms.Queue"),
		@ActivationConfigProperty(propertyName="user",propertyValue="jms-user"),
		@ActivationConfigProperty(propertyName="password",propertyValue="password")
})
public class CatalogMessageListener implements MessageListener {
	
	public static Logger logger = LogManager.getLogger(CatalogMessageListener.class);
	
	@Resource
	MessageDrivenContext messageDrivenContext;

	@Override
	public void onMessage(Message message) {
		try {
			logger.info("Message received : {}",message.getBody(String.class));
			logger.info("User principal : {}",messageDrivenContext.getCallerPrincipal());
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

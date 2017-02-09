package com.example.model.catalog.listener;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DefaultLoggerListener {
	
	public static final Logger LOGGER = LogManager.getLogger(DefaultLoggerListener.class); 
	
	@PrePersist
	void prePersist(Object object){
		LOGGER.info("pre persisting object of type "+object.getClass());
	}
	
	@PostPersist
	void postPersist(Object object){
		LOGGER.info("post persisting object of type "+object.getClass());
	}
	
	@PreUpdate
	void preUpdate(Object object){
		LOGGER.info("pre updating object of type "+object.getClass());
	}
	
	@PostUpdate
	void postUpdate(Object object){
		LOGGER.info("post updating object of type "+object.getClass());
	}
	
}

package com.example.kafka.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class Message {
	
	private String messageId;
	private String messageContent;
	
	@JsonFormat(shape=Shape.STRING, pattern="dd-MM-yyyy hh:mm:ss")
	private Date timeStamp;
	
	private User user;
	
	public Message copy(){
		Message newMessage = new Message();
		newMessage.setMessageContent(this.messageContent);
		newMessage.setMessageId(this.messageId);
		newMessage.setTimeStamp(this.timeStamp);
		newMessage.setUser(this.user);
		return newMessage;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}

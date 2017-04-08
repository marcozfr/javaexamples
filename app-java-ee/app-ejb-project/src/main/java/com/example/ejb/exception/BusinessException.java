package com.example.ejb.exception;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class BusinessException extends Exception {

	private String details;
	
	public BusinessException(String message, String details) {
        super(message);
        this.details = details;
    }
	
    public BusinessException(String message) {
        super(message);
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
    
}

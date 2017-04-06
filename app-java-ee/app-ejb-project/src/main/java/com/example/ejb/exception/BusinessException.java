package com.example.ejb.exception;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class BusinessException extends Exception {

	private String info;

	public BusinessException() {
		super();
	}
	
	public BusinessException(String code){
		super(code);
	}

	public BusinessException(String code, String message) {
		super(code);
		this.info = message;
	}

	public String getInfo() {
		return info;
	}

	public String getFaultInfo() {
		return info;
	}

}

package com.microservice.hotel.exception;

public class ResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException() {
		super("Resource not found on the server!!");
	}

	public ResourceNotFoundException(String message) {
		super(message);
	}
	
	

}

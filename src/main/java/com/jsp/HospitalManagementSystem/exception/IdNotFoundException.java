package com.jsp.HospitalManagementSystem.exception;

public class IdNotFoundException extends RuntimeException {
	
	private String message="id not found";
	
	@Override
	public String getMessage() {
		return message;
	}

	public IdNotFoundException() {
		super();
		// TODO Auto-generated constructor stub using fields
	}

	public IdNotFoundException(String message) {
		super();
		this.message = message;
	}
}

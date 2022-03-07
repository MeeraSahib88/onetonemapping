package com.example.demo.dto;

public class MessageResponse {
	
	public int status;
	public String message;
	public Object object;
	public MessageResponse(int status, String message, Object object) {
		super();
		this.status = status;
		this.message = message;
		this.object = object;
	}
	public MessageResponse(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	
	

}

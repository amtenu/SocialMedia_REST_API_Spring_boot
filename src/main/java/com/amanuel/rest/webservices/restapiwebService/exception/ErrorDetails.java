package com.amanuel.rest.webservices.restapiwebService.exception;


import java.time.LocalDateTime;

public class ErrorDetails {

	// Structured Error message with time and details

	private LocalDateTime timeStamp;
	private String message;
	private String details;

	public ErrorDetails(LocalDateTime timeStamp, String message, String details) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.details = details;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}

}

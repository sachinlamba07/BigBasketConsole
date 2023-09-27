package com.masai.exception;

import java.time.LocalDate;

public class ErrorDetails {

	String message;
	String description;
	LocalDate timestamp = LocalDate.now();
	public ErrorDetails(String message, String description) {
		super();
		this.message = message;
		this.description = description;
	}
}

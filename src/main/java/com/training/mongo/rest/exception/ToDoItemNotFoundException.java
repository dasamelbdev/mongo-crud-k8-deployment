package com.training.mongo.rest.exception;

public class ToDoItemNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String id;
	private String message;

	public ToDoItemNotFoundException(String message, String id) {
		super();
		this.id = id;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public String getId() {
		return id;
	}
}

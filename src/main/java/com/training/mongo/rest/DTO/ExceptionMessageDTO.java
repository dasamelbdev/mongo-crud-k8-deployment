package com.training.mongo.rest.DTO;

import org.springframework.http.HttpStatus;

public class ExceptionMessageDTO {

	private String type;
	private String title;
	private Integer statusCode;
	private String errorDetails;
	private String uri;

	public ExceptionMessageDTO(String type, String title, Integer statusCode, String errorDetails, String uri) {
		this.type = type;
		this.title = title;
		this.statusCode = statusCode;
		this.errorDetails = errorDetails;
		this.uri = uri;
	}

	public String getType() {
		return type;
	}

	public String getTitle() {
		return title;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public String getErrorDetails() {
		return errorDetails;
	}

	public String getUri() {
		return uri;
	}

}

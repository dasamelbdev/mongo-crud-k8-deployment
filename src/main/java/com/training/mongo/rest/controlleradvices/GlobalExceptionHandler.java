package com.training.mongo.rest.controlleradvices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.training.mongo.rest.DTO.ExceptionMessageDTO;
import com.training.mongo.rest.exception.ToDoItemNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { ToDoItemNotFoundException.class })
	public ResponseEntity<Object> handleToDoItemNotFoundException(ToDoItemNotFoundException ex, WebRequest request) {
		String type = "/erros/item-not-found";
		String title = "TODO ITEM NOT FOUND";
		String errorDetails = "cannot find ToDo item with id " + ex.getId();
		String uri = request.getDescription(true).split(";")[0];
		ExceptionMessageDTO exceptionMessageDTO = new ExceptionMessageDTO(type, title, HttpStatus.NOT_FOUND.value(),
				errorDetails, uri);
		return handleExceptionInternal(ex, exceptionMessageDTO, new org.springframework.http.HttpHeaders(),
				HttpStatus.NOT_FOUND, request);
	}

	@ExceptionHandler(value = {Exception.class })
	public ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {
		String type = "/erros/internal-server-error";
		String title = "iNTERNAL SERVER ERROR";
		String errorDetails = "cannot process the request due to ainternal server error";
		String uri = request.getDescription(true).split(";")[0];
		ExceptionMessageDTO exceptionMessageDTO = new ExceptionMessageDTO(type, title,
				HttpStatus.INTERNAL_SERVER_ERROR.value(), errorDetails, uri);
		return handleExceptionInternal(ex, exceptionMessageDTO, new org.springframework.http.HttpHeaders(),
				HttpStatus.NOT_FOUND, request);
	}

}

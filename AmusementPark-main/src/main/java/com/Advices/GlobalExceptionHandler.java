package com.Advices;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	// Activity not found exception
	@ExceptionHandler(ActivityNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundException(ActivityNotFoundException ex, WebRequest request)
	{
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
	}
	
	// For other exceptions
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globalExceptionHandler(Exception ex, WebRequest request)
	{
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
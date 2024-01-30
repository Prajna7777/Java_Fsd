package com.example.demo;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionhandler {

	//handles a customized exception 
	@ExceptionHandler(ResourceRequestNotFoundException.class)
public ResponseEntity<?> handleResourceRequestNotFoundException(ResourceRequestNotFoundException exception,WebRequest request){
	
	ErrorMsg error=new ErrorMsg(new Date(),exception.getMessage(),request.getDescription(false) );
	
	return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	
}
	
	//handles a predefined exception 
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleException(Exception exception,WebRequest request){
		
		ErrorMsg error=new ErrorMsg(new Date(),exception.getMessage(),request.getDescription(false) );
		
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
		
	}	
	
}

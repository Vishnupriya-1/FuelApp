package com.test.fuelApp.exception;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
    @Value(value = "${data.exception.message1}")
    private String message1;
    @Value(value = "${data.exception.message2}")
    private String message2;
    
    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity blogNotFoundException(UserNotFoundException userNotFoundException) {
        return new ResponseEntity<String>(message2, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(value = UserAlreadyExistsException.class)
    public ResponseEntity userAlreadyExistsException(UserAlreadyExistsException userAlreadyExistsException) {
        return new ResponseEntity<String>(message1, HttpStatus.CONFLICT);
    }
	
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ResponseBody
    public ResponseEntity handleMethodNotSupported(HttpServletRequest request) {
        return new ResponseEntity<String>("HTTP request method not supported for this operation.",HttpStatus.METHOD_NOT_ALLOWED);
    }
     
    @ExceptionHandler(IOException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ResponseEntity handleIOException(HttpServletRequest request, Exception ex) {
        return new ResponseEntity<String>("IO Error: " + ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    } 
    
    public ResponseEntity<String> handleMissingServletRequestParameter(
            MissingServletRequestParameterException ex, HttpHeaders headers,
            HttpStatus status, WebRequest request) {
		return new ResponseEntity<String>("Missing Parameters",HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler({ Exception.class })
	public ResponseEntity<String> handleAll(Exception ex, WebRequest request) {				
		return new ResponseEntity<String>("Error occurred. Please check!",HttpStatus.BAD_REQUEST);
	
	}
    
    public ResponseEntity<String> handleNoHandlerFoundException(
            NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		return new ResponseEntity<String>("Method not found for this URL!",HttpStatus.BAD_REQUEST);
        
    }

}

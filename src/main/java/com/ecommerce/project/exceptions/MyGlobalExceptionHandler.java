package com.ecommerce.project.exceptions;

import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ecommerce.project.payload.APIResponse;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class MyGlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<APIResponse> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException e) {

    	String message = e.getMessage();
       APIResponse apiResponse = new APIResponse(message, false);

        return new ResponseEntity<>(apiResponse,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<APIResponse> myResourceNotFoundException(ResourceNotFoundException e){
    	String message = e.getMessage();
    	APIResponse apiResponse = new APIResponse(message,false);
    	return new ResponseEntity<>(apiResponse,HttpStatus.NOT_FOUND);
    	}
    
    @ExceptionHandler(APIException.class)
    public ResponseEntity<APIResponse> myAPIException(APIException e){
    	String message = e.getMessage();
    	APIResponse apiResponse = new APIResponse(message,false);
    	return new ResponseEntity<>(apiResponse,HttpStatus.BAD_REQUEST);
    	}
}

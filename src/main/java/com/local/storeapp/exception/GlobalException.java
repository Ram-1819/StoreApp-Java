package com.local.storeapp.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.local.storeapp.model.ExceptionModel;

@RestControllerAdvice
public class GlobalException {
	@Autowired
	private ExceptionModel exceptionModel;
	@ExceptionHandler(Exception.class)
	public ExceptionModel exceptionHandler(Exception exception){
		exceptionModel.setMessage(exception.getMessage());
		exceptionModel.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR );
		return exceptionModel;
	}
}

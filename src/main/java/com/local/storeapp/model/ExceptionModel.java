package com.local.storeapp.model;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ExceptionModel {
	private String message;
	private HttpStatus httpStatus;
}

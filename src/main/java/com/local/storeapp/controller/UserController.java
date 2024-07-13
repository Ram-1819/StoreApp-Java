package com.local.storeapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.local.storeapp.entity.UserEntity;
import com.local.storeapp.model.User;
import com.local.storeapp.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/user")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "false", methods = { RequestMethod.GET,
		RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT }, allowedHeaders = "*")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public HttpStatus registerUser(@RequestBody UserEntity userEntity) throws Exception {
		userService.registerNewUserAccount(userEntity);
		return HttpStatus.OK;
	}

	@PostMapping("/login")
	public HttpStatus login(@RequestBody User user) throws Exception {
		HttpStatus httpStatus = userService.userLogin(user);
		return httpStatus;
	}
}

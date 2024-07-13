package com.local.storeapp.model;

import org.springframework.stereotype.Component;

import lombok.Data;
@Component
@Data
public class User {
	private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String password;
}

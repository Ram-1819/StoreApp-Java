package com.local.storeapp.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NonNull;

@Entity
@Data
@Table(name = "user")
public class UserEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
	@NonNull
    private String firstName;
	@NonNull
    private String lastName;
	@NonNull
    private String phoneNumber;
	@NonNull
    private String email;
	@NonNull
    private String password;
}

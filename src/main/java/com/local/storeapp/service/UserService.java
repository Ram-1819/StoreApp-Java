package com.local.storeapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.local.storeapp.entity.UserEntity;
import com.local.storeapp.model.User;
import com.local.storeapp.repository.UserRepo;

import lombok.NonNull;

@Service
public class UserService {
	@Autowired
	private UserRepo userRepo;

	public void registerNewUserAccount(UserEntity userEntity) throws Exception {
		if (emailExist(userEntity.getEmail())) {
			throw new Exception("There is an account with that email adress:" + userEntity.getEmail());
		}
		userEntity.setPassword(new BCryptPasswordEncoder().encode(userEntity.getPassword()));
		userRepo.save(userEntity);
	}

	private boolean emailExist(@NonNull String email) {
		if (userRepo.verifyEmail(email) != null) {
			return true;
		}
		return false;
	}

	public HttpStatus userLogin(User user) {
		if (userExist(user.getEmail(), user.getPassword())) {
			return HttpStatus.OK;
		}
		return HttpStatus.UNAUTHORIZED;
	}

	private boolean userExist(String email, String password) {
		boolean isUserValid = new BCryptPasswordEncoder().matches(password, userRepo.verifyUser(email));
		return isUserValid;
	}
}

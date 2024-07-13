package com.local.storeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.local.storeapp.entity.UserEntity;
import com.local.storeapp.model.User;

public interface UserRepo extends JpaRepository<UserEntity, Long> {
	@Query(value = "select email from user where user.email=:email", nativeQuery = true)
	public String verifyEmail(@Param("email") String email);
	@Query(value = "select password from user where user.email=:email", nativeQuery = true)
	public String verifyUser(@Param("email") String email);
}

package com.quan.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quan.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUsername(String username);


}

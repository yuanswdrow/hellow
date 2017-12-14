package com.loyal.service;

import java.util.List;

import com.loyal.common.entity.User;

public interface UserService {
	
	User login(String username, String password);
	
	List<User> selectAllUser();

	User findByUsername(String username);
	
	User findByUsernameCache(String username);

	

	
	
}
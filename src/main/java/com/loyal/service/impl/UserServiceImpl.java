package com.loyal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.loyal.common.entity.User;
import com.loyal.dao.UserMapper;
import com.loyal.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		User user = userMapper.findByUsername(username);
		if (user == null) {
			System.out.println("用户不存在");
		}
		if (!password.equals(user.getPassword())) {
			System.out.println("密码不准确");
		}
		return user;
	}

	@Override
	public List<User> selectAllUser() {
		// TODO Auto-generated method stub
		return userMapper.selectAllUser();
	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return userMapper.findByUsername(username);
	}

	
	
	//  使用------------ redis ---------------
	@Override
	@Cacheable(value="User",key="'username_'+#username")
	public User findByUsernameCache(String username) {
		// TODO Auto-generated method stub
		return userMapper.findByUsername(username);
	}
	
	
	
	

}
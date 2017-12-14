package com.loyal.dao;

import java.util.List;

import com.loyal.common.entity.User;

public interface UserMapper {

	int deleteByPrimaryKey(Long id);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);
	
	List<User> selectAllUser();

	User findByUsername(String username);
}
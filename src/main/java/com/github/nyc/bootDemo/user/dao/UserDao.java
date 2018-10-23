package com.github.nyc.bootDemo.user.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.github.nyc.bootDemo.user.domain.User;

@Mapper
public interface  UserDao {

	public User getUserById(Integer id);
	
	public List<User> getUserList();
}

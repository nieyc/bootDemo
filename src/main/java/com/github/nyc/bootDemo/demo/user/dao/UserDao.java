package com.github.nyc.bootDemo.demo.user.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.github.nyc.bootDemo.demo.user.domain.User;

//@Mapper
public interface  UserDao {

	public User getUserById(Integer id);
	
	public List<User> getUserList();
}

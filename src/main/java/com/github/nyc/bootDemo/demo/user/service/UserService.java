package com.github.nyc.bootDemo.demo.user.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import com.github.nyc.bootDemo.demo.user.dao.UserDao;
import com.github.nyc.bootDemo.demo.user.domain.User;

@Service
public class UserService {
	
	 @Autowired
	 RedisTemplate<Object,Object> redisTemplate;
	 
	 
	 @Resource
	 private UserDao userDao;
		
	
	public User getUser() {
        User user=userDao.getUserById(1);
        return user;
	}
	
	public List<User> getUserList(){
		return userDao.getUserList();
	}

}

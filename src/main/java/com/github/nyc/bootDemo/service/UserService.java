package com.github.nyc.bootDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.github.nyc.bootDemo.domain.User;

@Service
public class UserService {
	
	 @Autowired
	 RedisTemplate<Object,Object> redisTemplate;
	
	public User getUser() {
		User user=new User();
        user.setUserName("zhangsan");
        user.setPassWord("123456");
        redisTemplate.opsForValue().set("user", user);
        return user;
	}

}

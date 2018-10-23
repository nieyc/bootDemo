package com.github.nyc.bootDemo.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.github.nyc.bootDemo.user.domain.User;
import com.github.nyc.bootDemo.user.service.UserService;
import com.github.nyc.bootDemo.util.RedisUtil;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Value("${com.github.nyc.url}")
	private String url;
	
	@Autowired
	UserService userService;
    
    @Autowired
    RedisUtil redisUtil;
	
	@RequestMapping("/getUserFromDb")
    public User getUser() {
        User user=userService.getUser();
        redisUtil.setObj("user",user);
        return user;
    }
	
	
	@RequestMapping("/getUserFromRedis")
    public User getUserFromRedis() {
		User user=(User)redisUtil.getObj("user");
		System.out.println("name:"+user.getName()+" age:"+user.getAge());
        return user;
    }

}

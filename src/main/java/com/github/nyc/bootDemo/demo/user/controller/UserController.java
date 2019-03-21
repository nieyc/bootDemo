package com.github.nyc.bootDemo.demo.user.controller;

import com.github.nyc.bootDemo.demo.user.domain.User;
import com.github.nyc.bootDemo.demo.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    RedisTemplate<Object,Object> redisTemplate;
	
	@RequestMapping("/getUserFromDb")
    public User getUser() {
        User user=userService.getUser();
        redisTemplate.opsForValue().set("user",user);
        return user;
    }
	
	
	@RequestMapping("/getUserFromRedis")
    public User getUserFromRedis() {
		User user=(User) redisTemplate.opsForValue().get("user");
		System.out.println("name:"+user.getName()+" age:"+user.getAge());
        return user;
    }

}

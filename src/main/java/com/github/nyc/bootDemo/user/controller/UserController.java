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
    
    
    /**
     * 测试用例准备
     * @see com.github.nyc.bootDemo.UserTest
     * @return
     */
    @RequestMapping("/hello")
    public String hello() {
        return "Greetings from Spring Boot!";
    }
    
	
    /**
     * 从数据库取值，并且set到redis
     * @return
     */
	@RequestMapping("/getUserFromDb")
    public User getUser() {
        User user=userService.getUser();
        redisUtil.set("user", user);
        return user;
    }
	
	
	@RequestMapping("/getUserFromRedis")
    public User getUserFromRedis() {
		boolean b=redisUtil.hasKey("user");
		logger.debug("b:"+b);
        User user1=(User)redisUtil.get("user");
        logger.debug("user1:"+user1);
        return user1;
    }

}

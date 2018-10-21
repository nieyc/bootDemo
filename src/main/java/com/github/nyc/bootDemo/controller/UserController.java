package com.github.nyc.bootDemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.github.nyc.bootDemo.domain.User;
import com.github.nyc.bootDemo.service.UserService;
import com.github.nyc.bootDemo.util.RedisUtil;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	UserService userService;
    
    @Autowired
    RedisUtil redisUtil;
	
	@RequestMapping("/getUser")
    public User getUser() {
		logger.debug("********************************"+redisUtil);
        User user=userService.getUser();
        user=(User)redisUtil.get("user");
        System.out.println(user.getUserName()+user.getPassWord());
        return user;
    }
	
	
	@RequestMapping("/getUser1")
    public User getUser1() {
		boolean b=redisUtil.hasKey("user");
		logger.debug("b:"+b);
        User user1=(User)redisUtil.get("user");
        logger.debug("user1:"+user1);
        return user1;
    }

}

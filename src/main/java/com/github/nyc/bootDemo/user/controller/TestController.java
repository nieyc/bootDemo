package com.github.nyc.bootDemo.user.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.github.nyc.bootDemo.user.domain.User;
import com.github.nyc.bootDemo.user.service.UserService;

@Controller
@RequestMapping("/user")
public class TestController {
	
	@Autowired
	UserService userService;
    
	
	
	/**
	 * 返回页面模板user.html ,并且展示数据
	 * @param model
	 * @return
	 */
	@RequestMapping("/getUser")
    public String getUser(Model model) {
        List<User> users=userService.getUserList();
        model.addAttribute("users",users);
        return "user";
    }

}

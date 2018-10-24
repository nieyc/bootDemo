package com.github.nyc.bootDemo.hello;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.nyc.bootDemo.user.domain.User;
import com.github.nyc.bootDemo.user.service.UserService;

@Controller
public class GreetingController {

	@Autowired
	UserService userService;
	
	@GetMapping("/index")
    public String index() {
        return "static/index";
    }
	
	
	@GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
	
	
	/**
	 * http://localhost:8080/getUser
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

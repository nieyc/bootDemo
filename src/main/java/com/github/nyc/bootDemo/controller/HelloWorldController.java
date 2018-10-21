package com.github.nyc.bootDemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.nyc.bootDemo.domain.User;

@RestController
public class HelloWorldController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Value("${com.github.nyc.url}")
	private String url;
	
	@RequestMapping("/hello")
    public String index() {
		logger.debug("url:"+url);
        return "Hello World,this is first demo";
    }
	
	
	
	

}

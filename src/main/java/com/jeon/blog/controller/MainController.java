package com.jeon.blog.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	
    @GetMapping("/")
    public String main(){
    	
    	logger.trace("Trace Level 테스트"); 
    	logger.debug("DEBUG Level 테스트"); 
    	logger.info("INFO Level 테스트"); 
    	logger.warn("Warn Level 테스트"); 
    	logger.error("ERROR Level 테스트");

        return "main/main";
    }
    
    @GetMapping("/main2")
    public String main2(){
        return "main/main2";
    }
}

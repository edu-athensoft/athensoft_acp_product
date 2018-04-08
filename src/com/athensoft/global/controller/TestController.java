package com.athensoft.global.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The global controller
 * @author Athens
 *
 */
@Controller
public class TestController {
	
	/**
	 * test page
	 * @return
	 */
	@RequestMapping("/test")
	public String doTest(){
		return "events/test_event_news_list";
	}
	
	
}

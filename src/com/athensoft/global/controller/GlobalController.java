package com.athensoft.global.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The global controller
 * @author Athens
 *
 */
@Controller
public class GlobalController {
	
	/**
	 * go to home page
	 * @return
	 */
	@RequestMapping("/")
	public String gotoHome(){
		return "index";
	}
	
	/**
	 * go to home page
	 * @return
	 */
	@RequestMapping("/index")
	public String gotoHome2(){
		return "index";
	}
	
}

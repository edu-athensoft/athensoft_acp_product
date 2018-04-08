package com.athensoft.ecomm.uaas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UaasAcpController {

	@RequestMapping("login")
	public String gotoLogin(){
		return "uaas/login_soft";
	}
}

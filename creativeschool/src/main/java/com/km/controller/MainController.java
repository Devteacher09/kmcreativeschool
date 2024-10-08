package com.km.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String main() {
		return "index";
	}
	
	@RequestMapping("/police/policeenroll.do")
	public String policeLogin() {
		return "police/policeenroll";
	}
	
	@RequestMapping("/police/findIdPw.do")
	public String policeFindIdPw() {
		return "police/findIdPw";
	}
	
}

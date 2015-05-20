package com.sds.icto.mysite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping(value={"/index","","/"})
	public String index(){
		System.out.println("IndexController");
		return "main/index";
	}
	
}

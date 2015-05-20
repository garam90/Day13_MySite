package com.sds.icto.mysite.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sds.icto.mysite.service.MemberService;
import com.sds.icto.mysite.vo.MemberVO;


@RequestMapping("/user")
@Controller
public class UserController {

	@Autowired
	MemberService memberService;
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(@ModelAttribute MemberVO vo){
		memberService.joinUser(vo);
		return "redirect:/index";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String joinForm(){
		return "user/joinform";
	}

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String LoginForm(){
		return "user/loginform";
	}
	
	@RequestMapping("/uinfo")
	public String uInfo(){
		return "user/updateform";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String Login(@ModelAttribute MemberVO vo, HttpSession session, Model model){
		
		MemberVO member = memberService.login(vo);
		if(member == null){
			
			return "redirect:/user/login?result=fail";
		}
		
		session.setAttribute("name", member.getName());
		session.setAttribute("email", member.getEmail());
		return "redirect:/index";
	}
	
	@RequestMapping("/logout")
	public String Logout(HttpSession session){
		session.removeAttribute("name");
		session.removeAttribute("email");
		session.invalidate();
		return "redirect:/index";
	}
	
	@RequestMapping("/update")
	public String uUpdate(@ModelAttribute MemberVO vo, HttpSession session){
		String email = (String) session.getAttribute("email");
		vo.setEmail(email);
		memberService.update(vo); 
		
		return "redirect:/index";
	}
}

package com.sds.icto.mysite.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sds.icto.mysite.service.GuestBookService;
import com.sds.icto.mysite.vo.GuestBookVO;

@Controller
@RequestMapping("/guestbook")
public class GuestBookController {

	@Autowired
	GuestBookService guestBookService;
	
	@RequestMapping(value={"/index","/","", "/list"})
	public String index(Model model){
		
		ArrayList<GuestBookVO> list = new ArrayList<GuestBookVO>();
		
		list = guestBookService.getList();
		model.addAttribute("list", list);	
		return "guestbook/list";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(@RequestParam String name, @RequestParam String password, @RequestParam("content") String message){
		
		GuestBookVO vo = new GuestBookVO();
		vo.setName(name);
		vo.setPassword(password);
		vo.setMessage(message);
		
		guestBookService.insert(vo);
		
		return "redirect:/guestbook/list";
	}
	
	@RequestMapping("/deleteform")
	public String deleteForm(@RequestParam int no, Model model){

		model.addAttribute("id",no);
		
		return "guestbook/deleteform";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam int id, @RequestParam String password){

		guestBookService.delete(id, password);
		
		return "redirect:/guestbook/list";
	}
	
	
}

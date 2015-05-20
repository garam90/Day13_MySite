package com.sds.icto.mysite.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sds.icto.mysite.service.BoardService;
import com.sds.icto.mysite.vo.BoardVO;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	BoardService boardService;
	
	@RequestMapping(value={"/list","","/"})
	public String boardList(Model model){
		
		ArrayList<BoardVO> list = boardService.boardList();
		model.addAttribute("list",list);
		return "board/boardlist";
	}
	@RequestMapping("/search")
	public String search(Model model, @RequestParam String keyword){
		
		ArrayList<BoardVO> list = boardService.search(keyword);
		model.addAttribute("list",list);
		return "board/boardlist";
	}
	@RequestMapping("/delete/{no}")
	public String delete(@PathVariable int no){
		
		boardService.delete(no);
		
		return "redirect:/board/list";
	}
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(@ModelAttribute BoardVO vo, HttpServletRequest request){
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		vo.setUserId(email);
		
		boardService.insert(vo);
		
		return "redirect:/board/list";
	}
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String insertForm(){
		
		return "board/insertBoard";
		
	}
	@RequestMapping("/detail/{no}")
	public String detail(Model model, @PathVariable int no){
		
		BoardVO vo = boardService.detail(no);
		model.addAttribute("board", vo);
		return "board/boardDetail";
	}
	@RequestMapping(value="/update/{no}", method=RequestMethod.GET)
	public String updateForm(Model model, @PathVariable int no){
		BoardVO vo = boardService.detail(no);
		model.addAttribute("board", vo);
		return "board/updateBoard";
	}
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(BoardVO vo, @RequestParam int no){
		vo.setNo(no);
		boardService.update(vo);
		
		return "redirect:/board/detail/"+vo.getNo();
	}
	
	
}

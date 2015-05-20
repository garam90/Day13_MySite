package com.sds.icto.mysite.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sds.icto.mysite.dao.BoardDAO;
import com.sds.icto.mysite.vo.BoardVO;

@Service
public class BoardService {

	@Autowired
	BoardDAO boardDAO;

	public ArrayList<BoardVO> boardList() {

		ArrayList<BoardVO> list = boardDAO.boardList();
		
		return list;
		
	}

	public ArrayList<BoardVO> search(String keyword) {
		
		ArrayList<BoardVO> list = boardDAO.searchBoard(keyword);
		
		return list;
	}

	public void delete(int no) {
		
		boardDAO.delete(no);
	
	}

	public void insert(BoardVO vo) {
		
		boardDAO.insert(vo);
		
	}

	public BoardVO detail(int no) {
		
		boardDAO.updateViewC(no);
		BoardVO vo = boardDAO.boardDetail(no);
		
		return vo;
	}

	public void update(BoardVO vo) {
		
		boardDAO.update(vo);
		
	}
	
	
	
}

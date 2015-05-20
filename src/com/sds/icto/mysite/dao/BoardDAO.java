package com.sds.icto.mysite.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.sds.icto.mysite.vo.BoardVO;

@Repository
public class BoardDAO {

	@Autowired
	SqlMapClientTemplate sqlMapClientTemplate;
	
	public void insert(BoardVO vo) {
		
		sqlMapClientTemplate.insert("board.insert", vo);
		
	}

	public ArrayList<BoardVO> boardList() {
		
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		
		list = (ArrayList<BoardVO>) sqlMapClientTemplate.queryForList("board.getList");
		
		return list;
	}
	
	public void updateViewC(int no) {
		
		HashMap<String, Integer> map = new HashMap<String, Integer>(); 
		map.put("no", no);
		sqlMapClientTemplate.update("board.updateView", map);
		
	}
	
	public BoardVO boardDetail(int no)  {
		BoardVO vo = new BoardVO();

		HashMap<String, Integer> map = new HashMap<String, Integer>(); 
		map.put("no", no);
		vo = (BoardVO) sqlMapClientTemplate.queryForObject("board.boardDetail", map);
		
		return vo;
	}
	public ArrayList<BoardVO> searchBoard(String keyword){
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		HashMap<String, String> map = new HashMap<String, String>(); 
		map.put("keyword", keyword);
		list = (ArrayList<BoardVO>) sqlMapClientTemplate.queryForList("board.search", map);
		
		return list;
	}
	
	public void delete(int no) {
		
		HashMap<String, Integer> map = new HashMap<String, Integer>(); 
		map.put("no", no);
		sqlMapClientTemplate.delete("board.delete", map);
		
	}

	public void update(BoardVO vo) {

		sqlMapClientTemplate.update("board.update", vo);
		
	}
}

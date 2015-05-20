package com.sds.icto.mysite.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sds.icto.mysite.dao.GuestBookDAO;
import com.sds.icto.mysite.vo.GuestBookVO;

@Service
public class GuestBookService {

	@Autowired
	GuestBookDAO guestBookDAO;
	
	public ArrayList<GuestBookVO> getList() {
		ArrayList<GuestBookVO> list = guestBookDAO.guestBookList(); 
		return list;	
	}

	public void insert(GuestBookVO vo) {
		guestBookDAO.insert(vo);
	}

	public void delete(int id, String password) {
		
		guestBookDAO.delete(id, password);
		
	}

	
	
}

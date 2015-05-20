package com.sds.icto.mysite.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.sds.icto.mysite.vo.GuestBookVO;

@Repository
public class GuestBookDAO {
	
	@Autowired
	SqlMapClientTemplate sqlMapClientTemplate;
	
	public void insert(GuestBookVO vo){
		
		sqlMapClientTemplate.insert("guestbook.insert", vo);
		
	}

	public ArrayList<GuestBookVO> guestBookList(){
		ArrayList<GuestBookVO> list = new ArrayList<GuestBookVO>();

		list = (ArrayList<GuestBookVO>) sqlMapClientTemplate.queryForList("guestbook.getList");
		
		return list;
	}

	public void delete(int no, String password) {

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("no", no);
		map.put("password", password);
		
		sqlMapClientTemplate.delete("guestbook.delete", map);
		
	}
}

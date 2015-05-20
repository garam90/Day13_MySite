package com.sds.icto.mysite.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.sds.icto.mysite.vo.MemberVO;

@Repository
public class MemberDAO {

	@Autowired
	SqlMapClientTemplate sqlMapClientTemplate;

	public void insertMember(MemberVO vo){
		
		sqlMapClientTemplate.insert("member.insert", vo);
		
	}
	
	public MemberVO login(MemberVO vo){
		MemberVO member = null;
		
		member = (MemberVO) sqlMapClientTemplate.queryForObject("member.login",vo);
		
		return member;
	}
	
	public void updateMember(MemberVO vo){
		
		sqlMapClientTemplate.update("member.update", vo);
		
	}
	
}

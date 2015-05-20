package com.sds.icto.mysite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sds.icto.mysite.dao.MemberDAO;
import com.sds.icto.mysite.vo.MemberVO;

@Service
public class MemberService {

	@Autowired
	MemberDAO memberDAO;
	
	public void joinUser(MemberVO vo) {
		
		memberDAO.insertMember(vo);
		
	}

	public MemberVO login(MemberVO vo) {

		MemberVO member = memberDAO.login(vo);

		return member;
		
	}

	public void update(MemberVO vo) {

		memberDAO.updateMember(vo);
		
	}

}

package com.sds.icto.mysite.action.user;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.mysite.dao.MemberDAO;
import com.sds.icto.mysite.vo.MemberVO;
import com.sds.icto.web.Action;

public class InsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, ServletException,
			IOException {
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
	
		MemberVO vo = new MemberVO();
		vo.setName(name);
		vo.setEmail(email);
		vo.setPassword(password);
		vo.setGender(gender);

		MemberDAO dao = new MemberDAO();
		dao.insertMember(vo);
		
		response.sendRedirect("/Day05_MySite/views/user/joinsuccess.jsp");
		
	}

}

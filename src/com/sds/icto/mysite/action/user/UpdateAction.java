package com.sds.icto.mysite.action.user;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sds.icto.mysite.dao.MemberDAO;
import com.sds.icto.mysite.vo.MemberVO;
import com.sds.icto.web.Action;

public class UpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, ServletException,
			IOException {
		
		HttpSession session = request.getSession(false);
		String email = (String) session.getAttribute("email");
		
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		System.out.println("update");
		System.out.println("email >>"+ email);
		System.out.println("name >>"+ name);
		System.out.println("password >>"+ password);
		
		MemberVO vo = new MemberVO();
		vo.setEmail(email);
		vo.setName(name);
		vo.setPassword(password);
		
		MemberDAO dao = new MemberDAO();
		dao.updateMember(vo);
		
		response.sendRedirect("/Day05_MySite");
		
	}

}

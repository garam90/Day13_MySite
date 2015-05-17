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

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, ServletException,
			IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		MemberVO vo = new MemberVO();
		vo.setEmail(email);
		vo.setPassword(password);
		
		MemberDAO dao = new MemberDAO();
		MemberVO member = dao.login(vo);
		

		if(member.getName() != null){
			// 로그인 성공
			HttpSession session = request.getSession(true);
			session.setAttribute("name", member.getName());
			session.setAttribute("email", member.getEmail());
			response.sendRedirect("");
		}else{
			// 로그인 실패
			request.setAttribute("msg", "로그인 실패ㅋ");
			request.getRequestDispatcher("/user?a=loginform").forward(request, response);
		}
		
	}

}

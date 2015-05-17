package com.sds.icto.mysite.action.user;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sds.icto.web.Action;

public class LogoutAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, ServletException,
			IOException {

		HttpSession session = request.getSession(false);	
		
		if(session!=null){
			session.removeAttribute("name");
			session.invalidate();
		}
		response.sendRedirect("/Day05_MySite");
		
	}

}

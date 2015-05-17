package com.sds.icto.mysite.action.guestbook;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.mysite.dao.GuestBookDAO;
import com.sds.icto.mysite.vo.GuestBookVO;
import com.sds.icto.web.Action;

public class insertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, ServletException,
			IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("pass");
		String message = request.getParameter("content");
		
		GuestBookVO vo = new GuestBookVO();
		vo.setName(name);
		vo.setPassword(password);
		vo.setMessage(message);

		GuestBookDAO dao = new GuestBookDAO();
		try {
			dao.insert(vo);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("guest");
	}

}

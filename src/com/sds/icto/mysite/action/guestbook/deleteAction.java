package com.sds.icto.mysite.action.guestbook;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.mysite.dao.GuestBookDAO;
import com.sds.icto.web.Action;

public class deleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, ServletException,
			IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		GuestBookDAO dao = new GuestBookDAO();
		try {
			dao.delete(Integer.parseInt(id), password);
		} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("/Day05_MySite/guest");	
	}

}

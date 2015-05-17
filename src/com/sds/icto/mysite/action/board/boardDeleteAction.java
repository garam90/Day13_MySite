package com.sds.icto.mysite.action.board;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.mysite.dao.BoardDAO;
import com.sds.icto.web.Action;

public class boardDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, ServletException,
			IOException {
		String no = request.getParameter("no");
		BoardDAO dao = new BoardDAO();
		dao.delete(Integer.parseInt(no));
		
		response.sendRedirect("/Day05_MySite/board");
	}

}

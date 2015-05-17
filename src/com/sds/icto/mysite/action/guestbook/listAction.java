package com.sds.icto.mysite.action.guestbook;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.mysite.dao.GuestBookDAO;
import com.sds.icto.mysite.vo.GuestBookVO;
import com.sds.icto.web.Action;

public class listAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, ServletException,
			IOException {
		GuestBookDAO dao = new GuestBookDAO();
		ArrayList<GuestBookVO> list = new ArrayList<GuestBookVO>();
		try {
			list = dao.guestBookList();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("list", list);
		request.getRequestDispatcher("/views/guestbook/list.jsp").forward(request, response);
	}

}

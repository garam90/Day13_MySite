package com.sds.icto.mysite.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.mysite.action.guestbook.GuestActionFactory;
import com.sds.icto.web.Action;

@WebServlet("/guest")
public class GuestBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GuestBookServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		GuestActionFactory af = GuestActionFactory.getInstance();
		Action act = af.getAction(action);
		try {
			act.execute(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
}

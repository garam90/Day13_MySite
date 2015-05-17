package com.sds.icto.mysite.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.mysite.action.user.UserActionFactory;
import com.sds.icto.web.Action;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/user")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String a = request.getParameter("a");
		
		UserActionFactory af = UserActionFactory.getInstance();
		Action action = af.getAction(a);
		try {
			action.execute(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

}

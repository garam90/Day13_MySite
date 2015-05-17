package com.sds.icto.mysite.action.user;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.web.Action;

public class LoginFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, ServletException,
			IOException {
		
		request.getRequestDispatcher("/views/user/loginform.jsp").forward(request, response);
		
	}

}

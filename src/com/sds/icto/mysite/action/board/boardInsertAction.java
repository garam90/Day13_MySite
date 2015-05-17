package com.sds.icto.mysite.action.board;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sds.icto.mysite.dao.BoardDAO;
import com.sds.icto.mysite.vo.BoardVO;
import com.sds.icto.web.Action;

public class boardInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, ServletException,
			IOException {
		HttpSession session = request.getSession(false);
		String userId = null;		
		if(session!=null){
			userId = (String) session.getAttribute("email");
		}
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setUserId(userId);
		
		BoardDAO dao = new BoardDAO();
		dao.insert(vo);
		
		response.sendRedirect("/Day05_MySite/board");
	}

}

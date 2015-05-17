package com.sds.icto.mysite.action.board;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.mysite.dao.BoardDAO;
import com.sds.icto.mysite.vo.BoardVO;
import com.sds.icto.web.Action;

public class boardSearchAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, ServletException,
			IOException {
		
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		
		String keyword = request.getParameter("keyword");
		BoardDAO dao = new BoardDAO();
		list = dao.searchBoard(keyword);
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/views/board/boardlist.jsp").forward(request, response);
		
	}

}

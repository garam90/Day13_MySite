package com.sds.icto.mysite.action.board;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.mysite.dao.BoardDAO;
import com.sds.icto.mysite.vo.BoardVO;
import com.sds.icto.web.Action;

public class boardUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, ServletException,
			IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String no = request.getParameter("no");
		BoardVO vo = new BoardVO();
		vo.setNo(Integer.parseInt(no));
		vo.setTitle(title);
		vo.setContent(content);
		
		BoardDAO dao = new BoardDAO();
		dao.update(vo);
		
		BoardVO board = dao.boardDetail(Integer.parseInt(no));
		request.setAttribute("board", board);
		request.getRequestDispatcher("/views/board/boardDetail.jsp").forward(request, response);
		
	}

}

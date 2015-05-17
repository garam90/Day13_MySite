package com.sds.icto.mysite.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sds.icto.mysite.vo.BoardVO;

public class BoardDAO {
	private Connection getConnection() throws ClassNotFoundException,
			SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		Connection conn = DriverManager.getConnection(url, "webdb", "webdb");
		return conn;
	}

	public void insert(BoardVO vo) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		PreparedStatement stmt = null;
		String sql = "insert into board values (board_no_seq.nextval, ? , ? , ? , sysdate, 0)";
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, vo.getTitle());
		stmt.setString(2, vo.getContent());
		stmt.setString(3, vo.getUserId());
		stmt.executeUpdate();
		
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public ArrayList<BoardVO> boardList() throws ClassNotFoundException, SQLException {
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		
		Connection conn = getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "select * from board order by reg_date";
		stmt = conn.prepareStatement(sql);
		rs = stmt.executeQuery();
		while (rs.next()) {
			BoardVO vo = new BoardVO();
			vo.setNo(rs.getInt(1));
			vo.setTitle(rs.getString(2));
			vo.setContent(rs.getString(3));
			vo.setUserId(rs.getString(4));
			vo.setReg_date(rs.getDate(5));
			vo.setViewC(rs.getInt(6));
			list.add(vo);
		}
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public void updateViewC(int no) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		PreparedStatement stmt = null;
		
		String sql = "update board set viewC = (select viewC from board where no = ?)+1 where no = ?";
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, no);
		stmt.setInt(2, no);
		stmt.executeUpdate();
		
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public BoardVO boardDetail(int no) throws ClassNotFoundException, SQLException {
		
		Connection conn = getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		BoardVO vo = new BoardVO();
		
		String sql = "select * from board where no = ?";
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, no);
		rs = stmt.executeQuery();
		while (rs.next()) {
			vo = new BoardVO();
			vo.setNo(rs.getInt(1));
			vo.setTitle(rs.getString(2));
			vo.setContent(rs.getString(3));
			vo.setUserId(rs.getString(4));
			vo.setReg_date(rs.getDate(5));
			vo.setViewC(rs.getInt(6));
		}
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return vo;
	}
	public ArrayList<BoardVO> searchBoard(String keyword) throws ClassNotFoundException, SQLException {
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		Connection conn = getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "select * from board where title like '%'|| ? ||'%'";
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, keyword);
		rs = stmt.executeQuery();
		
		while (rs.next()) {
			BoardVO vo = new BoardVO();
			vo.setNo(rs.getInt(1));
			vo.setTitle(rs.getString(2));
			vo.setContent(rs.getString(3));
			vo.setUserId(rs.getString(4));
			vo.setReg_date(rs.getDate(5));
			vo.setViewC(rs.getInt(6));
			list.add(vo);
		}
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public void delete(int no) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		PreparedStatement stmt = null;
		String sql = "delete from board where no = ?";
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, no);
		stmt.executeUpdate();
		
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void update(BoardVO vo) throws ClassNotFoundException, SQLException{
		Connection conn = getConnection();
		PreparedStatement stmt = null;
		String sql = "update board set title = ? , content = ? where no = ?";
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, vo.getTitle());
		stmt.setString(2, vo.getContent());
		stmt.setInt(3, vo.getNo());
		stmt.executeUpdate();
		
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

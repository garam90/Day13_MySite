package com.sds.icto.mysite.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sds.icto.mysite.vo.GuestBookVO;

public class GuestBookDAO {
	
	private Connection getConnection() throws ClassNotFoundException,
			SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		Connection conn = DriverManager.getConnection(url, "webdb", "webdb");
		return conn;
	}

	public void insert(GuestBookVO vo) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		PreparedStatement stmt = null;
		String sql = "insert into guestbook values (guestbook_seq.nextval, ? , ? , ? ,sysdate)";
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, vo.getName());
		stmt.setString(2, vo.getPassword());
		stmt.setString(3, vo.getMessage());
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

	public ArrayList<GuestBookVO> guestBookList() throws ClassNotFoundException, SQLException {
		ArrayList<GuestBookVO> list = new ArrayList<GuestBookVO>();
		
		Connection conn = getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "select * from guestbook order by reg_date";
		stmt = conn.prepareStatement(sql);
		rs = stmt.executeQuery();
		while (rs.next()) {
			GuestBookVO vo = new GuestBookVO();
			vo.setNo(rs.getInt(1));
			vo.setName(rs.getString(2));
			vo.setPassword(rs.getString(3));
			vo.setMessage(rs.getString(4));
			vo.setReg_date(rs.getDate(5));
			
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

	public void delete(int no, String password) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		PreparedStatement stmt = null;
		
		String sql = "delete from guestbook where no = ? and password = ?";
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, no);
		stmt.setString(2, password);
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

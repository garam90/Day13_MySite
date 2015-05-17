package com.sds.icto.mysite.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sds.icto.mysite.vo.MemberVO;

public class MemberDAO {

	private Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		Connection conn = DriverManager.getConnection(url, "webdb", "webdb");
		return conn;
	}

	public void insertMember(MemberVO vo) throws ClassNotFoundException, SQLException{
		Connection conn = getConnection();
		String sql = "insert into member values (member_no_seq.nextval, ?,?,?,?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, vo.getName());
		stmt.setString(2, vo.getEmail());
		stmt.setString(3, vo.getPassword());
		stmt.setString(4, vo.getGender());
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
	
	public MemberVO login(MemberVO vo) throws SQLException, ClassNotFoundException{
		MemberVO member = new MemberVO();
		
		Connection conn = getConnection();
		String sql = "select * from member where email = ? and password = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, vo.getEmail());
		stmt.setString(2, vo.getPassword());
		
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			member.setName(rs.getString(2));
			member.setEmail(rs.getString(3));
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
		return member;
	}
	
	public void updateMember(MemberVO vo) throws ClassNotFoundException, SQLException{
		
		Connection conn = getConnection();
		String sql = "update member set name = ? , password = ? where email = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, vo.getName());
		stmt.setString(2, vo.getPassword());
		stmt.setString(3, vo.getEmail());
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

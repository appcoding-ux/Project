package com.shard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.shard.dto.ShardMemberVO;

import oracle.jdbc.proxy.annotation.Pre;

public class ShardMemberDAO {
	private static ShardMemberDAO instance = new ShardMemberDAO();
	
	public static ShardMemberDAO getInstance() {
		return instance;
	}
	
	private ShardMemberDAO() {		
	}
	
	public Connection getConnection() throws Exception {
		Connection con = null;
		Context initContext = new InitialContext();
		Context envContext = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
		con = ds.getConnection();
		return con;
	}
	
	// 로그인 입력 폼에서 받은 정보를 데이터베이스에 있는 정보와 대조하는 메소드
	public int userCheck(String userId, String userPwd) {
		int result = -1;
		String sql = "select userPwd from shardmember where userid = ?";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				if(rs.getString("userPwd")!=null && rs.getString("userPwd").equals(userPwd)) {
					result = 1;
				}else {
					result = 0;
				}
			}else {
				result = -1;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(con != null) con.close();
				if(ps != null) ps.close();
				if(rs != null) rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	//관리자로 체크하고 로그인을 시도했을 때 작동하는 메소드
	public int adminCheck(String userId, String userPwd) {
		return 0;
	}
	
	public ShardMemberVO getMember(String userId) {
		ShardMemberVO vo = null;
		String sql = "select * from shardmember where userId = ?";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				vo = new ShardMemberVO();
				vo.setUserNo(rs.getString("no"));
				vo.setUserId(rs.getString("userId"));
				vo.setUserPwd(rs.getString("userPwd"));
				vo.setUserName(rs.getString("userName"));
				vo.setMemberShip(rs.getString("membership"));
				vo.setUserEmail(rs.getString("USEREMAIL"));
				vo.setUserBirth(rs.getString("USERBIRTH"));
				vo.setUserPhone(rs.getString("USERPHONE"));
				vo.setRegiDate(rs.getString("REGIDATE"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(con != null) con.close();
				if(ps != null) ps.close();
				if(rs != null) rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return vo;
	}
	
	public int idCheck(String userid) {
		int result = -1;
		
		String sql = "select userid from shardmember where userid = ?";
		
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userid);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				result = 1;
			}else {
				result = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(con != null) con.close();
				if(rs != null) rs.close();
				if(ps != null) ps.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	// joinForm으로 회원가입을 시도할 때 작동할 insert메서드
	public int insertMember(ShardMemberVO vo) {
		int result = 0;
		
		String sql = "insert into shardmember values(no_seq.nextval, ?, ?, ? , 'Lovy',? ,?, ?, sysdate, 0, '', 0)";
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getUserId());
			ps.setString(2, vo.getUserPwd());
			ps.setString(3, vo.getUserName());
			ps.setString(4, vo.getUserEmail());
			ps.setString(5, vo.getUserBirth());
			ps.setString(6, vo.getUserPhone());
			
			ps.executeUpdate();
			result = 1;
			
		} catch (Exception e) {
			result = 0;
			e.printStackTrace();
		}finally {
			try {
				if(con != null) con.close();
				if(ps != null) ps.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
}

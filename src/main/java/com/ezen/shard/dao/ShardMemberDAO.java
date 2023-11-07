package com.ezen.shard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ezen.shard.dto.ShardMemberVO;
import com.shard.util.DBManager;

public class ShardMemberDAO {
	private static ShardMemberDAO instance = new ShardMemberDAO();
	
	public static ShardMemberDAO getInstance() {
		return instance;
	}
	
	private ShardMemberDAO() {		
	}
	
	// 로그인 입력 폼에서 받은 정보를 데이터베이스에 있는 정보와 대조하는 메소드 + 추가로 관리자까지 체크
	public int userCheck(String userId, String userPwd) {
		int result = -1;
		String sql = "select userPwd,AUTHCODE from CUSTOMER where userid = ?";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				if(rs.getString("userPwd")!=null && rs.getString("userPwd").equals(userPwd)) {
					if(rs.getInt("AUTHCODE") == 1) {
						result = 7;
					}else {
						result = 1;
					}
				}else {
					result = -1;
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
	
	// userId 값을 넘겨서 select구문을 통해 userId에 맞는 모든 데이터 출력
	public ShardMemberVO getMember(String userId) {
		ShardMemberVO vo = null;
		String sql = "select * from shardmember where userId = ?";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DBManager.getConnection();
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
				DBManager.close(con, ps, rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return vo;
	}
	
	// ajax를 통해 DB에 있는 userId를 검사해서 데이터베이스에 일치하는 아이디가 있는지 검사
	public int idCheck(String userid) {
		int result = -1;
		
		String sql = "select userid from shardmember where userid = ?";
		
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DBManager.getConnection();
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
				DBManager.close(con, ps, rs);
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
			con = DBManager.getConnection();
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
				DBManager.close(con, ps);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
}

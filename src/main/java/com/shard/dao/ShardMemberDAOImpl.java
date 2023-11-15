package com.shard.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.shard.domain.ShardMemberVO;
import com.shard.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ShardMemberDAOImpl implements ShardMemberDAO {
	
	private final UserMapper usermapper;

	@Override
	public int userCheck(String userId, String userPwd) {
		int result = 0;
		String pwd = usermapper.userCheck(userId);
		if(pwd.equals(userPwd)) {
			result = 1;
		}else {
			result = 0;
		}
		
		
		return result;
	}

	@Override
	public int idCheck(String userid) {
		int result = -1;
		
		String id = usermapper.getUserId(userid);
		System.out.println(id);
		
		if(id != null) // 데이터베이스에 아이디가 있을 때
			result = 1;
		else // 데이터베이스에 아이디가 없을 때
			result = 0;
		
		return result;
	}

	@Override
	public int insertUser(ShardMemberVO vo) {
		int result = 1;
		return result;
	}

	@Override
	public List<ShardMemberVO> getUserList() {
		return usermapper.getUserList();
	}

	@Override
	public ShardMemberVO getUser(String userId) {
		return usermapper.getUser(userId);
	}

	@Override
	public ShardMemberVO getUserEmail(String email) {
		return usermapper.getUserEmail(email);
	}

	@Override
	public boolean updateUser(ShardMemberVO vo) {
		return usermapper.updateUser(vo) == 1;
	}

	@Override
	public boolean deleteUser(String userId) {
		return usermapper.deleteUser(userId) == 1;
	}

	@Override
	public int emailCheck(String email) {
		int result = 0;
		
		String userEmail = usermapper.emailCheck(email);
		if(userEmail != null) 
			result = 1;
		else result = 0;
		
		return result;
	}
}

package com.shard.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shard.dao.ShardMemberDAO;
import com.shard.domain.ShardMemberVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	
	private final ShardMemberDAO dao;
	
	@Override
	public int userCheck(String userId, String userPwd) {
		return dao.userCheck(userId, userPwd);
	}

	@Override
	public ShardMemberVO getUser(String userId) {
		return dao.getUser(userId);
	}

	@Override
	public int idCheck(String userId) { // 회원가입할 때 id 체크
		return dao.idCheck(userId);
	}

	@Override
	public List<ShardMemberVO> getUserList() {
		return dao.getUserList();
	}

	@Override
	public void insertUser(ShardMemberVO vo) {
		dao.insertUser(vo);
	}

	@Override
	public boolean updateUser(ShardMemberVO vo) {
		return dao.updateUser(vo);
	}

	@Override
	public boolean deleteUser(String userId) {
		return dao.deleteUser(userId);
	}

	@Override
	public String getUserEmail(String email) {
		return dao.getUserEmail(email);
	}

	

}

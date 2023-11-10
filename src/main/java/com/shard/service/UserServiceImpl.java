package com.shard.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shard.domain.ShardMemberVO;
import com.shard.mapper.UserMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	
	private final UserMapper usermapper;

	@Override
	public ShardMemberVO getUser(String userId) {
		return usermapper.getUser(userId);
	}

	@Override
	public String getUserId(String userId) {
		return usermapper.getUserId(userId);
	}

	@Override
	public List<ShardMemberVO> getUserList() {
		return usermapper.getUserList();
	}

	@Override
	public void insertUser(ShardMemberVO vo) {
		usermapper.insertUser(vo);
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
	public String getUserEmail(String email) {
		return usermapper.getUserEmail(email);
	}

}

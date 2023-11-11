package com.shard.service;

import java.util.List;

import com.shard.domain.ShardMemberVO;

public interface UserService {
	public int userCheck(String userId, String userPwd);
	
	public ShardMemberVO getUser(String userId);
	
	public int idCheck(String userId);

	public String getUserEmail(String email);

	public List<ShardMemberVO> getUserList();

	public void insertUser(ShardMemberVO vo);

	public boolean updateUser(ShardMemberVO vo);

	public boolean deleteUser(String userId);
}

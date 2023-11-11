package com.shard.dao;

import java.util.List;

import com.shard.domain.ShardMemberVO;

public interface ShardMemberDAO {

	public int userCheck(String userId, String userPwd);

	public ShardMemberVO getUser(String userId);

	public int idCheck(String userid);

	public int insertUser(ShardMemberVO vo);

	public List<ShardMemberVO> getUserList();

	public String getUserEmail(String email);

	public boolean updateUser(ShardMemberVO vo);

	public boolean deleteUser(String userId);
}

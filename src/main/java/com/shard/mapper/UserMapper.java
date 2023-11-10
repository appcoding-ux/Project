package com.shard.mapper;

import java.util.List;

import com.shard.domain.ShardMemberVO;

public interface UserMapper {

	public ShardMemberVO getUser(String userId);

	public String getUserId(String userId);
	
	public String getUserEmail(String email);

	public List<ShardMemberVO> getUserList();

	public void insertUser(ShardMemberVO vo);

	public int updateUser(ShardMemberVO vo);

	public int deleteUser(String userId);
}

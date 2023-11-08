package com.ezen.shard.mapper;

import com.ezen.shard.domain.ShardMemberVO;

public interface UserMapper {
	
	public ShardMemberVO getUser(String userId);
}

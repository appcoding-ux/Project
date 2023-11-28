package com.shard.mapper;

import java.util.List;

import com.shard.domain.ItemVO;
import com.shard.domain.PageVO;
import com.shard.domain.ShardMemberVO;

public interface AdminMapper {
	public List<ShardMemberVO> userList(PageVO vo);

	public List<ItemVO> itemList(PageVO vo);
	
//	public List<NoReplyVO> noReplyList();

	public int userCount();

	public int itemCount();
}

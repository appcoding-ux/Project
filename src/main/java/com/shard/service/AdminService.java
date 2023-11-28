package com.shard.service;

import java.util.List;

import com.shard.domain.ItemVO;
import com.shard.domain.PageVO;
import com.shard.domain.ShardMemberVO;

public interface AdminService {
	public List<ShardMemberVO> userList(PageVO vo);
	
	public List<ItemVO> itemList(PageVO vo);
	
//	public List<NoReplyVO> noReplyList();
	
	public int userCount();
	
	public int itemCount();
}
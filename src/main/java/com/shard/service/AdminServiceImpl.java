package com.shard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shard.domain.ItemVO;
import com.shard.domain.PageVO;
import com.shard.domain.ShardMemberVO;
import com.shard.mapper.AdminMapper;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminMapper mapper;

	@Override
	public List<ShardMemberVO> userList(PageVO vo) {
		return mapper.userList(vo);
	}

	@Override
	public List<ItemVO> itemList(PageVO vo) {
		return itemList(vo);
	}

	@Override
	public int userCount() {
		return mapper.userCount();
	}

	@Override
	public int itemCount() {
		return mapper.itemCount();
	}

//	@Override
//	public List<NoReplyVO> noReplyList() {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
}

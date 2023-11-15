package com.shard.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ShardMemberVO {
	private String userId, userName, userPwd, Email ,Phone ,Dob ,Address;
	
	private int memNum, Point, zipCode, secession, authCode;
}
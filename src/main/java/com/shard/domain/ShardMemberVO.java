package com.shard.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShardMemberVO {
	private String userId;
	
	private String userPwd;
	
	private String userName;
	
	private String email;
	
	private String phone;
	
	private String dob;
	
	private int secession;
	
	private int point;
	
	private int zipCode;
	
	private String userAddr;
	
	private String detailAddr;
	
	private String userRegiDate;
	
	private int memNum;
	
	private int authCode;
	
}	
	

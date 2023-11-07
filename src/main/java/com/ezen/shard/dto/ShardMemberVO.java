package com.ezen.shard.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ShardMemberVO {
	private String userNo;
	
	private String userId;
	
	private String userName;
	
	private String userPwd;
	
	private String memberShip;
	
	private String userEmail;
	
	private String userBirth;
	
	private String userPhone;
	
	private String regiDate;
	
	private int userTotalPrice;
	
	private String userAddress;
	
	private int userPoint;
}
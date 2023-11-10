package com.shard.service;

import java.util.HashMap;

public interface KakaoLoginService {
	String getAccessToken(String code) throws Throwable;
	
	public HashMap<String, Object> getUserInfo(String access_Token) throws Throwable;
}

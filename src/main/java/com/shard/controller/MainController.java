package com.shard.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shard.service.KakaoLoginService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/shard/*")
@Log4j
@RequiredArgsConstructor
public class MainController {
	
	@Autowired
	private KakaoLoginService kakaoLoginService;
	
	
	@GetMapping("/")
	public String index() {
		log.info("index");
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		log.info("login");
		
		return "user/shardLogin";
	}
	
	@GetMapping("/login/oauth")
	public String kakaoOauth(@RequestParam(required = false) String code) throws Throwable{
		log.info(code);
		
		String access_Token = kakaoLoginService.getAccessToken(code);
		System.out.println("####access_Token####" + access_Token);
		
		HashMap<String, Object> userInfo = kakaoLoginService.getUserInfo(access_Token);
		System.out.println("###nickName###" + userInfo.get("nickName"));
		System.out.println("###email###" + userInfo.get("email"));
		
		String userEmail = (String)userInfo.get("email");
		
		
		return "user/kakaoSuccess";
	}
	
	@GetMapping("/join")
	public String join() {
		log.info("join");
		return "user/shardJoin";
	}
}
package com.shard.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shard.domain.ShardMemberVO;
import com.shard.service.KakaoLoginService;
import com.shard.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import oracle.jdbc.driver.json.tree.OracleJsonObjectImpl;
import oracle.sql.json.OracleJsonObject;

@Controller
@RequestMapping("/shard/*")
@Log4j
@RequiredArgsConstructor
public class UserController {
	
	private final KakaoLoginService kakaoLoginService;
	
	private final UserService userservice;
	
	@GetMapping("")
	public String index() {
		log.info("index");
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		log.info("login");
		return "user/shardLogin";
	}
	
	@PostMapping("/login")
	public String userLogin(Model model, RedirectAttributes rttr, ShardMemberVO vo) {
		
		return "redirect:shard/";
	}
	
	@GetMapping("/login/oauth")
	public String kakaoOauth(@RequestParam(required = false) String code) throws Throwable{
		log.info("카카오 로그인");
		String access_Token = kakaoLoginService.getAccessToken(code);
		
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
	
	@GetMapping("/idCheck")
	public void idCheck(String userId, HttpServletResponse response) throws Exception {
		System.out.println(userId);
		int result = userservice.idCheck(userId);
		OracleJsonObject json = new OracleJsonObjectImpl();
		json.put("result", result);
		response.setContentType("application/json");
		response.getWriter().write(json.toString());
	}
}
package com.shard.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shard.domain.ShardMemberVO;
import com.shard.service.KakaoLoginService;
import com.shard.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import oracle.jdbc.driver.json.tree.OracleJsonObjectImpl;
import oracle.sql.json.OracleJsonObject;

@Controller
@SessionAttributes({"user", "token"})
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
	public String userLogin(Model model, @RequestParam("userId")String userId,@RequestParam("userPwd") String userPwd) {
		String url = "";
		int result = userservice.userCheck(userId, userPwd);
		if(result == 1) {
			ShardMemberVO vo = userservice.getUser(userId);
			model.addAttribute("user", vo);
			url = "index";
		}else {
			model.addAttribute("result",-1);
			url = "user/shardLogin";
		}
		
		return url;
	}
	
	@GetMapping("/login/oauth")
	public String kakaoOauth(@RequestParam(required = false) String code, Model model, RedirectAttributes rttr) throws Throwable{
		String url = "";
		
		String access_Token = kakaoLoginService.getAccessToken(code);
		
		HashMap<String, Object> userInfo = kakaoLoginService.getUserInfo(access_Token);
		System.out.println("###nickName###" + userInfo.get("nickName"));
		System.out.println("###email###" + userInfo.get("email"));
		
		String userEmail = (String)userInfo.get("email");
		String nickName = (String)userInfo.get("nickName");
		int result = userservice.emailCheck(userEmail);
		
		if(result != 0) {
			ShardMemberVO vo = userservice.getUserEmail(userEmail);
			model.addAttribute("user", vo);
			model.addAttribute("token", access_Token);
			url = "index";
		}else {
			rttr.addFlashAttribute("userEmail", userEmail);
			rttr.addFlashAttribute("nickName", nickName);
			url = "redirect:/shard/kakaoJoin";
		}
		return url;
	}
	
	@GetMapping("/logout")
	public String logout(SessionStatus status, Model model){
		status.setComplete();
		model.addAttribute("result", "logout");
		
		return "index";
	}
	
	@GetMapping("/kakaoLogout")
	public String kakaoLogout(SessionStatus status, RedirectAttributes rttr) throws Throwable{
		status.setComplete();
		rttr.addFlashAttribute("result", "logout");
		
		return "redirect:/shard/";
	}
	
	@GetMapping("/join")
	public String join(ShardMemberVO vo, RedirectAttributes rttr, Model model) {
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
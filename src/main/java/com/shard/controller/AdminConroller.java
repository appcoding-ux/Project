package com.shard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shard.domain.PageVO;
import com.shard.service.AdminService;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/admin/*")
public class AdminConroller {
	
	@Autowired
	private AdminService service;
	
	@GetMapping("")
	public void Admin() {
	}
	
	@GetMapping("/user")
	public void adminUser(Model model, PageVO vo) {
		model.addAttribute("user", service.userList(new PageVO(vo.getPageNum(), service.userCount())));
	}
	
	@GetMapping("/item")
	public void adminItem(Model model, PageVO vo) {
		model.addAttribute("item", service.itemList(new PageVO(vo.getPageNum() , service.itemCount())));
	}
	
}
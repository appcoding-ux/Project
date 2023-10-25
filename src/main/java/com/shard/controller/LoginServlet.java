package com.shard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shard.dao.ShardMemberDAO;
import com.shard.dto.ShardMemberVO;

@WebServlet("/shardLogin.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dis = request.getRequestDispatcher("index.jsp");
		dis.forward(request, response);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "shardLogin.jsp";
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		String adminUser = request.getParameter("adminLogin");
		// adminUser 체크하면 on 체크 안하면 null
		
		ShardMemberDAO dao = ShardMemberDAO.getInstance();
		int result = -1;
		
		if(adminUser == null) {
			result = dao.userCheck(userId, userPwd);
			System.out.println(result);
			if(result == 1) {
				ShardMemberVO vo = dao.getMember(userId);
				request.setAttribute("userName", vo.getUserName());
				HttpSession session = request.getSession();
				session.setAttribute("loginMember", session);
				request.setAttribute("message", "회원 가입에 성공했습니다.");
				url = "index.jsp";
			}else if(result == 0) {
				request.setAttribute("message", "아이디 또는 비밀번호가 맞지 않습니다.");
			}else if(result == -1) {
				request.setAttribute("message", "아이디 또는 비밀번호가 맞지 않습니다.");
			}
		}else if(adminUser == "on"){
			result = dao.adminCheck(userId, userPwd);
			if(result == 1) {
				ShardMemberVO vo = dao.getMember(userId);
				System.out.println(vo);
				request.setAttribute("userName", vo.getUserName());
				HttpSession session = request.getSession();
				session.setAttribute("loginMember", session);
				request.setAttribute("message", "회원 가입에 성공했습니다.");
				url = "index.jsp";
			}else if(result == 0) {
				request.setAttribute("message", "아이디 또는 비밀번호가 맞지 않습니다.");
			}else if(result == -1) {
				request.setAttribute("message", "아이디 또는 비밀번호가 맞지 않습니다.");
			}
		}

		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
	}

}

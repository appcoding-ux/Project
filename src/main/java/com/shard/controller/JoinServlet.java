package com.shard.controller;

import java.io.IOException;

import com.shard.dao.ShardMemberDAO;
import com.shard.dto.ShardMemberVO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import oracle.jdbc.driver.json.tree.OracleJsonObjectImpl;
import oracle.sql.json.OracleJsonObject;

@WebServlet("/join.do")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userId");
		System.out.println(userid);
		ShardMemberDAO dao = ShardMemberDAO.getInstance();
		
		int result = dao.idCheck(userid);
		System.out.println(result);
		OracleJsonObject jsonResponse = new OracleJsonObjectImpl();
		
		jsonResponse.put("result", result);
		
		response.setContentType("application/json");
		
		response.getWriter().write(jsonResponse.toString());
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShardMemberVO vo = new ShardMemberVO(); 
		
		String userBirth = request.getParameter("birthYear")+request.getParameter("birthMonth")+request.getParameter("birthDay");
		
		vo.setUserId(request.getParameter("userId"));
		vo.setUserName(request.getParameter("name"));
		vo.setUserPwd(request.getParameter("pwd"));
		vo.setUserEmail(request.getParameter("email"));
		vo.setUserBirth(userBirth);
		vo.setUserPhone(request.getParameter("phone"));
		
		ShardMemberDAO dao = ShardMemberDAO.getInstance();
		int result = dao.insertMember(vo);
		System.out.println(result);
		
		if (result == 0) { // 회원가입에 실패했을 경우
		    request.setAttribute("joinMessage", 0);
		} else { // 회원가입에 성공했을 경우
		    request.setAttribute("joinMessage", 1);
		    RequestDispatcher dis = request.getRequestDispatcher("shardLogin.jsp");
		    dis.forward(request, response);
		}
	}

}

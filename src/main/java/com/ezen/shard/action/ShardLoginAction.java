package com.shard.controller.action.member;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shard.controller.conn.Action;
import com.shard.dao.ShardMemberDAO;
import com.shard.dto.ShardMemberVO;

public class ShardLoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
		String url = "shardLogin.jsp";

		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");

		String adminUser = request.getParameter("adminLogin");
		System.out.println(adminUser);
		// adminUser 체크하면 on 체크 안하면 null

		ShardMemberDAO dao = ShardMemberDAO.getInstance();
		int result;

		if (adminUser == null) {
			result = dao.userCheck(userId, userPwd);
			System.out.println(result);
			if (result == 1) {
				ShardMemberVO vo = dao.getMember(userId);
				// 세션 생성 회원인 고객만 사이트의 기능을 수행할 수 있음.. 로그인을 성공했을 때 세션을 만들어 index.jsp에 넘겨준다.
				HttpSession session = request.getSession();
				session.setAttribute("user", vo);
				request.setAttribute("message", "회원 가입에 성공했습니다.");
				url = "index.jsp";
			} else if (result == 0) {
				request.setAttribute("result", result);
				url = "shardLogin.jsp";
			} else if (result == -1) {
				request.setAttribute("result", result);
				url = "shardLogin.jsp";
			}

		} else if (adminUser.equals("관리자")) {
			result = dao.userCheck(userId, userPwd);
			System.out.println(result);
			
			if (result == 7) {
				HttpSession session = request.getSession();
				session.setAttribute("loginMember", session);
				url = "Admin.jsp";
				response.sendRedirect(url);
			} else if (result == 0) {
				request.setAttribute("result", result);
				url = "shardLogin.jsp";
			} else if (result == -1) {
				request.setAttribute("result", result);
				url = "shardLogin.jsp";
			}
		}
		
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
	}
}

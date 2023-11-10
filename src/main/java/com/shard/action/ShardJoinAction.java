package com.shard.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shard.dao.ShardMemberDAO;
import com.shard.domain.ShardMemberVO;

public class ShardJoinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
		ShardMemberVO vo = new ShardMemberVO();

		String userBirth = request.getParameter("birthYear") + request.getParameter("birthMonth")
				+ request.getParameter("birthDay");

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

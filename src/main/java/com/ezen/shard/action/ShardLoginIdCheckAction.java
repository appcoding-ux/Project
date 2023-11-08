package com.ezen.shard.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.shard.dao.ShardMemberDAO;

import oracle.jdbc.driver.json.tree.OracleJsonObjectImpl;
import oracle.sql.json.OracleJsonObject;

public class ShardLoginIdCheckAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
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

}

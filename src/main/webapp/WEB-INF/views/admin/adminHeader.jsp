<%@page import="com.shard.domain.ShardMemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="header">
	<div class="topRightNav">
		<ul>
			<%
			ShardMemberVO user = (ShardMemberVO) session.getAttribute("user"); // 유저 정보

			if (user != null) {
			%>
			<li><span
				style="font-size: 14px; color: #333; font-weight: 400;"><%=user.getUserName()%>
					님</span></li>
					<li><a href="/shard/logout">로그아웃</a></li>
					<li><a href="/shard/mypage">관리자페이지</a></li>
			<%
			} else {
			%>
			<%
			}
			%>
		</ul>
	</div>
</div>

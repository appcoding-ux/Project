<%@page import="com.ezen.shard.dto.ShardMemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<div class="header">
	<div class="topRightNav">
		<ul>
			<%
                ShardMemberVO user = (ShardMemberVO)session.getAttribute("user");
                if (user != null) {
                %>
			<li><span style="font-size:14px; color:#333; font-weight:400;"><%-- <%= user.getUserName() %> --%> 님</span></li>
			<li><a href="ShardServlet?command=logout">로그아웃</a></li>
			<%
                } else {
                %>
			<li><a href='shardLogin.jsp'>로그인</a></li>
			<li><a href="shardJoin.jsp">회원가입</a></li>
			<%
                }
                %>
			<li><a href="#">마이페이지</a></li>
			<li><a href="ShardQnA.jsp">Q&A</a></li>
		</ul>
	</div>
	<div class="mainNav">
		<a href="index.jsp" style="color: #000; font-family: cursive;">
			<img src="logo.png" alt="로고 사진" />
		</a>
		<ul>
			<li><a href="#">BEST</a></li>
			<li><a href="#">NEW</a></li>
			<li class="division_line"><span></span></li>
			<li><a href="#">패키지</a></li>
			<li><a href="#">Mtm</a></li>
			<li><a href="#">Hood</a></li>
			<li><a href="#">Bottom</a></li>
			<li><a href="#">Shirts</a></li>
			<li><a href="#">Denim</a></li>
			<li><a href="#">Acc</a></li>
		</ul>
	</div>
</div>

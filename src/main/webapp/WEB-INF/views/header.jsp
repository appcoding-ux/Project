<%@page import="com.shard.domain.ShardMemberVO"%>
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
			<li><a href="/shard/login">로그인</a></li>
			<li><a href="/shard/join">회원가입</a></li>
			<%
                }
                %>
			<li><a href="#">마이페이지</a></li>
			<li><a href="ShardQnA.jsp">Q&A</a></li>
		</ul>
	</div>
	<div class="mainNav">
		<a href="/shard/" style="color: #000; font-family: cursive;">
			<img src="/resources/logo.png" alt="로고 사진" />
		</a>
		<ul>
			<li><a href="/shard/category/best">BEST</a></li>
			<li><a href="/shard/category/best">NEW</a></li>
			<li class="division_line"><span></span></li>
			<li><a href="/shard/category/package">패키지</a></li>
			<li><a href="/shard/category/mtm">Mtm</a></li>
			<li><a href="/shard/category/hood">Hood</a></li>
			<li><a href="/shard/category/bottom">Bottom</a></li>
			<li><a href="/shard/category/shirts">Shirts</a></li>
			<li><a href="/shard/category/denim">Denim</a></li>
			<li><a href="/shard/category/acc">Acc</a></li>
		</ul>
	</div>
</div>

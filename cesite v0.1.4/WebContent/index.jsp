<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="kr.ac.mju.cs.bean.User"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<title>명지대학교 컴퓨터공학과</title>
</head>
<body>

<% if (session.getAttribute("sessionUser") == null) { %>
	<div class="login">
		<form id="login-form" method="POST" action="UserInfoServlet">
			<input type="hidden" name="action" value="login">
		  	<span>ID</span> <input id="id" type="text" name="user-id">
		  	<span>Password</span> <input id="password" type="password" name="user-password">
		  	<input id="login-button" type="submit" value="login">	
		</form>	
	</div>
  <a href="user-join.jsp">회원가입</a> 
<% } else { 
	User sessionUser = (User)session.getAttribute("sessionUser"); 
%>
	<section>
	 안녕하세요. <b><%= sessionUser.getName() %> </b>님<br/>
  	<a id="logout" href="logout.jsp">로그아웃</a>  
	<a href="user-modify.jsp">정보수정</a>
	<a href="user-delete.jsp">탈퇴</a>
	</section>
<% } %>
</body>
</html>
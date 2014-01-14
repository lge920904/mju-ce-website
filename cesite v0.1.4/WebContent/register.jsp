<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="kr.ac.mju.cs.bean.User"%>
<%
	request.setCharacterEncoding("utf-8");
%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title> 명지대학교 컴퓨터공학과 :: 회원등록완료 </title>
	<link rel="stylesheet" type="text/css" href="css/modify.css">
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<%
		User user = (User) request.getAttribute("user");
		String userName = (String) request.getAttribute("name");
		String id = (String) request.getAttribute("id");
		String email = (String) request.getAttribute("email");
	%>
	<div class="container">
		<div class="alert alert-success">
			<b><%=userName%></b>님 등록해주셔서 감사합니다.<br /> <br /> 로그인 아이디는 <b><%=id%></b>
			또는 <b><%=email%></b>을 사용하실 수 있습니다.<br />
		</div>
		<a href="index.jsp" class="btn">첫 화면으로</a>
	</div>
</body>
</html>
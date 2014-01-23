<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="kr.ac.mju.cs.bean.User"%>
<%
User sessionUser = (User)session.getAttribute("sessionUser");
%>    
<!DOCTYPE html>
<html>
<head>
<title>명지대학교 컴퓨터공학과::로그아웃</title>
<link rel="stylesheet" href="css/default.css" type="text/css"/>
<link rel="stylesheet" href="css/join.css" type="text/css"/>
<meta charset="UTF-8">
</head>
<body>
<div class="ct-container">
		<%@ include file="page/header.jsp" %>	
	<div class="ct-inner-contents">
		<div class="desc-intro">
			<br/><br/><br/>
		  <strong>정상적으로 로그아웃 처리되었습니다.</strong><br/>
		  <strong>'<%= sessionUser.getName() %>'님 안녕히가세요.</strong><br/><br/>
		  <span>10초 후, 자동으로 화면이 이동됩니다.</span><br/>
		  <span>메인화면으로 이동하시려면 <a href="index.jsp" style="color:red; font-size:13pt;">여기</a>를 클릭하세요.</span><br/>
		</div>
		<div style="margin:100px 0 0 50px;">
			<img src="./resources/join_img/logout.png">
		</div>
	</div>
		<%@ include file="page/footer.jsp" %>
</div>
<% session.invalidate(); %>
</body>
<script>
setTimeout("location.href='index.jsp'",10000);
</script>
</html>


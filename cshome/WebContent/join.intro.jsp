<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="css/default.css">
	<link rel="stylesheet" type="text/css" href="css/join.css">
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<title>명지대학교 컴퓨터공학과::회원가입</title>
</head>
<body>

<div class="ct-container">
	<%@ include file="page/header.jsp" %>	
	<div class="ct-inner-contents">
		<div style="height:300px;" class="desc-intro">
			<img  style="margin-left:100px;" src="resources/join_img/join.intro.png" >
		</div>
		<div class="join-box">
		<div class="join-innerbox leftbox">
			<a href="join.do.jsp?action=member" class="join-member bg-join">
			</a>
		</div>
		<div class="join-innerbox rightbox">
			<a href="join.do.jsp?action=non-member" class="join-non-member bg-join">
			</a>
		</div>
		</div>
	</div>
		<%@ include file="page/footer.jsp" %>
</div>	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="kr.ac.mju.cs.bean.User"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title> 명지대학교 컴퓨터공학과 :: 회원탈퇴 </title>
	<link rel="stylesheet" type="text/css" href="css/modify.css">
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
<article class="article">
	<form method="POST" action="UserInfoServlet?action=delete" enctype="multipart/form-data">
		<div class="section">
			회원탈퇴를 원하신다면 비밀번호를 입력하고 탈퇴를 누르세요.<br/>
			<input type="hidden" name="action" value="delete">
			<span>비밀번호</span><input type="password" id="user-password" name="user-password">
			<div id="confirm-pw">
			</div>
			<input type="submit" name="btn-delete" value="탈퇴" disabled="disabled">
		</div>
	</form>
</article>
</body>
<script>

</script>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="kr.ac.mju.cs.bean.User"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title> 명지대학교 컴퓨터공학과::회원탈퇴 </title>
	<link rel="stylesheet" type="text/css" href="css/default.css">
	<link rel="stylesheet" type="text/css" href="css/join.css">
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
<div class="ct-container">
		<%@ include file="page/header.jsp" %>	
	<div class="ct-inner-contents">
		<div class="desc-intro">
			<strong>회원 탈퇴</strong><br/><br/>
			<span>등록된 비밀번호를 입력하고 탈퇴 버튼을 누르시면<br/>
			회원탈퇴가 완료되며, 즉시 메인 페이지로 이동합니다.<br/>
			</span>
		</div>
		<div class="ct-form">
			<form method="post" action="UserJoinServlet?action=member-join" autocomplete="off" id="cs-join-form" enctype="multipart/form-data">
				<div class="input-info">
					<input type="hidden" name="action" value="delete">
				</div>
				<div class="input-info">
					<span class="input-txt">비밀번호</span><input type="password" id="user-password" name="user-password">
				</div>
				<div class="input-info">
					<input type="button" class="btn-submit" name="btn-user-delete" value="탈퇴">
				</div>
			</form>
		</div>
	</div>
	<%@ include file="page/footer.jsp" %>
</div>
</body>
<script>

</script>
</html>
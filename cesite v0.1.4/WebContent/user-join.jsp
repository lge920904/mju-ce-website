<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>   

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title> 명지대학교 컴퓨터공학과 :: 회원가입 </title>
	<link rel="stylesheet" type="text/css" href="css/join.css">
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
<article class="article">
	<form method="POST" action="UserInfoServlet?action=join" enctype="multipart/form-data">
		<div class="section">
			<p><input type="hidden" name="action" value="join" ></p>
			<p><span>아이디</span><input type="text" name="user-id" id="join-user-id"></p>
			<p><span>비밀번호</span><input type="password" name="user-password" id="join-user-password"></p>
			<p><span>비밀번호확인</span><input type="password" name="user-password-confirm" id="join-user-password-confirm"></p>
			<p><span>이름</span><input type="text" name="user-name" id="join-user-name"></p>
			<p><span>이메일</span>
				<input type="text" name="user-email">
				<input type="button" onclick="sendEmail()" value="인증번호 전송">
			</p>
			<p><span>이메일인증</span>
				<input type="text" name="user-email-confirm" onkeyup="emailConfirm()">
			</p>
			<p><span>사진</span><input type="file" name="user-photo" id="join-user-photo">	</p>	
			<p class="p-radio"><span>회원 분류</span>
				<span class="span-radio"><input type="radio" name="user-category" value="student" checked="checked">학생</span>
				<span class="span-radio"><input type="radio" name="user-category" value="professor">교수</span>
				<span class="span-radio"><input type="radio" name="user-category" value="staff">직원</span>
				<span class="span-radio"><input type="radio" name="user-category" value="normal">일반회원</span>
			</p>
			<div class="hidden" id="hidden-student-form">
				<span>스터디</span><input type="text" name="student-study" id="join-student-study">
			</div>
			<div class="hidden" id="hidden-professor-form">
				<span>전공</span><input type="text" name="professor-major" id="join-professor-major">
			</div>
			<div class="hidden" id="hidden-staff-form">
				<span>부서</span><input type="text" name="staff-department" id="join-staff-department">
			</div>
			<input type="submit" id="btn-join-submit" value="회원가입">
		</div>
	</form>
</article>
</body>
<script type="text/javascript">
function sendEmail(){
	alert("입력하신 메일로 인증코드를 전송하였습니다");
	$.post('UserAjaxServlet',{
		action : "send-email",
		email : document.getElementsByName("user-email")[0].value
	}, function(data){ 
		}
	);
}

function emailConfirm(){
	$.post('UserAjaxServlet',{
		action : "email-confirm",
		email : document.getElementsByName("user-email-confirm")[0].value
	}, function(data){ 
		document.getElementsByName("user-email-confirm")[0].setAttribute("disabled",true);
		}
	);
}
</script>
</html>
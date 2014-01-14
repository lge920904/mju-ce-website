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
			<p class="p-radio"><span>회원 분류</span>
				<span class="span-radio"><input type="radio" name="user-category" value="student" checked="checked">학생</span>
				<span class="span-radio"><input type="radio" name="user-category" value="professor">교수</span>
				<span class="span-radio"><input type="radio" name="user-category" value="staff">직원</span>
				<span class="span-radio"><input type="radio" name="user-category" value="normal" >일반회원</span>
			</p>
			<p><span>아이디</span><input type="text" name="user-id" ></p>
			<p><span>비밀번호</span><input type="password" name="user-password" ></p>
			<p><span>비밀번호확인</span><input type="password" name="user-password-confirm"  onkeyup="passwordConfirm()"></p>
			<p><span>이름</span>
				<input type="text" name="user-name" >
				<input type="button" name="btn-id" onclick="doubleCheckId()" value="아이디 중복확인">
			</p>
			<p><span>이메일</span>
				<input type="text" name="user-email" >
				<input type="button" name="btn-email" onclick="sendEmail()" value="인증번호 전송">
			</p>
			<p><span>이메일인증</span>
				<input type="text" name="user-email-confirm"  onkeyup="emailConfirm()" >
			</p>
			<p><span>사진</span><input type="file" name="user-photo" id="join-user-photo">	</p>	
			<div class="hidden" >
				<p class="student" ><span>스터디</span>
					<input type="text" name="student-study" id="join-student-study">
				</p>
				<p class="professor" style="display:none;"><span>전공</span>
					<input type="text" name="professor-major" id="join-professor-major">
				</p>
				<p class="staff" style="display:none;"><span>부서</span>
					<input type="text" name="staff-department" id="join-staff-department">
				</p>
			</div>
			<script type="text/javascript">
				$(function(){
					$("input[name='user-category']").change(function() {
						var radio = $(this).val();
						$('.hidden').find('p').hide();
						if(radio == "student"){
							$('.student').show();
						}else if(radio == "professor"){
							$('.professor').show();
						}else if(radio == "staff"){
							$('.staff').show();
						}else if(radio == "normal"){
						}
					});
				});
			</script>
			<p>
				<input type="button" name="submit" onclick="validate()" value="회원가입">
				<input type="reset" value="초기화">
			</p>
		</div>
	</form>
</article>
</body>
<script type="text/javascript">

/* 학번 중복 확인 */
function doubleCheckId(){
	$.post('UserJoinServlet',{
		action : "doubleCheckId",
		id : document.getElementsByName("user-id")[0].value,
		name : document.getElementsByName("user-name")[0].value
	}, function(data){
		if(data){
			document.getElementsByName("user-id")[0].setAttribute("readonly",true);
			document.getElementsByName("user-name")[0].setAttribute("readonly",true);
			document.getElementsByName("btn-id")[0].setAttribute("disabled",true);
		}else{
			alert("중복되는 아이디입니다.");
		}
	});
}
/* 비밀번호 확인 */
function passwordConfirm(){
	$.post('UserJoinServlet',{
		action : "passwordConfirm",
		pw1 : document.getElementsByName("user-password")[0].value,
		pw2 : document.getElementsByName("user-password-confirm")[0].value
	}, function(data){
		if(data){
			document.getElementsByName("user-password")[0].setAttribute("readonly",true);
			document.getElementsByName("user-password-confirm")[0].setAttribute("disabled",true);
		}
	});
}
/* 이메일 전송 */
function sendEmail(){
	alert("입력하신 메일로 인증코드를 전송하였습니다.");
	$.post('UserJoinServlet',{
		action : "sendEmail",
		email : document.getElementsByName("user-email")[0].value
	});
}
/* 이메일 인증번호 확인 */
function emailConfirm(){
	$.post('UserJoinServlet',{
		action : "emailConfirm",
		auth : document.getElementsByName("user-email-confirm")[0].value
	}, function(data){ 
		if(data){
			document.getElementsByName("user-email" )[0].setAttribute("readonly", true);
			document.getElementsByName("user-email-confirm")[0].setAttribute("disabled", true);
			document.getElementsByName("btn-email")[0].setAttribute("disabled", true);
		}
	});
}
/* submit */
 function validate(){
	if(!document.getElementsByName("btn-id")[0].getAttribute("disabled") ||
		!document.getElementsByName("user-password-confirm")[0].getAttribute("disabled") ||
		!document.getElementsByName("btn-email")[0].getAttribute("disabled") ){
		alert(" 아이디와 이메일을 반드시 인증받으시고,"+'\n'+" 입력하신 비밀번호가 일치하는지 확인하십시요.");
	}else{
		alert("회원가입 성공");
		/* this.submit(); */
	}
}

</script>
</html>
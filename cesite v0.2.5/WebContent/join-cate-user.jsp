<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   	String category = request.getParameter("user-category");
	String id = request.getParameter("user-id");
	String name = request.getParameter("user-name");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<section>
<form method="POST" action="UserJoinServlet?action=join" name="joinform" enctype="multipart/form-data">
	<div id="real">
		<div class="form">
			<span>이메일</span>
			<input type="text" name="user-email" >
			<input type="button" name="btn-email" onclick="sendEmail()" value="인증번호 전송">
		</div>
		<div class="form">
			<span>이메일인증</span>
			<input type="text" name="user-email-confirm" onkeyup="emailConfirm()" >
		</div>
		<div class="form">
			<span>비밀번호</span>
			<input type="password" name="user-password" >
		</div>
		<div class="form">
			<span>비밀번호확인</span>
			<input type="password" name="user-password-confirm"  onkeyup="passwordConfirm()">
		</div>
		<div class="form">
			<span>사진</span><input type="file" name="user-photo" id="join-user-photo">		
		</div>
  		<input type="hidden" name="user-id" value="<%= id %>">
  		<input type="hidden" name="user-name" value="<%= name %>">
<%  if(!category.equals("member")){
  		String option = request.getParameter("noMember-category");
 %>
 		<input type="hidden" name="user-category" value="normal">
  		<input type="hidden" name="noMember-option" value="<%= option %>">
<% } else { %>
		<div class="form">
			<span class="span-radio"><input type="radio" name="user-category" value="student" checked="checked">학생</span>
			<span class="span-radio"><input type="radio" name="user-category" value="professor">교수</span>
			<span class="span-radio"><input type="radio" name="user-category" value="staff">직원</span>
		</div>
		<div class="hidden" >
			<div class="hidden-student" ><span>스터디</span>
				<input type="text" name="student-study" id="join-student-study">
			</div>
			<div class="hidden-professor" style="display:none;"><span>전공</span>
				<input type="text" name="professor-major" id="join-professor-major">
			</div>
			<div class="hidden-staff" style="display:none;"><span>부서</span>
				<input type="text" name="staff-department" id="join-staff-department">
			</div>
		</div>
		<script type="text/javascript">
			$(function(){
				$("input[name='user-category']").change(function() {
					var radio = $(this).val();
					$('.hidden').find('div').hide();
					if(radio == "student"){
						$('.hidden .hidden-student').show();
					}else if(radio == "professor"){
						$('.hidden .hidden-professor').show();
					}else if(radio == "staff"){
						$('.hidden .hidden-staff').show();
					}
				});
			});
		</script>
<% } %>
	</div>
	<input type="button" value="회원가입" onclick="validate()">
</form>
</section>
</body>
<script type="text/javascript">
/* 비밀번호 확인 */
function passwordConfirm(){
	$.post('UserJoinServlet',{
		action : "passwordConfirm",
		pw1 : document.getElementsByName("user-password")[0].value,
		pw2 : document.getElementsByName("user-password-confirm")[0].value
	}, function(data){
		if(data){
			document.getElementsByName("user-password")[0].setAttribute("readonly",true);
			document.getElementsByName("user-password-confirm")[0].setAttribute("readonly",true);
		}
	});
}
/* 이메일 전송 */
function sendEmail(){
	$.post('UserJoinServlet',{
		action : "sendEmail",
		email : document.getElementsByName("user-email")[0].value
	}, function(data){
		if(data){
			alert("이미 등록된 이메일입니다.");
		}
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
			document.getElementsByName("user-email-confirm")[0].setAttribute("readonly", true);
			document.getElementsByName("btn-email")[0].setAttribute("disabled", true);
		}
	});
}

/* submit */
 function validate(){
	if(!document.getElementsByName("user-password-confirm")[0].getAttribute("readonly") ||
			!document.getElementsByName("btn-email")[0].getAttribute("disabled")){
		alert(" 아이디와 이메일을 반드시 인증받으시고,"+'\n'+" 입력하신 비밀번호가 일치하는지 확인하십시요.");
	}else{
		document.getElementsByName("joinform")[0].submit();
	}
}
</script>
</html>
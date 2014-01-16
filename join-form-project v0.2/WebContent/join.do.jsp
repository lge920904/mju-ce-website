<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% boolean isMember = false;;
    	if(request.getParameter("action").equals("member")){
    		isMember = true;
    	}%>
<!DOCTYPE html5>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="css/join.css">
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<title>y</title>
</head>
<body>
<div class="cs-join">
	<div class="desc-intro">
		<strong>가입양식이에욤!!</strong>
	</div>
	<div class="join-form">
	<% if(isMember){ %>
		<form method="post" action="UserJoinServlet?action=member-join" id="cs-join-form" enctype="multipart/form-data">
		<%}else{%>
		<form method="post" action="UserJoinServlet?action=non-member-join" id="cs-join-form" enctype="multipart/form-data">
		<%}%>
			<fieldset class="field-form">
			<% if(isMember){ %>
				<input type="hidden" name="user-category" value="member">
				<div class="input-info">
					<span class="input-txt">아이디</span><input type="text" name="user-member-id"  maxlength="8" class="input-text">
				</div>				
				<div class="input-info">
					<span class="input-txt">이름</span><input type="text" name="user-member-name" class="input-text">
				</div>
			<%}else{%>
				<input type="hidden" name="user-category" value="non-member">
				<div class="input-info">
					<span class="input-txt">아이디</span><input type="text" name="user-non-member-id"  maxlength="20" class="input-text">
				</div>
				<div class="input-info">
					<span class="input-txt">이름</span><input type="text" name="user-non-member-name" class="input-text">
				</div>
			<%}%>
				<div class="hidden">
					<div class="input-info">
						<span class="input-txt">비밀번호</span><input type="password" name="user-password" maxlength="20" class="input-text" placeholder="비밀번호를 입력하세요">
					</div>
					<div class="input-info">
						<span class="input-txt">비밀번호확인</span><input type="password" name="user-password-certify" class="input-text" placeholder="비밀번호를 재입력하세요">
					</div>
					<% if(isMember){ %>
					<div class="input-info">
						<span class="input-txt">이메일</span><input type="text" name="user-member-email" class="input-text" placeholder="이메일 주소를 입력하세요">
					</div>
					<% }else{ %>
					<div class="input-info">
						<span class="input-txt">이메일</span><input type="text" name="user-non-member-email" class="input-text" placeholder="이메일 주소를 입력하세요">
					</div>
					<% } %>
					<div class="input-info">
						<input type="button" class="btn-certify" id="btn-email-certify" value="이메일인증">
					</div>
					<div class="input-info">
							<span class="input-txt">인증번호</span><input type="text" name="user-email-certify" class="input-text" placeholder="이메일 인증번호를 입력하세요">
					</div>
					<% if(isMember){ %>
					<div class="input-info">
						<input type="button" name="cs-join-member-submit" class="btn-submit" value="회원가입">
					</div>
					<% }else{ %>
					<div class="input-info">
						<input type="button" name="cs-join-non-member-submit" class="btn-submit" value="회원가입">
					</div>
					<% } %>
				</div>			
			</fieldset>
		</form>
	</div>
</div>
</body>
<script type="text/javascript">
$(function(){
	/* member 인증 및 중복가입 확인 */
	$('input[name=user-member-name]').keyup(function(){
		if($('input[name=user-member-id]').val().length == 8 &&
			$('input[name=user-member-name]').val().length > 2){
			$.post('UserJoinServlet', {
				action : "isMember",
				id : $('input[name=user-member-id]').val(),
				name : $('input[name=user-member-name]').val()
			}, function(data){
				if(data){
					$('.hidden').slideDown();
					$('input[name=user-member-id]').attr("readonly", true);
					$('input[name=user-member-name]').attr("readonly", true);
				}	
			});
		}
	});
	
	/* non-member 중복가입 확인 */
	$('input[name=user-non-member-id]').keyup(function(){
		if($('input[name=user-non-member-id]').val().length > 4){
			$.post('UserJoinServlet', {
				action : "doubleCheckId",
				id : $('input[name=user-non-member-id]').val()
			}, function(data){
				if(data){
					$('.hidden').slideDown();
					$('input[name=user-non-member-id]').attr("readonly", true);
				}
			});
		}
	});
	
	/* 비밀번호 검증 */
	$('input[name=user-password-certify]').keyup(function(){
		if($('input[name=user-password]').val().length >= 6){
			$.post('UserJoinServlet',{
				action : "passwordCertify",
				pw : $('input[name=user-password]').val(),
				pwc : $('input[name=user-password-certify]').val()
			},function(data){
				if(data){
					$('input[name=user-password]').attr("readonly", true);
					$('input[name=user-password-certify]').attr("disabled", true);
				}
			});
		}
	}); 

	/* 이메일 검증 및 인증번호 전송 */
	$('#btn-email-certify').click(function(){
		/* member 의 경우 */
		if($('input[name=user-member-email]').val().length > 6){
			$.post('UserJoinServlet',{
				action : "isMemberEmail",
				email : $('input[name=user-member-email]').val(),
				name : $('input[name=user-member-name]').val()
			},function(data){
				if(data){
					$('input[name=user-member-email]').attr("readonly", true);
					$('input[name=user-email-certify]').attr("disabled", false);
				}
			});
		}else if($('input[name=user-non-member-email]').val().length > 6){
			$.post('UserJoinServlet',{
				action : "doubleCheckEmail",
				email : $('input[name=user-non-member-email]').val(),
				name : $('input[name=user-non-member-name]').val()
			},function(data){
				if(data){
					$('input[name=user-non-member-email]').attr("readonly", true);
				}
			});
		}
	});
	
	/* 이메일 인증코드 확인 */
	$('input[name=user-email-certify]').keyup(function(){
		if($('input[name=user-email-certify]').val().length == 4){
			$.post('UserJoinServlet', {
				action : "emailCertify",
				authcode : $('input[name=user-email-certify]').val()
			}, function(data){
				if(data){
					$('input[name=user-email-certify]').parent().attr("disabled", true);
				}
			});
		}
	});
	
	/* member이메일에 @mju.ac.kr 자동생성 */
	$('input[name=user-member-email]').focus(function(){
		$('input[name=user-member-email]').val("@mju.ac.kr");
	});
	
	$('input[name=cs-join-member-submit]').click(function(){
		if(!$('input[name=user-member-id]').attr("readonly") ||
			!$('input[name=user-password-certify]').attr("disabled") ||
			!$('input[name=user-member-email]').attr("readonly") ||
			!$('input[name=user-email-certify]').parent().attr("disabled")){
			$('.cs-join-form').submit();
		}
	});
	$('input[name=cs-join-non-member-submit]').click(function(){
		if(!$('input[name=user-non-member-id]').attr("readonly") ||
			!$('input[name=user-password-certify]').attr("disabled") ||
			!$('input[name=user-non-member-email]').attr("readonly") ||
			!$('input[name=user-email-certify]').parent().attr("disabled")){
			$('.cs-join-form').submit();
		}
	});
});
</script>
</html>
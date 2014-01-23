<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="css/default.css">
	<link rel="stylesheet" type="text/css" href="css/join.css">
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<title>명지대학교 컴퓨터공학과::아이디/비밀번호 찾기</title>
</head>
<body>
<div class="ct-container">
	<%@ include file="page/header.jsp" %>
		<div class="ct-inner-contents" style="height:600px">
		<!-- 비밀번호 찾기 -->
		<div class="desc-intro">
			<strong>아이디/비밀번호 찾기</strong><br/>
		</div>
		<div style= height:350px;" class="ct-inner-left-contents" >
			<form method="post" id="find-id-form" action="javascript:void(0)">
			<strong style="font-size:20pt; margin:0 0 0 40px;">아이디 찾기</strong><span> *등록된 이메일로 아이디가 발송됩니다.</span>
			<div class="input-info">
				<span class="input-txt">이메일</span><input type="text" name="user-id" style="ime-mode:disabled; text-transform:lowercase;" maxlength="20" class="input-text">
			</div>
			<div class="input-info">
				<span class="input-txt">이름</span><input type="text" name="user-name" class="input-text">
			</div>
			<div class="input-info" style="margin-top:30px;">
				<input type="button" name="btn-find" class="input-button" value="이메일로 찾기">
			</div>
			<br/>
			<br/>
		</form>
		</div>
		<div class="ct-inner-right-contents" style="height:280px;">
			<form method="post" id="find-password-form" action="javascript:void(0)">
				<strong style="font-size:20pt; margin-left:40px;">비밀번호 찾기</strong><span> *등록된 이메일로 임시비밀번호가 발송됩니다.</span>
				<div class="input-info">
					<span class="input-txt">아이디</span><input type="text" name="user-id" style="ime-mode:disabled; text-transform:lowercase;" maxlength="20" class="input-text">
				</div>
				<div class="input-info">
					<span class="input-txt">이름</span><input type="text" name="user-name" class="input-text">
				</div>
				<div class="input-info" style="margin-top:30px;">
					<input type="button" name="btn-find" class="input-button" value="임시 비밀번호 전송">
				</div>
			</form>
		</div>
		<div style="width:400px; float:right">
		<strong><a href="join.intro.jsp">▶ 지금 바로 회원가입하기</a></strong>
		</div>
	</div>
	<%@ include file="page/footer.jsp" %>	
</div>
</body>
<script type="text/javascript">
$(function(){
	$('input[name=btn-find]').click(function(){
		if($('input[name=user-id]').val().length > 4 && 
			$('input[name=user-name]').val().length > 2){
				$.post('UserInfoServlet', {
					action : "findPW",
					id : $('input[name=user-id]').val(),
					name : $('input[name=user-name]').val()
				}, function(data){
					if(data){
						alert("메일보냇스미다");
						$('#find-form').submit();
					}else{
						alert("없는 정보입니다.");
					}
				});
		}else{
			alert("아이디와 이름을 모두 입력하세요");
		}
	});
});
</script>
</html>
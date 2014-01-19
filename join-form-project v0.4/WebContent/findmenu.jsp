<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="css/join.css">
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<!-- 아이디 찾기 -->
	

	<!-- 비밀번호 찾기 -->
	<div class="desc">
		내 정보에 등록한 정보로 비밀번호를 재설정 할 수 있습니다. <br/>
		가입시 등록한 아이디와 이름을 입력하시면 해당 이메일로 임시 비밀번호가 발송됩니다. <br/>
		임시 비밀번호를 입력하시고 비밀번호를 수정해주셔야만 정상적으로 계정을 이용하실 수 있습니다.
	</div>
	<form method="post" id="find-form" action="javascript:void(0)">
		<div class="input-info">
			<span class="input-txt">아이디</span><input type="text" name="user-id" style="ime-mode:disabled; text-transform:lowercase;" maxlength="20" class="input-text">
		</div>
		<div class="input-info">
			<span class="input-txt">이름</span><input type="text" name="user-name" class="input-text">
		</div>
		<div class="input-info">
			<input type="button" name="btn-find" class="input-button" value="비밀번호 찾기">
		</div>
	</form>
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
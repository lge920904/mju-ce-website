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
		<form method="post"  action="UserJoinServlet?action=join" id="cs-join-form" enctype="multipart/form-data">
			<fieldset class="field-form">
				<div class="input-info">
					<span class="input-txt">학번</span><input type="text" name="user-id" class="input-text" placeholder="학번을 입력하세요">
				</div>
				<div class="input-info">
					<span class="input-txt">이름</span><input type="text" name="user-name" class="input-text" placeholder="이름을 입력하세요">
				</div>
				<div class="input-info">
					<button type="button" id="btn-id-certify" >
						<span class="screen-out">학번 인증하기</span>
					</button>
				</div>

				<div class="hidden">
					<div class="input-info">
						<span class="input-txt">비밀번호</span><input type="password" name="user-password" class="input-text" placeholder="비밀번호를 입력하세요">
					</div>
					<div class="input-info">
						<span class="input-txt">비밀번호확인</span><input type="password" name="user-password-certify" id="password-certify"class="input-text" placeholder="비밀번호를 재입력하세요">
					</div>
					<div class="input-info">
						<span class="input-txt">이메일</span><input type="text" name="user-email" class="input-text" placeholder="이메일 주소를 입력하세요">
					</div>
					<div class="input-info">
							<span class="input-txt">인증번호</span><input type="text" name="user-email-certify" id="email-certify" class="input-text" placeholder="이메일 인증번호를 입력하세요" disabled="disabled">
					</div>
					<div class="input-info">
						<button type="button" class="btn-certify" id="btn-email-certify">
							<span class="screen-out">이메일 인증하기</span>
						</button>
					</div>
					<div class="input-info">
						<button type="button" class="btn-submit" id="btn-join-submit">
							<span class="screen-out">회원가입</span>
						</button>
					</div>
				</div>			
			</fieldset>
		</form>
	</div>
</div>
</body>
<script type="text/javascript">
	$(function(){
		$('#btn-id-certify').click(function(){
			$.post('UserJoinServlet', {
				action : "isMember",
				id : document.getElementsByName("user-id")[0].value,
				name : document.getElementsByName("user-name")[0].value
				}, function(data){
					if(data){
						$('.hidden').slideDown();
						document.getElementsByName("user-id")[0].setAttribute("readonly",true);
						document.getElementsByName("user-name")[0].setAttribute("readonly",true);
						$('#btn-id-certify').hide();
					}	
				});
			});
		});
		$('#password-certify').keyup(function(){
			$.post('UserJoinServlet',{
				action : "passwordCertify",
				pw : document.getElementsByName("user-password")[0].value,
				pwc : $('#password-certify').val()
			},function(data){
				if(data){
					document.getElementsByName("user-password")[0].setAttribute("readonly", true);
					$('#password-certify').hide();
				}
		});
		$('#btn-email-certify').click(function(){
			$.post('UserJoinServlet',{
				action : "emailCertify",
				email : document.getElementsByName("user-email")[0].value
			},function(data){
				if(data){
					alert("입력하신 메일로 인증번호를 보냈습니다.");
					document.getElementsByName("user-email-certify").setAttribute("disabled", false);
				}
			});
		});
		$('#email-certify').keyup(function(){
			$.post('UserJoinServlet', {
				action : "emailAuthcodeCertify",
				authcode : $('#email-certify').val()
			}, function(data){
				if(data){
					document.getElementsByName("user-email" )[0].setAttribute("readonly", true);
					document.getElementsByName("user-email-certify")[0].setAttribute("disabled", true);
					$('#btn-email-certify').hide();
				}
			});
		});
		$('#btn-join-submit').click(function(){
			if(!document.getElementsByName("user-id")[0].getAttribute("readonly") ||
					!document.getElementsByName("user-password")[0].getAttribute("readonly") ||
					!document.getElementsByName("user-email")[0].getAttribute("readonly") ){
				alert(" 아이디와 이메일을 반드시 인증받으시고,"+'\n'+" 입력하신 비밀번호가 일치하는지 확인하십시요.");
			}else{
				$('#cs-join-form').submit();
			}
		});
	});
</script>
</html>
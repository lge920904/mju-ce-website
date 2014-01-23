
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
		if($('input[name=user-non-member-id]').val().length >= 4){
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
	$('#btn-member-email-certify').click(function(){
		/* member 의 경우 */
		if($('input[name=user-member-email]').val().length > 6){
			$.post('UserJoinServlet',{
				action : "isMemberEmail",
				email : $('input[name=user-member-email]').val(),
				name : $('input[name=user-member-name]').val()
			},function(data){
				if(data){
					$('input[name=user-member-email]').attr("readonly", true);
				}
			});
		}
	});
	
	$('#btn-non-member-email-certify').click(function(){
		if($('input[name=user-non-member-email]').val().length > 6){
			$.post('UserJoinServlet',{
				action : "doubleCheckEmail",
				email : $('input[name=user-non-member-email]').val()
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
					$('input[name=user-email-certify]').attr("disabled", true);
				}
			});
		}
	});
	
	/* member이메일에 @mju.ac.kr 자동생성 */
	$('input[name=user-member-email]').focus(function(){
		$('input[name=user-member-email]').val("@mju.ac.kr");
	});
	
	$('#btn-member-join').click(function(){
		if( $('input[name=user-password-certify]').attr("disabled")&&
			$('input[name=user-member-email]').attr("readonly")&&
			$('input[name=user-email-certify]').attr("disabled")){
			$('#cs-join-form').submit();
		}else{
			alert("양식을 다 입력하란말이다.");
		}
	});
	
	$('#btn-non-member-join').click(function(){
		if( $('input[name=user-password-certify]').attr("disabled")&&
			$('input[name=user-non-member-email]').attr("readonly")&&
			$('input[name=user-email-certify]').attr("disabled")){
			$('#cs-join-form').submit();
		}else{
			alert("양식을 다 입력하란말이다.");
		}
	});
});
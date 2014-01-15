<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% String[] noMemberSelectOption = {"기업", "학부모", "타교학생", "기타"}; %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<title>Insert title here</title>
</head>
<body>

<section>
<form method="post" name="joinform" action="join-cate-user.jsp">
	<div class="radio"><span>회원 분류</span>
		<div id="auth-user">
			<img src="resources/images/default.jpg">
			<span class="span-radio"><input type="radio" name="user-category" value="member" checked="checked">학교회원</span>
		</div>
		<div id="non-auth-user">
			<img src="resources/images/default.jpg">
			<span class="span-radio"><input type="radio" name="user-category" value="noMember" >일반회원</span>
		</div>
	</div>
	<div id="auth-user-form">
		<div class="form">
			<span>아이디</span><input type="text" name="user-id" >
		</div>
		<div class="form">
			<span>이름</span>
			<input type="text" name="user-name" >
			<input type="button" name="btn-id" onclick="doubleCheckId()" value="아이디 중복확인">
		</div>
	</div>
	<div class="hidden" style="display:none">
		<select name="noMember-category">
		<% for(String option : noMemberSelectOption){ %>
			<option><%= option %></option>
		<% } %>
		</select>
	</div>
	<input type="button" value="회원가입" onclick="validate()">
	<script type="text/javascript">
	$(function(){
		$(function(){
			$("input[name='user-category']").change(function() {
				var radio = $(this).val();
				if(radio == "member"){
					$('.hidden').hide();
				}else if(radio == "noMember"){
					$('.hidden').show();
				}
			});	
		});
	});
	</script>
</form>
</section>
</body>
<script type="text/javascript">
/* 학번 중복 확인 */
function doubleCheckId(){
	$.post('UserJoinServlet',{
		action : "doubleCheckId",
		id : document.getElementsByName("user-id")[0].value,
	}, function(data){
		if(data){
			document.getElementsByName("user-id")[0].setAttribute("readonly",true);
			document.getElementsByName("user-name")[0].setAttribute("readonly",true);
			document.getElementsByName("btn-id")[0].setAttribute("disabled",true);
		}else{
			alert("이미 등록된 사용자입니다.");
		}
	});
}

/* submit */
 function validate(){
	if(!document.getElementsByName("btn-id")[0].getAttribute("disabled")){
		alert(" 아이디와 이메일을 반드시 인증받으시고,"+'\n'+" 입력하신 비밀번호가 일치하는지 확인하십시요.");
	}else{
		document.getElementsByName("joinform")[0].submit();
	}
}
</script>
</html>
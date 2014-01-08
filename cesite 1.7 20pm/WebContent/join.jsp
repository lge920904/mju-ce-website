<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>   
     <%
   	String[] position = {"강사","겸임조교수", "겸임부교수", "겸임교수", "조교수", "부교수", "교수", "명예교수", "주임교수"};
	String[] jobState = {"재직", "휴직", "퇴직"};
	String[] normalCategory = {"업체", "학부모", "기타"};
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title> 명지대학교 컴퓨터공학과 :: 회원가입 </title>
	<link rel="stylesheet" type="text/css" href="css/join.css">
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
<article class="join-article">
	<% if (request.getMethod().equals("POST")) { %>
	<section class="join-section">
		<form method="POST" action="register.jsp?category=<%=request.getParameter("user-category")%>">
			<fieldset>
				<div id="user" class="hidden">
					<div class="label"><span>id</span>
						<input type="text" name="userid" id="input-id" class="id">
					</div>
					<div id="div-id">
					</div>
					<div class="label"> <span>password</span>
						<input type="password" name="password" id="input-password" class="password">
					</div>
					<div class="label"> <span>password confirm</span>
						<input type="password" name="password-confirm" id="input-password-confirm" class="password">
					</div>
					<div id="div-password">
					</div>
					<div class="label"> <span>name </span>
						<input type="text" name="name" id="student-name" class="name">
					</div>
					<div class="label"> <span>phone </span>
						<input type="tel" name="phone" id="student-phone" class="phone" placeholder="010-0000-0000">
					</div>
				</div>	
		<% if(request.getParameter("user-category").equals("student")){ %>
			<!-- student form -->
				<div id="user-student" >
					<div class="label"> <span>email</span>
						<input type="text" name="student-email" class="email" placeholder="myiweb email."><span>@mju.ac.kr &nbsp;</span>
						<input type="button" name="confirm" class="email-confirm-button" value="confirm">
					</div>
					<div class="div-email">
					</div>
					<div class="label"><span>confirm code</span>
						<input type="text" class="email-confirm-code" name="email-confirm-code">
					</div>
					<div class="label"> <span>student id</span>
						<input type="text" name="stu-id" id="input-stu-id" placeholder="60112389">
					</div>
					<div id="div-stuid"></div>
				</div>
		<% } else if(request.getParameter("user-category").equals("professor")){%>
			<!-- professor form -->
				<div id="user-professor" class="hidden">
					<div class="label"> <span>email</span>
						<input type="text" name="professor-email" class="email" placeholder="myiweb email."><span>@mju.ac.kr &nbsp;</span>
						<input type="button" name="confirm" class="email-confirm-button" value="confirm">
					</div>
					<div class="label"><span>confirm code</span>
						<input type="text" class="email-confirm-code" name="email-confirm-code">
					</div>
					<div class="div-email">
					</div>
					<div class="label"> <span>professor id</span>
						<input type="text" name="professor-id" id="input-professor-id" placeholder="00000"> 
					</div>
					<div class="label"> <span>professor position</span>
						<select>
							<% for(String p : position){ %>
							<option name="professor-position" value="<%=p%>"><%=p%></option>
							<% } %>
						</select>
					</div>
					<div class="label" > <span>professor major</span>
						<input type="text" name="professor-major" placeholder="network security">
					</div>
					<div class="label"> <span>professor room</span>
						<input type="text" name="professor-room">
					</div>
					<div class="label"> <span>professor lab</span>
						<input type="text" name="professor-lab">
					</div>
					<div class="label"> <span>professor room phone</span>
						<input type="tel" name="professor-room-phone">
					</div>
					<div class="label"> <span>professor job state</span>
						<select>
							<% for(String j : jobState){ %>
							<option name="professor-job-state" value="<%=j%>"><%=j%></option>
							<% } %>
						</select>
					</div>
				</div>
		<% } else if(request.getParameter("user-category").equals("staff")){ %>
			<!-- staff form -->
				<div id="user-staff" class="hidden">
					<div class="label"> <span>email</span>
						<input type="text" name="staff-email" class="email" placeholder="myiweb email."><span>@mju.ac.kr &nbsp;</span>
						<input type="button" name="confirm" class="email-confirm-button" value="confirm">
					</div>
					<div class="label"><span>confirm code </span>
						<input type="text" class="email-confirm-code" name="email-confirm-code">
					</div>
					<div class="div-email">
					</div>
					<div class="label"><span>staff id</span>
						<input type="text" name="staff-id" id="input-staff-id" placeholder="00000">
					</div>
					<div class="label"><span>department</span>
						<input type="text" name="staff-department">
					</div>
					<div class="label"><span>department phone</span>
						<input type="tel" name="staff-department-phone">
					</div>
				</div>
		<% } else if(request.getParameter("user-category").equals("normal")){ %>
				<!--  normal form -->
				<div id="user-normal" class="hidden">
					<div class="label"><span>email </span>
						<input type="text" name="normal-email" class="email" placeholder="myiweb email.">
					</div>
					<div class="label"><span>normal category</span>
						<select>
						<% for(String nc : normalCategory){ %>
							<option name="normal-category" value="<%=nc%>"><%=nc%></option>
							<% } %>
						</select>
					</div>
				</div>
		<% } %>
			</fieldset>
			<input type="submit" id="join-button" value="join">
		</form>
	</section>
	<%} else { %>
	<section class="join-section">
		<form method="POST" action="#">
			<input type="radio" name="user-category" value="student" checked="checked"><span>학생</span>
			<input type="radio" name="user-category" value="professor"><span>교수</span>
			<input type="radio" name="user-category" value="staff"><span>직원</span>
			<input type="radio" name="user-category" value="normal"><span>일반회원</span>
			<input type="submit" id="user-category-button" value="gogo">
		</form>
	</section>
	<% } %>
</article>
</body>
<script>
$(function() {
	$('#input-id').keyup(function() {
		$.post('UserJoinServlet', 
			{query: $('#input-id').val(),
			 action: "id"}, 
			function(data) {
				$('#div-id').html(data).show();
			}
		);
	});
	$('#input-password-confirm').keyup(function() {
		$.post('UserJoinServlet', 
			{query: $('#input-password-confirm').val(),
			 password: $('#input-password').val(),
			 action: "password"}, 
			function(data) {
				$('#div-password').html(data).show();
			}
		);
	});
	$('.email-confirm-button').click(function() {
		$.post('UserJoinServlet', 
			{query: $('.email').val(),
			 action: "email"}, 
			function(data) {
				alert("입력하신 계정으로 인증코드를 전송하였습니다");
			}
		);
	});
	$('.email-confirm-code').keyup(function() {
		$.post('UserJoinServlet', 
			{query: $('.email-confirm-code').val(),
			 action: "email-confirm"}, 
			function(data) {
				$('.div-email').html(data).show();
			}
		);
	});
});
</script>
</html>
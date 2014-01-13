<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<title>명지대학교 컴퓨터공학과</title>
</head>
<body>
<% 
	if(request.getMethod() == "POST"){
		 session.setAttribute("userId", request.getParameter("userid"));
		 session.setMaxInactiveInterval(60*30); //session 30분 유지.
	     response.sendRedirect("index.jsp");
	} 
%>
<% if (session.getAttribute("userId") == null) { %>
  <form id="login-form" method="POST" action="index.jsp">
	  ID: <input id="id" type="text" name="userid">
	  Password: <input id="password" type="password" name="password">
	  <input id="login-button" type="button" value="login">	
	  <div id="div-login">
	  </div>
  </form>	
  <a href="join.jsp">회원가입</a> 
<% } else { %>
	<section>
	 안녕하세요. <b><%=session.getAttribute("userId") %> </b>님<br/>
  	<a id="logout" href="logout.jsp">로그아웃</a>  
	<a href="user-modify.jsp">정보수정</a>
	<a href="user-delete.jsp">탈퇴</a>
	</section>
<% } %>
</body>
<script>
$(function(){
	$('#login-button').click(function(){
		$.post('UserLoginServlet',
			{id: $('#id').val(),
			password: $('#password').val()},
			function(data){
				alert(data);
				$('#login-form').submit();
			}
		);
	});
});

</script>
</html>
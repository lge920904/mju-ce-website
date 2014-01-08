<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	request.setCharacterEncoding("utf-8");
	String category = request.getParameter("category");
	String userid = request.getParameter("userid");
	String pwd = request.getParameter("password");
	String pwd_confirm = request.getParameter("password_confirm");
	String name = request.getParameter("name");
	
	if(request.getParameter("category") == "student"){
		String email = request.getParameter("student-email")+"@mju.ac.kr";
		String stuid = request.getParameter("stu-id");
	}else if(request.getParameter("category") == "professor"){
		String email = request.getParameter("professor-email")+"@mju.ac.kr";	
	}else if(request.getParameter("category") == "staff"){
		String email = request.getParameter("staff-email")+"@mju.ac.kr";
		String staffid = request.getParameter("staff-id");
	}else{
		String email = request.getParameter("normal-email");
	}
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원목록</title>
</head>
<body>
	<div class="container">
 		<div class="alert alert-success">
 			<b><%= name %></b>님 등록해주셔서 감사합니다.<br/>
 			id : <b><%=userid%></b><br/>
 			pw : <b><%= pwd %></b><br/>
 		</div>
	 	<div class="form-action">
	 		<a href="index.jsp" class="btn">첫 화면으로</a>
	 	</div>
 	</div>
</body>
</html>
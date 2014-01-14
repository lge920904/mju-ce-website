<%@page import="kr.ac.mju.cs.bean.Staff"%>
<%@page import="kr.ac.mju.cs.bean.Professor"%>
<%@page import="kr.ac.mju.cs.bean.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="kr.ac.mju.cs.bean.User, java.io.File"%>   
<% 
	User sessionUser = (User)session.getAttribute("sessionUser");
	String id = sessionUser.getId();
	String password = sessionUser.getPassword();
	String name = sessionUser.getName();
	String email = sessionUser.getEmail();
	File photo = sessionUser.getPhoto();
	String study = "";
	String major = "";
	int department = 0;
	
	int category = sessionUser.getCategory();
	
	if(category == 1){
		major = ((Professor)sessionUser).getMajor();
	}else if(category == 2){
		department = ((Staff)sessionUser).getDepartment();
	}else if(category == 3){
		study = ((Student)sessionUser).getStudy();
	}
	%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title> 명지대학교 컴퓨터공학과 :: 회원정보수정 </title>
	<link rel="stylesheet" type="text/css" href="css/modify.css">
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
<article class="article">
	<form method="POST" action="UserInfoServlet" enctype="multipart/form-data">
		<div class="section">
			<div class="hidden" id="action">
				<input type="hidden" name="action" value="modify" disabled="disabled">
			</div>
			<p><span>아이디</span><input type="text" name="user-id" id="modify-user-id" value="<%= id %>" disabled="disabled"></p>
			<p><span>비밀번호</span><input type="password" name="user-password" value="<%= password %>" id="modify-user-password"></p>
			<p><span>이름</span><input type="text" name="user-name" value="<%= name %>" id="modify-user-name"></p>
			<p><span>이메일</span><input type="text" name="user-email" value="<%= email %>" id="modify-user-email" disabled="disabled"></p>
			<p><span>사진</span><input type="file" name="user-photo" value="<%= photo.getPath() %>" id="modify-user-photo">	</p>	
			<p><input type="hidden" name="user-category" value="<%= category%>"></p>
			<div class="hidden" id="hidden-student-form">
				<span>스터디</span><input type="text" name="student-study" value="<%= study %>" id="modify-student-study">
			</div>
			<div class="hidden" id="hidden-professor-form">
				<span>전공</span><input type="text" name="professor-major" value="<%= major %>" id="modify-professor-major">
			</div>
			<div class="hidden" id="hidden-staff-form">
				<span>부서</span><input type="text" name="staff-department" value="<%= department %>" id="modify-staff-department">
			</div>
			<input type="submit" id="btn-modify-submit" value="정보수정">
		</div>
	</form>
</article>
</body>
</html>
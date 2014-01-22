<%@page import="kr.ac.mju.cs.bean.Staff"%>
<%@page import="kr.ac.mju.cs.bean.Professor"%>
<%@page import="kr.ac.mju.cs.bean.Student"%>
<%@page import="kr.ac.mju.cs.bean.NonMember"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="kr.ac.mju.cs.bean.User, java.io.File"%> 
    
<% 
	User sessionUser = (User)session.getAttribute("sessionUser");
	String id = sessionUser.getId();
	String password = sessionUser.getPassword();
	String name = sessionUser.getName();
	String email = sessionUser.getEmail();
	File photo = sessionUser.getPhoto();
	int category = sessionUser.getCategory();
	int active = sessionUser.getActive();
	String study = "";
	String major = "";
	int department = 0;
	int option = 0;
	
	if(category == 1){
		major = ((Professor)sessionUser).getMajor();
	}else if(category == 2){
		department = ((Staff)sessionUser).getDepartment();
	}else if(category == 3){
		study = ((Student)sessionUser).getStudy();
	}else if(category == 4){
		option = ((NonMember)sessionUser).getOption();
	}
	%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="css/default.css">
	<link rel="stylesheet" type="text/css" href="css/join.css">
<title>명지대학교 컴퓨터공학과::회원정보수정</title>
</head>
<body>
<div class="ct-container">
		<%@ include file="page/header.jsp" %>	
	<div class="ct-inner-contents">
		<div class="desc-intro">
			<strong>정보 수정</strong><br/><br/>
			<span>아이디는 기본적으로 변경이 불가능합니다.<br/>
			이메일 주소를 변경하실 경우, 변경하고자 하는 이메일 주소로 재인증 받으셔야 합니다. <br/>
			</span>
		</div>
		<div class="ct-form">
			<form method="post" action="UserJoinServlet?action=member-join" autocomplete="off" id="cs-join-form" enctype="multipart/form-data">
				<div class="input-info">
					<span class="input-txt">아이디</span><input type="text" name="user-id" readonly="readonly" value="<%= id %>" class="input-text">
				</div>
				<div class="input-info">
						<span class="input-txt">이메일</span><input type="text" name="user-non-member-email" readonly="readonly" value="<%= email %>" class="input-text" >
				</div>				
				<div class="input-info">
					<span class="input-txt">이름</span><input type="text" name="user-name" value="<%= name %>" class="input-text">
				</div>
				<div class="input-info">
					<span class="input-txt">비밀번호</span><input type="text" name="user-password" class="input-text">
				</div>
				<div class="input-info">
						<span class="input-txt">비밀번호확인</span><input type="password" name="user-password-certify" class="input-text" >
				</div>
				<div class="input-info">
					<span class="input-txt">사진</span><input type="text" name="user-photo" class="input-text">
				</div>
				<div class="input-info">
						<input type="button" id="btn-user-modify" class="btn-submit" value="정보수정">
				</div>
			</form>
		</div> 	
		<div style="width:400px; margin-top:40px; float:right">
			<a href="userdelete.jsp"> 회원탈퇴를 원하실 경우, 클릭하세요. </a>
		</div>
	</div>	
	<%@ include file="page/footer.jsp" %>
</div>
</body>
</html>
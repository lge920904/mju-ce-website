<%@page import="kr.ac.mju.cs.bean.Staff"%>
<%@page import="kr.ac.mju.cs.bean.Professor"%>
<%@page import="kr.ac.mju.cs.bean.Student"%>
<%@page import="kr.ac.mju.cs.bean.NonMember"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="kr.ac.mju.cs.bean.User"%>
    
<% 
	User sessionUser = (User)session.getAttribute("sessionUser");
	String id = sessionUser.getId();
	String name = sessionUser.getName();
	String email = sessionUser.getEmail();
	String engName = request.getParameter("engName");
	String position = new String(request.getParameter("position").getBytes("iso-8859-1"), "UTF-8");
	String roomPhone = request.getParameter("roomPhone");
	String comment = new String(request.getParameter("comment").getBytes("iso-8859-1"), "UTF-8");
	String homepage = request.getParameter("homepage");
	String major = new String(request.getParameter("major").getBytes("iso-8859-1"), "UTF-8");
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="css/default.css">
	<link rel="stylesheet" type="text/css" href="css/join.css">
<title>명지대학교 컴퓨터공학과::교수정보수정</title>
</head>
<body>
<div class="ct-container">
		<%@ include file="page/header.jsp" %>	
	<div class="cs-join">
		<div class="desc-intro">
			<strong>정보 수정</strong><br/><br/>
			<span>변경 하시고자 하는 정보를 입력해주세요.</span>
		</div>
		<div class="join-form">
			<form method="post" action="ProfessorInfoServlet" autocomplete="off" enctype="multipart/form-data">
				<div class="input-info">
					<span class="input-txt">아이디</span><input type="text" name="user-id" readonly="readonly" value="<%= id %>" class="input-text">
				</div>
				<div class="input-info">
					<span class="input-txt">이메일</span><input type="text" name="user-email" value="<%= email %>" class="input-text">
				</div>
				<div class="input-info">				
					<span class="input-txt">영문성함</span><input type="text" name="prof-engName" value="<%= engName %>" class="input-text">
				</div>
				<div class="input-info">				
					<span class="input-txt">관심분야</span><input type="text" name="prof-major" value="<%= major %>" class="input-text">
				</div>
				<div class="input-info">				
					<span class="input-txt">교수실 전화번호</span><input type="text" name="prof-roomPhone" value="<%= roomPhone %>" class="input-text">
				</div>
				<div class="input-info">				
					<span class="input-txt">직위</span><input type="text" name="prof-position" value="<%= position %>" class="input-text">
				</div>
				<div class="input-info">				
					<span class="input-txt">짧은 한마디</span><input type="text" name="prof-comment" value="<%= comment %>" class="input-text">
				</div>
				<div class="input-info">				
					<span class="input-txt">홈페이지 주소</span><input type="text" name="prof-homepage" value="<%= homepage %>" class="input-text">
				</div>
				<div class="input-info">
						<input type="submit" class="btn-submit input-button" value="정보수정">
				</div>
			</form>
		</div> 	
	</div>	
	<%@ include file="page/footer.jsp" %>
</div>
</body>
</html>
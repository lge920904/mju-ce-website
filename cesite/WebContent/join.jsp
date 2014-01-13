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
<article class="join-article"><!--  enctype="multipart/form-data" -->
	<form method="POST" action="UserInfoServlet" enctype="multipart/form-data">
		<div class="join-section">
			<p><span>아이디</span><input type="text" name="user-id" id="join-user-id"></p>
			<p><span>비밀번호</span><input type="text" name="user-password" id="join-user-password"></p>
			<p><span>이름</span><input type="text" name="user-name" id="join-user-name"></p>
			<p><span>이메일</span><input type="text" name="user-email" id="join-user-email"></p>
			<p><span>사진</span><input type="file" name="user-photo" id="join-user-photo">	</p>	
			<p class="p-radio"><span>회원 분류</span>
				<span class="span-radio"><input type="radio" name="user-category" value="student" checked="checked">학생</span>
				<span class="span-radio"><input type="radio" name="user-category" value="professor">교수</span>
				<span class="span-radio"><input type="radio" name="user-category" value="staff">직원</span>
				<span class="span-radio"><input type="radio" name="user-category" value="normal">일반회원</span>
			</p>
			<div class="hidden" id="hidden-student-form">
				<span>스터디</span><input type="text" name="student-study" id="join-student-study">
			</div>
			<div class="hidden" id="hidden-professor-form">
				<span>전공</span><input type="text" name="professor-major" id="join-professor-major">
			</div>
			<div class="hidden" id="hidden-staff-form">
				<span>부서</span><input type="text" name="staff-department" id="join-staff-department">
			</div>
			<input type="submit" id="btn-join-submit" value="회원가입">
		</div>
	</form>
</article>
</body>
</html>
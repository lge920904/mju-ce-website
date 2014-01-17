<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="kr.ac.mju.cs.bean.NonMember"%>
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
	<script src="./javascript/join.ajax.js"></script>
<title>y</title>
</head>
<body>
<div class="cs-join">
	<div class="desc-intro">
		<strong>가입양식이에욤!!</strong>
	</div>
	<div class="join-form">
		<form method="post" action="UserJoinServlet?action=member-join" autocomplete="off" id="cs-join-form" enctype="multipart/form-data">
			<fieldset class="field-form">
			<% if(isMember){ %>
				<input type="hidden" name="user-category" value="member">
				<div class="input-info">
					<span class="input-txt">아이디</span><input type="text" name="user-member-id" style="ime-mode:disabled; text-transform:lowercase;" maxlength="8" class="input-text">
				</div>				
				<div class="input-info">
					<span class="input-txt">이름</span><input type="text" name="user-member-name" class="input-text">
				</div>
			<%}else{%>
				<input type="hidden" name="user-category" value="non-member">
				<div class="input-info">
					<span class="input-txt">아이디</span><input type="text" name="user-non-member-id" style="ime-mode:disabled; text-transform:lowercase;" maxlength="20" class="input-text">
				</div>
				<div class="input-info">
					<span class="input-txt">이름</span><input type="text" name="user-non-member-name" class="input-text">
				</div>
			<%}%>
				<div class="hidden">
					<div class="input-info">
						<span class="input-txt">비밀번호</span><input type="password" style="ime-mode:disabled; text-transform:lowercase;" name="user-password" maxlength="20" class="input-text">
					</div>
					<div class="input-info">
						<span class="input-txt">비밀번호확인</span><input type="password" name="user-password-certify" class="input-text" >
					</div>
					<% if(isMember){ %>
					<div class="input-info">
						<span class="input-txt">이메일</span><input type="text" style="ime-mode:disabled; text-transform:lowercase;" name="user-member-email" class="input-text">
					</div>
					<div class="input-info">
						<input type="button" class="btn-certify" id="btn-member-email-certify" value="이메일인증">
					</div>
					<% }else{ %>
					<div class="input-info">
						<span class="input-txt">이메일</span><input type="text" style="ime-mode:disabled; text-transform:lowercase;" name="user-non-member-email" class="input-text" >
					</div>
					<div class="input-info">
						<input type="button" class="btn-certify" id="btn-non-member-email-certify" value="이메일인증">
					</div>
					<% } %>
					<div class="input-info">
							<span class="input-txt">인증번호</span><input type="text" name="user-email-certify" class="input-text" >
					</div>
					<% if(isMember){ %>
					<div class="input-info">
						<input type="button" id="btn-member-join" class="btn-submit" value="회원가입">
					</div>
					<% }else{ %>
					<div class="input-info">
						<span class="input-txt">회원구분</span>
						<select class="input-select" name="user-non-member-select">
						<% for(NonMember.NON_MEMBER_OPTION option : NonMember.NON_MEMBER_OPTION.values()){ %>
							<option class="input-select-option" value="<%= option.getIndex() %>"><%= option.getValue() %></option>
							<% } %>
						</select>
					</div>
					<div class="input-info">
						<input type="button" id="btn-non-member-join" class="btn-submit" value="회원가입">
					</div>
					<% } %>
				</div>			
			</fieldset>
		</form>
	</div>
</div>
</body>
</html>
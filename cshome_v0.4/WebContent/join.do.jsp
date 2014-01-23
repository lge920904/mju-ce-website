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
	<link rel="stylesheet" type="text/css" href="css/default.css">
	<link rel="stylesheet" type="text/css" href="css/join.css">
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="js/userjoin.js"></script>
	
<title>명지대학교 컴퓨터공학과::회원가입</title>
</head>
<body>
<div class="ct-container">
		<%@ include file="page/header.jsp" %>
	<div class="ct-inner-contents">	
		<div class="desc-intro">
			<strong>컴퓨터공학과 회원가입</strong><br/>
			<span> 간단한 회원가입으로 명지대 컴퓨터공학과의 다양한 컨텐츠를 이용하실 수 있습니다.</span>
		</div>
		<div class="ct-inner-whole">
			<div class="ct-inner-left-contents">
					<div class="left-desc">
						<strong>미래 인재 양성</strong><br/>
						<span>모바일, 컴퓨터, 멀티미디어 등 기술의 발전에 의한<br/><br/>
						변화에 중추적인 역할을 담당할 전문적인 인재,<br/><br/>
						산업 현장에서 바로 활용할 수 있는 인재를 양성하고 있습니다.<br/><br/></span>
						<img src="resources/join_img/frame.PNG">
						<br/><br/>
						<strong>성공을 위한 발판</strong><br/>
						<span>좋은 환경과 좋은 교수님들이 계신 컴퓨터공학과,<br/><br/>
						당신의 재능을 이 곳에서 펼칠 수 있도록 <br/><br/>
						당신의 발판이 되겠습니다.<br/><br/></span><br/>
						<strong>열정이 있는 명지대학교 <b>컴퓨터공학과</b>입니다.<br/></strong>
					</div>
			</div>
			<div class="ct-form ct-inner-right-contents">
				<form method="post" action="UserJoinServlet?action=member-join" autocomplete="off" id="cs-join-form" enctype="multipart/form-data">
					<% if(isMember){ %>
						<input type="hidden" name="user-category" value="member">
						<div class="input-info">
							<span class="input-txt">아이디(학번)</span><input type="text" placeholder="ex)60112389" name="user-member-id" style="ime-mode:disabled; text-transform:lowercase;" maxlength="8" >
							<span class="alert-msg">학번 8자리를 입력하세요.</span>
						</div>				
						<div class="input-info">
							<span class="input-txt">이름</span><input type="text" name="user-member-name" >
						</div>
						<%}else{%>
						<input type="hidden" name="user-category" value="non-member">
						<div class="input-info">
							<span class="input-txt">아이디</span><input type="text" placeholder="ex)abcd123" name="user-non-member-id" style="ime-mode:disabled; text-transform:lowercase;" maxlength="20" >
						</div>
						<div class="input-info">
							<span class="input-txt">이름</span><input type="text" name="user-non-member-name" >
						</div>
					<%}%>
						<div class="input-info">
							<span class="input-txt">비밀번호</span><input type="password" style="text-transform:lowercase;" name="user-password" maxlength="20" >
							<span class="alert-msg">최대 20자리의 영문+숫자조합으로 입력하세요.</span>
						</div>
						<div class="input-info">
							<span class="input-txt">비밀번호확인</span><input type="password" name="user-password-certify">
							<span class="alert-msg">입력하신 비밀번호와 똑같이 입력하세요.</span>
						</div>
						<% if(isMember){ %>
						<div class="input-info">
							<span class="input-txt">이메일</span><input type="text" placeholder="ex)abcd1234@mju.ac.kr" style="ime-mode:disabled; text-transform:lowercase;" name="user-member-email" >
							<span class="alert-msg">반드시 '@mju.ac.kr'주소를 이용하세요.</span>
						</div>
						<div class="input-info">
							<input type="button" class="btn-certify" id="btn-member-email-certify" value="이메일인증">
						</div>
						<% }else{ %>
						<div class="input-info">
							<span class="input-txt">이메일</span><input type="text" style="ime-mode:disabled; text-transform:lowercase;" name="user-non-member-email"  >
						</div>
						<div class="input-info">
							<input type="button" class="btn-certify" id="btn-non-member-email-certify" value="이메일인증">
						</div>
						<% } %>
						<div class="input-info">
							<span class="input-txt">인증번호</span><input type="text" name="user-email-certify" >
							<span class="alert-msg">위의 이메일로 전송된 인증번호를 입력하세요.</span>
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
				</form>
			</div>
		</div>
	</div>
		<%@ include file="page/footer.jsp" %>
</div>	
</body>
</html>
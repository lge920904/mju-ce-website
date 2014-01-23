<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="kr.ac.mju.cs.bean.User"%>
<div class="info-left">
	<div class="ct-sidemenu-ads">
		<div class="ct-ads-info" style="margin-top: 10px;">
		<% 
			User user = (User)session.getAttribute("sessionUser");
			String loginError = (String)session.getAttribute("loginError");
			if(user == null ){ %>
				<% if(loginError != null){%>
					<script>
						$(function(){
							alert("<%= loginError %>");
						});
					</script>
				<% } %>
			<form class="login" id="login-form" action="UserInfoServlet?action=login" method="post" autocomplete="off">
				<input type="hidden" name="requestUrl" value="<%= request.getRequestURI() %>">
				<input type="text" name="user-id" placeholder="Email or ID"
					style="width: 275px; margin: 0"> 
				<input type="text" name="user-password"
					placeholder="password" style="width: 185px; margin: 0">
				<input class="buttonbig" name="btn-user-login" type="button" value="로그인">
			</form>
			<script>
			$(function(){
				$('input[name=btn-user-login]').click(function(){
					if($('input[name=user-id]').val().length < 4 ||
						$('input[name=user-password]').val().length < 4){
						alert("아이디와 비밀번호를 모두 입력하세요.");
					}else{
						$('#login-form').submit();
					}
				});
			});
			</script>
			<p class="ct-subline-login">
				<a href="join.intro.jsp">회원가입 | </a><a href="findmenu.jsp">비밀번호 찾기</a>
			</p>
		<% } else {%>
			<p> <%= user.getName() %>님 반갑습니다.</p>
			<p class="ct-subline-login">
				<a href="modify.do.jsp">정보수정 | </a><a href="logout.jsp?requestUrl=<%=request.getRequestURI()%>">로그아웃</a>
		<% } %>
		</div>
		<div class="clr"></div>
	</div>
	<div>
	<ul class="info-menu">
		<li><span>Infomation</span></li>
		<li><a href="deptinfo.jsp">학과소개</a></li>
		<li><a href="ProfessorInfoServlet">교수소개</a></li>
		<li><a href="eduinfo.jsp">교육목표</a></li>
		<li><a href="#">찾아오시는 길</a></li>
	</ul>
	</div>
</div>

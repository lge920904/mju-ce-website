<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="kr.ac.mju.cs.bean.User, kr.ac.mju.cs.bean.MenuConstants"%> 
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type='text/javascript' src='js/userscripts.js?ver=3.7.1'></script>
	<script type='text/javascript' src='js/jquery.js?ver=1.10.2'></script>
	<script type='text/javascript' src='js/jquery-migrate.min.js?ver=1.2.1'></script>
	<script type="text/javascript" src="js/modernizr.custom.70736.js"></script>
	
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
				<input type="hidden" name="requestUrl" value="<%= request.getRequestURI()%>?sub=<%=sub%>">
				<input type="text" name="user-id" placeholder="Email or ID"
					style="width: 260px; margin: 0"> 
				<input type="text" name="user-password"
					placeholder="password" style="width: 170px; margin: 0">
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
				<a href="modify.do.jsp">정보수정 | </a><a href="logout.jsp?requestUrl=<%=request.getRequestURI()%>?sub=<%=sub%>">로그아웃</a>
		<% } %>
		</div>
		<div class="clr"></div>
	</div>
	<div>
	<ul class="info-menu">
		<li>
			<div class="info-menu-content">
				<span>About.</span>
			</div>
		</li>
		<% for(MenuConstants.ABEEKMENU mc : MenuConstants.ABEEKMENU.values()){ %>
		<li>
			<div class="info-menu-content">
				<a href="abeek.jsp?sub=<%= mc.getSubAction()%>">
					<strong class="info-menu-main"><%= mc.getSubMenuName()%></strong>
					<span class="info-menu-sub"><%= mc.getSubMenuDesc() %></span>
				</a>
			</div>
		</li>
		<% } %>
	</ul>
	</div>
</div>

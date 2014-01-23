<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="kr.ac.mju.cs.bean.User"%>
		<div class="info-left">
			<div class="ct-sidemenu-ads">
				<div class="ct-ads-info" style="margin-top: 10px;">
				<% 
					User user = (User)session.getAttribute("sessionUser");
					if(user == null){ %>
						<form class="login" action="UserInfoServlet?action=login" method="post">
							<input type="text" name="user-id" placeholder="Email or ID"
								style="width: 275px; margin: 0"> <input type="text" name="user-password"
								placeholder="password" style="width: 185px; margin: 0">
							<input class="login-submit" type="submit" value="로그인">
						</form>
						<p class="ct-subline-login">
							<a href="join.intro.jsp">회원가입 | </a><a href="findmenu.jsp">비밀번호 찾기</a>
						</p>
					<%} else { %>
						<p> <%= user.getName() %>님 반갑습니다.</p>
						<p class="ct-subline-login">
							<a href="modify.do.jsp">정보수정 | </a><a href="logout.jsp">로그아웃</a>
						</p>
					<% } %>
					</div>
				<div class="clr"></div>
			</div>
			<ul class="info-menu">
				<li><span>Infomation</span></li>
				<a href="deptinfo.jsp"><li>학과소개</li></a>
				<a href="ProfessorInfoServlet"><li>교수소개</li></a>
				<a href="eduinfo.jsp"><li>교육목표</li></a>
				<a href="#"><li>찾아오시는 길</li></a>
			</ul>
		</div>

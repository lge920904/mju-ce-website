<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<header class="ct-header">
	<div class="ct-inner ct-cf">
		<h1 class="ct-branding">
			<a class="ct-logo" href="index.jsp" rel="home">Dept.
				ComputerEngineering</a>
		</h1>
		<div class="ct-nav-wrapper">
			<nav class="ct-nav-main">
				<ul>
					<li><a href="deptinfo.jsp?sub=outline">학과 소개</a></li>
					<li><a href="graduinfo.jsp?sub=outline">대학원 소개</a></li>
					<li><a href="abeek.jsp?sub=outline">공학 인증</a></li>
					<li><a href="notice.jsp?sub=outline">공지 사항</a></li>
					<li><a href="#">커뮤니티</a></li>
				</ul>
			</nav>
		</div>
		<div class="ct-header-items-right ct-cf">
			<div class="ct-search ct-search-open" id="ct-search">
				<form method="get" id="searchform" action="">
					<div class="ct-search-input-wrap">
						<input class="ct-search-input" placeholder="Search on Site..."
							type="text" value="" name="s" id="s" />
					</div>
					<input class="ct-search-submit" type="submit" id="go" value=""><span
						class="ct-icon-search"></span>
				</form>
			</div>
		</div>
		<!--/ct-header-items-right-->
	</div>
	<!-- ct-inner -->
</header>
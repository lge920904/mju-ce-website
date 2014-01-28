<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <% String sub = request.getParameter("sub"); 	%>
  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<link rel="stylesheet" type="text/css" href="css/info/component.css" />
	<link rel="stylesheet" type="text/css" href="css/info/contentsnav.css" />
	<link rel="stylesheet" type="text/css" href="css/default.css" />
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<title>명지대학교 컴퓨터공학과::공지사항</title>
</head>
<body>
<div class="ct-container">
	<%@ include file="page/header.jsp" %>
	<% if(sub.equals("society")) { %>
	<div class="deptinfo-main" id="community-society">
		<div class="contents-breadcrumb">
			<ul class="content-crumbs">
				<li><a href="index.jsp">Home</a></li>
				<li><a href="#">학생회</a></li>
			</ul>
		</div>
		<div class="info-main">
			<%@ include file="page/community-sidemenu.jsp" %>
			<div class="info-right">
				<h1 class="dept-content-title">학생회</h1>
				<p><strong>학생회</strong><br/>
				학생회
			</div>
		</div>
	</div>	
	<% } else if(sub.equals("scholarship-meeting")){ %>
		<div class="deptinfo-main" id="community-society">
		<div class="contents-breadcrumb">
			<ul class="content-crumbs">
				<li><a href="index.jsp">Home</a></li>
				<li><a href="#">학생회</a></li>
			</ul>
		</div>
		<div class="info-main">
			<%@ include file="page/community-sidemenu.jsp" %>
			<div class="info-right">
				<h1 class="dept-content-title">학생회</h1>
				<p><strong>학생회</strong><br/>
				학생회
			</div>
		</div>
	</div>	
	<% }else if(sub.equals("circle")) {%>
	<div class="deptinfo-main" id="community-society">
		<div class="contents-breadcrumb">
			<ul class="content-crumbs">
				<li><a href="index.jsp">Home</a></li>
				<li><a href="#">학생회</a></li>
			</ul>
		</div>
		<div class="info-main">
			<%@ include file="page/community-sidemenu.jsp" %>
			<div class="info-right">
				<h1 class="dept-content-title">학생회</h1>
				<p><strong>학생회</strong><br/>
				학생회
			</div>
		</div>
	</div>	
	<% }else if(sub.equals("qna")){ %>
	<div class="deptinfo-main" id="community-society">
		<div class="contents-breadcrumb">
			<ul class="content-crumbs">
				<li><a href="index.jsp">Home</a></li>
				<li><a href="#">학생회</a></li>
			</ul>
		</div>
		<div class="info-main">
			<%@ include file="page/community-sidemenu.jsp" %>
			<div class="info-right">
				<h1 class="dept-content-title">학생회</h1>
				<p><strong>학생회</strong><br/>
				학생회
			</div>
		</div>
	</div>	
	<% }else if(sub.equals("reference")){ %>
	<div class="deptinfo-main" id="community-society">
		<div class="contents-breadcrumb">
			<ul class="content-crumbs">
				<li><a href="index.jsp">Home</a></li>
				<li><a href="#">학생회</a></li>
			</ul>
		</div>
		<div class="info-main">
			<%@ include file="page/community-sidemenu.jsp" %>
			<div class="info-right">
				<h1 class="dept-content-title">학생회</h1>
				<p><strong>학생회</strong><br/>
				학생회
			</div>
		</div>
	</div>	
	<% }else if(sub.equals("info-sharing")) {%>
	<div class="deptinfo-main" id="community-society">
		<div class="contents-breadcrumb">
			<ul class="content-crumbs">
				<li><a href="index.jsp">Home</a></li>
				<li><a href="#">학생회</a></li>
			</ul>
		</div>
		<div class="info-main">
			<%@ include file="page/community-sidemenu.jsp" %>
			<div class="info-right">
				<h1 class="dept-content-title">학생회</h1>
				<p><strong>학생회</strong><br/>
				학생회
			</div>
		</div>
	</div>	
	<% }else if(sub.equals("free-board")) {%>
	<div class="deptinfo-main" id="community-society">
		<div class="contents-breadcrumb">
			<ul class="content-crumbs">
				<li><a href="index.jsp">Home</a></li>
				<li><a href="#">학생회</a></li>
			</ul>
		</div>
		<div class="info-main">
			<%@ include file="page/community-sidemenu.jsp" %>
			<div class="info-right">
				<h1 class="dept-content-title">학생회</h1>
				<p><strong>학생회</strong><br/>
				학생회
			</div>
		</div>
	</div>	
	<% } %>
	<%@ include file="page/footer.jsp" %>
</div>
</body>
<script>
</script>
</html>
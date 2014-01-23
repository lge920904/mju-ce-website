<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "kr.ac.mju.cs.bean.Professor" %>
<%@ page import= "kr.ac.mju.cs.bean.User" %>
<%@ page import= "java.util.ArrayList" %>
<%
	String[] profName = {"류연승", "박영배", "윤병주", "김상운", "주우석", "장혁수", "최성운", "홍석원", "전종훈", "이충기", "박현민", "조세형", "이강선", "이명호", "권동섭", "김상균", "한승철", "신민호", "김상귀"};
	ArrayList<Professor> profList = (ArrayList<Professor>)request.getAttribute("profList");
	User sessionUser = null;
	if((User)session.getAttribute("sessionUser") != null){
		sessionUser = (User)session.getAttribute("sessionUser");
	}
%>
<!DOCTYPE html>
<!--[if lt IE 7 ]><html dir="ltr" lang="en-US" class="no-js ie ie6 lte7 lte8 lte9"><![endif]-->
<!--[if IE 7 ]><html dir="ltr" lang="en-US" class="no-js ie ie7 lte7 lte8 lte9"><![endif]-->
<!--[if IE 8 ]><html dir="ltr" lang="en-US" class="no-js ie ie8 lte8 lte9"><![endif]-->
<!--[if IE 9 ]><html dir="ltr" lang="en-US" class="no-js ie ie9 lte9"><![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html>
<!--<![endif]-->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<link rel="stylesheet" type="text/css" href="css/info/default.css" />
	<link rel="stylesheet" type="text/css" href="css/info/component.css" />
	<link rel="stylesheet" type="text/css" href="css/info/contentsnav.css" />
	<link rel="stylesheet" type="text/css" href="css/default.css" />
<title>명지대학교 컴퓨터공학과::교수소개</title>
</head>
<body>
<div class="ct-container">
	<%@ include file="page/header.jsp" %>
	<div class="deptinfo-main">
		<nav class="contents-nav">
			<ul>
				<li><a href="index.jsp"><img src="resources/img/info/navhome.png"></a></li>
				<li><a href="deptinfo.jsp">학과소개</a></li>
				<li><a href="#">교수소개</a></li>
			</ul>
		</nav>
		<div class="info-main">
			<%@ include file="page/infosidemenu.jsp" %>
			<div class="info-right">
				<h1 class="content-title">교수 소개</h1>
				<%
				int i =1;
				for(String p : profName){ 
				%>
					<div class="prof-info">
						<img src="resources/img/prof/prof<%=i%>.png" />
						<ul class="info-contents">
							<li><a class="info-contents-header" href="profmoreinfo.jsp?email=<%=profList.get(i-1).getEmail()%>&profname=<%=profName[i-1]%>&imgnum=<%=i%>"><%=profName[i-1]%></a></li>
							<li><%=profList.get(i-1).getEngName()%></li>
							<li><%=profList.get(i-1).getPosition()%></li>
							<li><%=profList.get(i-1).getRoomPhone()%></li>
							<li><%=profList.get(i-1).getEmail()%></li>
							<%if(profList.get(i-1).getHomepage().equals("#")){ %>
								<li><a href="<%=profList.get(i-1).getHomepage()%>">Website</a></li>
							<%} else {%>
								<li><a href="http://<%=profList.get(i-1).getHomepage()%>" target="_blank">Website</a></li>
							<%}%>
						</ul>
					</div>
				<%
					i++;
				}
				%>
			</div>
		</div>
	</div>
	<%@ include file="page/footer.jsp" %>
</div>
</body>
</html>
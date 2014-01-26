<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import= "kr.ac.mju.cs.bean.Professor" %>
	<%@ page import= "kr.ac.mju.cs.bean.User" %>
	<%@ page import= "kr.ac.mju.cs.controller.ProfInfoController" %>
	<%@ page import= "java.util.ArrayList" %>
    <%
		String name = new String(request.getParameter("profname").getBytes("iso-8859-1"), "UTF-8");
    	String email = request.getParameter("email");
    	String imgfile = "prof"+request.getParameter("imgnum");
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
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
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
				<li><a href="profinfo.jsp">교수소개</a></li>
				<li><a href="#"><%=name %></a></li>
			</ul>
		</nav>
		<div class="info-main">
			<div class="info-right">
				<h1 class="content-title"><%=name %></h1>
				<%if(sessionUser != null){
					if(email.equals(sessionUser.getEmail())){
					%>
						<a href="#">
							<input type="button" class="btn-modify" value="정보수정">
						</a>
				<%	} 
				}%>
				<section class="prof-more-main">
					<article class="prof-more-contents">
						<h3>Cho Sehyeong</h3>
						<span>교수실 : 제5공학관 5607호</span>
						<span>전화 : 031-330-6779</span>
						<span>Comment : test</span>
					</article>
					<img alt="" src="resources/img/prof/<%=imgfile%>.png">
				</section>
				<section class="prof-more-main">
					<article class="prof-more-contents">
						<h3>관심 분야</h3>
						<span>자연어처리</span>
						<span>정보 검색 응용</span>
						<span>기초 프로그래밍 교육 방법론</span>
						<span>Ontology를 이용한 Automatic Semantic Annotation</span>
						<span>Automated Planning</span>
						<span>Ontology-aided Software Generation</span>
						<span>연구실 : Intelligent Interface(지능형인터페이스 제5공학관 5642호)</span>
					</article>
				</section>
				<section class="prof-more-main">
					<article class="prof-more-contents">
						<h3>경력</h3>
						<span>1983. 금성통신(현 LG정보통신) 연구원</span>
						<span>1984.3.~2002.2. 한국전자통신 연구원(ETRI) 개발실장</span>
						<span>2000.3. 명지대학교 조교수</span>
						<span>2004.3. 명지대학교 부교수</span>
						<span>2009.3. 명지대학교 교수</span>
					</article>
				</section>
				<section class="prof-more-main">
					<article class="prof-more-contents">
						<h3>학력</h3>
						<span>1981. 서울대학교 섬유공학과 학사</span>
						<span>1983. 서울대학교 계산통계학과 석사</span>
						<span>1992. Pennsylvania State University 박사</span>
					</article>
				</section>
				<section class="prof-more-main">
					<article class="prof-more-contents">
						<h3>최근 연구</h3>
						<span>2011.6. 명지대학교 컴퓨터공학 교육혁신</span>
						<span>2012.3. 명지대학교 컴퓨터공학 교육혁신</span>
						<span>2013.4. 명지대학교 컴퓨터공학 교육혁신</span>
						<span>2013.8. 워드넷 기반의 단어 중의성 해소 프레임워크</span>
						<span>2013.11. 워드넷 특징을 이용한 온톨로지 기반 개체명 인식 시스템</span>
					</article>
				</section>
			</div>
		</div>
	</div>
	<%@ include file="page/footer.jsp" %>
</div>
</body>
</html>
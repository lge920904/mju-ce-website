<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>명지대학교 컴퓨터공학과::공학인증</title>
</head>
<body>
<div class="ct-container">
	<%@ include file="page/header.jsp" %>
	<div class="deptinfo-main">
		<nav class="contents-nav">
			<ul>
				<li><a href="index.jsp"><img src="resources/img/info/navhome.png"></a></li>
				<li><a href="#">공학인증 도입목적 및 인증혜택</a></li>
			</ul>
		</nav>
		<div class="info-main">
			<%@ include file="page/infosidemenu.jsp" %>
			<div class="info-right">
				<h1 class="dept-content-title">개요</h1>
				<p><strong>인증이란?</strong><br/>
					<img src="resources/img/info/dept2.png">
					공학교육인증제는 국제 기준에 맞는 대학 공학교육 프로그램의 기준과 지침에 따라 대학의 학과별 교육목표 달성 여부와 
					졸업생의 학습 성과를 평가 인증하여, 국제적으로 인정받는 1급의 엔지니어를 양성함으로써 국가경쟁력을 확보하자는 취지이며, 
					인증된 프로그램으로 공부한 졸업생이 공학실무를 담당할 준비가 되어있음을 보증하는 제도입니다.		
				</p>
				<p><strong>공학교육 인증제도의 개요</strong><br/>
					한국공학교육인증원(ABEEK)에 의한 교육인증은 종전의 대학평가와는 달리 공과대학 개별적으로 실시되고, 
					강제성없이 자발적으로, 또, 희망대학에 대해서만 실시된다.
					 인증결과에 대한 공개가 없는 만큼, 우수 평가대학에 대한 포상도 열등 평가대학에 대한 제제도 없다. 
					 다만 공과대학 졸업생들의 고용주인 산업체들에 공학교육인증 참여대학의 목록과 인증관련 정보를 제공한다.
				</p>
				<p><img src="./resources/img/abeek-outline.png"></p>
			</div>
		</div>
	</div>
	<%@ include file="page/footer.jsp" %>
</div>
</body>
</html>
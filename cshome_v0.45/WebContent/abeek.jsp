<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% String sub = request.getParameter("sub"); %>
<!DOCTYPE html>
<html>
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
	<% if(sub.equals("outline")){ %>
	<div class="deptinfo-main">
		<nav class="contents-nav">
			<ul>
				<li><a href="index.jsp"><img src="resources/img/info/navhome.png"></a></li>
				<li><a href="#">개요</a></li>
			</ul>
		</nav>
		<div class="info-main">
			<%@ include file="page/abeek-sidemenu.jsp" %>
			<div class="info-right">
				<h1 class="dept-content-title">개요</h1>
				<p><strong>인증이란?</strong><br/>
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
				<p style="height:350px;">
					<img style="float:left; width:600px; height:300px" src="./resources/img/abeek-outline.png">
				</p>
				<h1 class="dept-content-title">인증절차</h1>
				<p style="height:350px;">
					<img style="float:left; width:600px; height:300px" src="./resources/img/abeek-process.png">
				</p>
			</div>
		</div>
	</div>
	<%} else if(sub.equals("benefit")){ %>
	<div class="deptinfo-main">
		<nav class="contents-nav">
			<ul>
				<li><a href="index.jsp"><img src="resources/img/info/navhome.png"></a></li>
				<li><a href="#">도입목적 및 인증헤택</a></li>
			</ul>
		</nav>
		<div class="info-main">
			<%@ include file="page/abeek-sidemenu.jsp" %>
			<div class="info-right">
				<h1 class="dept-content-title">도입목적</h1>
				<p><strong>인증목적</strong><br/>
					1. 인증된 프로그램의 졸업생은 공학실무를 담당할 준비가 되어있음을 보증<br/>
					2. 공학교육의 발전을 촉진<br/>
					3. 공학교육에 새롬고 창의적인 접근방법을 고취<br/>
					4. 인증된 프로그램을 사회에 공지<br/>
				</p>
				<p><strong>인증목표</strong><br/>
					대학의 공학 및 관련 교육을 위한 교육 프로그램 기준과 지침을 제시하고, 
					이를 통해 인증 및 자문을 시행함으로써 공학교육의 발전을 촉진하고 실력을 갖춘 공학기술 인력을 배출하는데 기여하기 위한 것으로,
				</p>
				<p style="height:350px;">
					<img style="float:left; width:600px; height:300px" src="./resources/img/abeek-target.png">
				</p>
				<h1 class="dept-content-title">인증혜택</h1>
				<p><strong>공과교육 인증 - 학생, 대학, 산업체, 국가의 경쟁력 향상</strong><br/>
					공학교육인증 평가에 따른 인증효과는 학생, 대학교, 산업체 나아가서는 국가에 이르기까지 
					커다란 공학기술의 경쟁력의 향상효과를 가져오게 된다. 그에 따른 효과는 아래와 같다.
				</p>
				<p style="height:350px;">
					<img style="float:left; width:600px; height:300px" src="./resources/img/abeek-benefit.png">
				</p>
			</div>
		</div>
	</div>
	<%} else if(sub.equals("standard")){ %>
	<div class="deptinfo-main">
		<nav class="contents-nav">
			<ul>
				<li><a href="index.jsp"><img src="resources/img/info/navhome.png"></a></li>
				<li><a href="#">인증기준</a></li>
			</ul>
		</nav>
		<div class="info-main">
			<%@ include file="page/abeek-sidemenu.jsp" %>
			<div class="info-right">
				<h1 class="dept-content-title">인증기준</h1>
				<p><strong>EAC 해당사항</strong><br/>
					<table border="1">
						<tr class="hori-tr">
							<td class="table-title">2010년도 인증평가에 적용</td>
							<td>
								<ul>
								<li><a href="#"> 공학인증기준2000(KEC2000)</a></li>
								<li><a href="#">공학인증기준2005(KEC2005)</a></li>
								<li><a href="#">공학인증기준 설명서2005(KEC2005)</a></li>
								</ul>
							</td>
						</tr>
						<tr class="hori-tr">
							<td class="table-title">2011년도 인증평가에 적용</td>
							<td>
								<ul>
								<li><a href="#"> 공학인증기준2000(KEC2000)</a></li>
								<li><a href="#">공학인증기준2005(KEC2005)</a></li>
								<li><a href="#">공학인증기준 설명서2005(KEC2005)</a></li>
								</ul>
							</td>
						</tr>
					</table>
				</p>
				<p><strong>CAC 해당사항</strong><br/>
					<table border="1">
						<tr class="hori-tr">
							<td class="table-title">2010년도 인증평가에 적용</td>
							<td>
								<ul>
								<li><a href="#">컴퓨터정보기술인증기준(CAC)</a></li>
								<li><a href="#"> 컴퓨터정보기술인증기준 설명서(CAC)</a></li>
								<li><a href="#">컴퓨터정보기술인증기준2005(KCC2005)</a></li>
								<li><a href="#">컴퓨터정보기술인증기준설명서(KCC2005)</a></li>
								</ul>
							</td>
						</tr>
						<tr class="hori-tr">
							<td class="table-title">2011년도 인증평가에 적용</td>
							<td>
								<ul>
								<li><a href="#"> 컴퓨터정보기술인증기준(CAC)</a></li>
								<li><a href="#"> 컴퓨터정보기술인증기준 설명서(CAC)</a></li>
								<li><a href="#">컴퓨터정보기술인증기준2005(KCC2005)</a></li>
								<li><a href="#">컴퓨터정보기술인증기준설명서(KCC2005)</a></li>
								<li><a href="#">컴퓨터정보기술인증기준설명서(KCC2010)</a></li>
								</ul>
							</td>
						</tr>
					</table>
				</p>
				<p><strong>TAC 해당사항</strong><br/>
					<table border="1">
						<tr class="hori-tr">
							<td class="table-title">2010년도 인증평가에 적용</td>
							<td>
								<ul>
								<li><a href="#"> 공학기술교육인증기준(KTC2009)</a></li>
								<li><a href="#">  공학기술교육인증기준설명서(KTC2009)</a></li>
								</ul>
							</td>
						</tr>
						<tr class="hori-tr">
							<td class="table-title">2011년도 인증평가에 적용</td>
							<td>
								<ul>
								<li><a href="#"> 공학기술교육인증기준(KTC2009)</a></li>
								<li><a href="#">  공학기술교육인증기준설명서(KTC2009)</a></li>
								</ul>
							</td>
						</tr>
					</table>
				</p>
			</div>
		</div>
	</div>
	<%} %>
	<%@ include file="page/footer.jsp" %>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <% String sub = request.getParameter("sub"); %>
  
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
<title>명지대학교 컴퓨터공학과::대학원소개</title>
</head>
<body>
<div class="ct-container">
	<%@ include file="page/header.jsp" %>
	<% if(sub.equals("outline")){ %>
	<div class="deptinfo-main">
		<div class="contents-breadcrumb">
			<ul class="content-crumbs">
				<li><a href="index.jsp">Home</a></li>
				<li><a href="#">대학원 소개</a></li>
			</ul>
		</div>
		<div class="info-main">
			<%@ include file="page/gradu-sidemenu.jsp" %>
			<div class="info-right">
				<h1 class="dept-content-title">대학원 소개</h1>
				<p><strong>대학원 소개</strong><br/>
					대학원 소개 
				</p>
			</div>
		</div>
	</div>
	<% }else if(sub.equals("laboratory")) { %>
	<div class="deptinfo-main">
		<div class="contents-breadcrumb">
			<ul class="content-crumbs">
				<li><a href="index.jsp">Home</a></li>
				<li><a href="#">대학원 소개</a></li>
				<lI><a href="#">연구실 소개</a></lI>
			</ul>
		</div>
		<div class="info-main">
			<%@ include file="page/gradu-sidemenu.jsp" %>
			<div class="info-right">
				<h1 class="dept-content-title">연구실 소개</h1>
				<p><strong>연구실 소개</strong><br/>
					연구실 소개 
				</p>
			</div>
		</div>
	</div>
	<% }else if(sub.equals("rule")){ %>
	<div class="deptinfo-main">
		<div class="contents-breadcrumb">
			<ul class="content-crumbs">
				<li><a href="index.jsp">Home</a></li>
				<li><a href="#">대학원 소개</a></li>
				<li><a href="#">학과내규</a></li>
			</ul>
		</div>
		<div class="info-main">
			<%@ include file="page/gradu-sidemenu.jsp" %>
			<div class="info-right">
				<h1 class="dept-content-title">학과내규</h1>
				<p><strong>입학시험</strong><br/>
					1. 석사과정 :  컴퓨터공학에 대한 전공구술<br/>
					2. 박사과정 :  컴퓨터공학에 대한 전공구술<br/>
				</p>
				<p><strong>이수과목</strong><br/>
				* 공통선택과목 <br/>
				없음<br/>
				* 이수학점<br/>
				1. 석사과정 : 전공선택 24학점<br/>
				2. 박사과정 : 전공선택 36학점<br/>
				</p>
				<p><strong>타계열전공소지자의 추가이수과목-석사</strong><br/>
					<span>(1) 석사과정 : 학사 혹은 석사 전공과목 중 12학점 이상 추가 이수</span><br/>
					<span style="color:#b72e3e">* 단 유사 전공 학위 소지자의 경우, 주임 교수의 재량으로 지도 교수와의 협의 하에 추가이수
과목의 학점을 감할 수 있다. 수강 교과목은 교과과정표 중에서 주임교수가 해당학생의 지도
교수와 협의하여 결정한다.(학부/대학원 교과과정표 참조)</span><br/>
				</p>
				<p><strong>타계열전공소지자의 추가이수과목-박사</strong><br/>
				 <span>(2) 박사과정 : 석사과정 전공과목 12학점 이상 이수</span><br/>
				<span style="color:#b72e3e"> * 단 유사 전공 학위 소지자의 경우, 주임 교수의 재량으로 지도 교수와의 협의 하에 추가이수
과목의 학점을 감할 수 있다. 수강 교과목은 교과과정표 중에서 주임교수가 해당학생의 지도
교수와 협의하여 결정한다.(학부/대학원 교과과정표 참조)</span><br/>
				 </p>
				 	<p><strong>타계열전공소지자의 추가이수과목</strong><br/>
				 	1. 석사과정 : 공통 영역, 2개 트랙 (소프트웨어 생산기술과 미디어 처리 및 통신기술) 의 교과목 중
                    2과목을 선택 <br/>
					2. 박사과정 : 공통 영역, 2개 트랙 (소프트웨어 생산기술과 미디어 처리 및 통신기술) 의 교과목 중
                    4과목을 선택 <br/>
					3. 각 전공에 대해서 당락을 결정하고, 떨어진 전공에 대해서만 재시험<br/> 
				 	</p>
				 	<p><strong>논문지도와 논문제출절차</strong><br/>
				 		1.	석사 : 외국어시험과 종합시험에 합격한 자로서, 관련 학술대회에 1편 이상의 논문을
           발표한 후에 학위청구논문을 제출하여 심사를 받는다. 단, 관련 학술 대회에
           발표하지 않은 청구논문에 대해서는, 지도교수의 제청과 심사위원 3명의 동의를
           득한 경우에만 심사를 하고, 합격한 경우에는 심사후에 반드시 관련 학술대회에
           발표를 하여야 한다.<br/><br/>
			2.	박사 : 외국어시험과 종합시험에 합격한 자로서, 학위청구논문과 관련한 5점 이상의
           논문 발표 실적을 획득한 후, 청구논문을 제출하여 심사를 받는다. <br/><br/>
           논문발표 실적의 점수 산정방법은 다음과 같다.<br/>
			①	외국학회지………3점<br/>
			②	외국학술대회……2점<br/>
			③	국내학회지………2점<br/>
			④	국내학술대회……1점<br/>
 		발표자 1인은 100%, 2인은 70%, 3인은 50%, 4인 이상은 30%로 계산한다. 단, 2인 이상의 공동 발표논문의 경우, 
 		지도교수는 제외하고 산정한다. 또 국내 학술 대회 논문은 2편까지만 인정한다.<br/>
				 	</p>
			</div>
		</div>
	</div>
	<% }else if(sub.equals("gradu-major")){ 
		 String[] code = {"컴공1701", "컴공1702", "컴공1704", "컴공1706", "컴공1711"};
	   	String[] name = {"프로그래밍 언어 특론 (Special topics in Programming Language)", "운영체제 특론 (Special topics in Operating System)", "고성능 컴퓨터 구조 (Advanced Computer Architecture)", "알고리즘 (Algorithm)", "데이터베이스 설계 특론 (Special Topics in Database Design)"};
	   	String[] outline = {"여러 가지 고급 프로그래밍 언어들의 설계 개념과 구현 기법, 그 특징들을 실존하는 프로그래밍 언어들을 가지고 예를 들어가며 설명한다. 또한 이런 기본 개념들을 컴퓨터에서 이용되는 자료, 이 자료들을 다루는데 필요한 연산, 순서제어, 자료제어, 기억장소 할당 등에 관해 연구한다.",	
	   		"운영체제의 형태와 구조에 관한 연구 : Concurrent Programming Semaphore를 이용한 동기화, Monitor, 메시지-전달, Deadlock 등의 기본 개념을 연구하고 간단한 O.S를 실제로 구현해 본다.",
	   		"고성능컴퓨터의 성능분석, 고성능 명령셋 아키텍춰의 설계 및 구현, 파이프라인 프로세서, 벡터 프로세서, 배열프로세서, 데이터흐름 프로세서 등의 고급이론을 강의한다.",
	   		"Advanced Data Structure를 기본으로 Numerical Algorithm, Geometical Algorithm, Graph Algorithm을 강의한다.",
	   		"데이터베이스의 전반적인 설계 이론, 특히 관계형 데이터베이스의 설계에 관련된 이론 및 그에 따른 정규화, 함수 종속 등의 각종 기법들에 대해 강의한다."};	
	%>
	<div class="deptinfo-main">
		<div class="contents-breadcrumb">
			<ul class="content-crumbs">
				<li><a href="index.jsp">Home</a></li>
				<li><a href="#">대학원 소개</a></li>
				<li><a href="#">교과과목</a></li>
			</ul>
		</div>
		<div class="info-main">
			<%@ include file="page/gradu-sidemenu.jsp" %>
			<div class="info-right">
				<h1 class="dept-content-title">교과과목</h1>
				<p><strong>컴퓨터공학과 대학원 교과과목</strong><br/>
					<table>
						<tr class="verti-tr">
<!-- 							<td class="table-title">교과코드</td> -->
							<td class="table-title">교과목명</td>
							<td class="table-title">과목개요</td>
						</tr>
						<% for(int i=0; i<code.length; i++){ %>
						<tr>
<%-- 							<td><%= code[i] %></td> --%>
							<td><%= name[i] %></td>
							<td class="td-last"><%= outline[i] %></td>
						</tr>
						<% } %>
					</table>
				</p>
			</div>
		</div>
	</div>
	<% } %>
	<%@ include file="page/footer.jsp" %>
</div>
</body>
</html>
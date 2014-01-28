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
	<script type="text/javascript" src="http://maps.google.com/maps/api/js?key=AIzaSyCd-0g6kwobSCLrmksTerMiBmWcA4Qbbcw&sensor=true"></script>
	<script>
		function initialize(){
			var mjuLating = new google.maps.LatLng(37.221999, 127.187690);
			var mjuOptions = {
				zoom: 17,
				center: mjuLating,
				mapTypeId: google.maps.MapTypeId.ROADMAP
			}
			var map = new google.maps.Map(document.getElementById("map_canvas"), mjuOptions);
			var marker = new google.maps.Marker({
				position: mjuLating,
				map: map,
				title: "컴퓨터공학과"
			});
		}
		window.onload=function(){
			initialize();
		}
	</script>
<title>명지대학교 컴퓨터공학과::학과소개</title>
</head>
<body>
<div class="ct-container">
	<%@ include file="page/header.jsp" %>
	<% if(sub.equals("outline")){ %>
	<div class="deptinfo-main">
		<div class="contents-breadcrumb">
			<ul class="content-crumbs">
				<li><a href="index.jsp">Home</a></li>
				<li><a href="#">학과소개</a></li>
			</ul>
		</div>
		<div class="info-main">
			<%@ include file="page/dept-sidemenu.jsp" %>
			   <div class="info-right">
            <h1 class="dept-content-title">학과 소개</h1>
            <section class="dept-intro-content">
               <p class="dept-content-text">
                  <img src="resources/img/info/dept2.png">
                  컴퓨터가 널리 보급됨에 따라 생산성 향상과 경영 합리화를 위하여 국가 공공기관, 연구소, 기업체 대학은 물론이고 각 가정에까지 컴퓨터의 활용이 확산되어 있다.
                  또한 인터넷을 축으로 한 컴퓨터 통신은 다양한 장비위에서 멀티미디어 기술과 결합되어 우리 생활에 엄청난 변화를 가져오고 있다.
                  이러한 변화에 중추적 역할을 담당할 전문인을 양성하기 위해, 컴퓨터공학과는 컴퓨터 공학 및 과학의 핵심이론 과목과 심도있는 프로그래밍 실습을 중심으로 교육과정을 운영하고 있어 폭넓은 전문지식을 바탕으로 산업현장에서 바로 활용할 수 있는 인재를 양성하고 있다.      
               </p>
               <p class="dept-content-text">
                  컴퓨터공학과는 1979년 학과 개설 후, 2008년까지 배출된 약 2500 여명의 졸업생이 국내외 굴지의 학계, 연구소, 회사, 국영기업체 및 정부기관에서 소프트웨어개발과 컴퓨터공학 기술 발전에 크게 공헌하고 있다.
                  컴퓨터공학과에서는 2007년~2011년까지 정보통신부로부터 Next 사업 지원을 받아 실습환경이 획기적으로 개선되었다. 그 후 2011년부터 서울어코드사업에 선정되어 지금까지 지원 중에 있다.
                   이를 이용하여 컴퓨터공학과는 Oracle사와 협동으로 OCJP와 OCP 자격증 취득 프로그램, OPIc 및 TOEIC 교육, 기초 전공 특강 등 방학을 이용하여 학생들에게 많은 교육 프로그램을 운영중이다.
                  또한 일본 IT 맞춤 취업 과정을 통해 졸업생들의 해외 취업을 돕고 있다.
                  특히 국내 산업체 및 연구소와의 협력을  통한 캡스톤 프로젝트, 진로설계프로젝트 및 인턴쉽을 수행하여 실질적인 전문 기술의 습득과 함께 자신의 진로를 탐색할 수 있도록 하고 있다. 
               </p>
            </section>
            <section class="dept-intro-content intro-last">
               <h1 class="dept-content-title">학과 연혁</h1>
               <ul class="dept-info-contents">
                  <li>1979.10. 전자계산학과 신설</li>
                  <li>1980.03. 전자계산학과 신입생모집 (정원 40명)</li>
                  <li>1984.02. 입학인원 증원 (156명)</li>
                  <li>1984.02. 제1회 졸업생 배출 (18명)</li>
                  <li>1984.03. 대학원 석사과정 신설</li>
                  <li>1985.03. 대학원 석사과정 신입생 모집 (5명)</li>
                  <li>1986.03. 입학인원 조정 (입학인원 104명)</li>
                  <li>1987.02. 대학원 석사과정 제1회 졸업생 배출 (5명)</li>
                  <li>1988.03. 입학인원 조정 (입학인원 100명)</li>
                  <li>1989.01. 연구실 확충 및 슈퍼 마이크로컴퓨터 도입</li>
                  <li>1990.11. 대학원 박사과정 신설</li>
                  <li>1991.03. 대학원 박사과정 신입생 모집 (3명)</li>
                  <li>1992.11. 연구실 확충 및 워크스테이션 도입</li>
                  <li>1993.03. 전자계산학과를 컴퓨터공학과로 학과 명칭 변경</li>
                  <li>1998.02. 제15회 졸업생 배출</li>
                  <li>1999.03. 컴퓨터공학과를 컴퓨터학부(컴퓨터과학 전공, 컴퓨터공학 전공)로 확대 개편</li>
                  <li>2002.03. 한국대학교육협의회 평가 최우수학과 및 대학원 인증</li>
                  <li>2002.03. 컴퓨터학부를 컴퓨터공학과로 통합 변경</li>
                  <li>2006.03. 컴퓨터공학 인증프로그램인 컴퓨터공학심화 프로그램과 일반프로그램인 컴퓨터공학 프로그램 신설</li>
                  <li>2010.03. 컴퓨터소프트웨어학과와 통합</li>
                  <li>2011.06. 지식경제부 서울어코드 활성화사업 지원 학과로 선정</li>
               </ul>
            </section>
         </div>
		</div>
	</div>
	<% }else if(sub.equals("professor")){ %>
	<%@ page import= "kr.ac.mju.cs.bean.Professor" %>
	<%@ page import= "kr.ac.mju.cs.bean.User" %>
	<%@ page import= "kr.ac.mju.cs.controller.ProfInfoController" %>
	<%@ page import= "java.util.ArrayList" %>
	<%
			String[] profName = {"류연승", "박영배", "윤병주", "김상운", "주우석", "장혁수", "최성운", "홍석원", "전종훈", "이충기", "박현민", "조세형", "이강선", "이명호", "권동섭", "김상균", "한승철", "신민호", "김상귀"};
			ProfInfoController profInfo = new ProfInfoController();
			ArrayList<Professor> profList = profInfo.selecProfInfo();
			User sessionUser = null;
			if((User)session.getAttribute("sessionUser") != null){
				sessionUser = (User)session.getAttribute("sessionUser");
		}
	%>
	<div class="deptinfo-main">
		<div class="contents-breadcrumb">
			<ul class="content-crumbs">
				<li><a href="index.jsp">Home</a></li>
				<li><a href="deptinfo.jsp?sub=outline">학과소개</a></li>
				<li><a href="#">교수소개</a></li>
			</ul>
		</div>
		<div class="info-main">
			<%@ include file="page/dept-sidemenu.jsp" %>
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
							<li class="prof-info-contents1"><%=profList.get(i-1).getEngName()%></li>
							<li class="prof-info-contents1"><%=profList.get(i-1).getPosition()%></li>
							<li class="prof-info-contents1"><%=profList.get(i-1).getRoomPhone()%></li>							
						</ul>
						<ul class="info-contents right">
							<li><a href="<%=profList.get(i-1).getHomepage()%>" target="_blank">Website</a></li>
							<li class="prof-info-contents2"><%=profList.get(i-1).getEmail()%></li>
							<li class="prof-info-contents2"><%=profList.get(i-1).getComment()%></li>
						</ul>
					</div>
				<%
					i++;
				}
				%>
			</div>
		</div>
	</div>
	<% }else if(sub.equals("education")){ %>
	<div class="deptinfo-main">
		<div class="contents-breadcrumb">
			<ul class="content-crumbs">
				<li><a href="index.jsp">Home</a></li>
				<li><a href="deptinfo.jsp?sub=outline">학과소개</a></li>
				<li><a href="#">교육목표</a></li>
			</ul>
		</div>
		<div class="info-main">
			<%@ include file="page/dept-sidemenu.jsp" %>
			<div class="info-right">
				<section class="edu-info-content">
					<h1 class="content-title">교육 목적</h1>
						<span>유능하고 창의적이며 직업정신을 갖춘 국제적 컴퓨터 엔지니어를 양성하는데 있다.</span>
				</section>
				<section class="edu-info-content">
					<h1 class="content-title">교육 목표 1 : 전공기초</h1>
						<span>수학, 기초과학 및 컴퓨터 공학의 기본원리를 이해하고 응용할 수 있는 능력을 갖추도록 한다.</span>
						<ul class="edu-info-list">
							<li>기초활용 : 수학, 기초과학 등을 업무와 관련한 문제에 활용할 수 있는 능력</li>
							<li>문제해결 : C, C++, C#, Java 등을 사용하여 주어진 문제를 해결할 수 있는 능력</li>
						</ul>
				</section>
				<section class="edu-info-content">
					<h1 class="content-title">교육 목표 2 : 전공실무</h1>
						<span>실세계의 컴퓨터공학 문제들을 분석, 설계, 구현하고 이를 관리 운영하는 능력을 갖도록 한다</span>
						<ul class="edu-info-list">
							<li>분석설계 : DBMS, UML, IDE 또는 기타 최신의 도구들을 사용하여 컴퓨터공학 문제를 분석/설계하는 능력</li>
							<li>실무능력 : 설계된 컴퓨터 시스템을 Visual Studio .NET, MATLAB 또는 기타 최신의 도구를 사용하여 정확하게 구현하고, 테스트하고, 운영 중 발생하는 문제를 해결하는 능력</li>
						</ul>
				</section>
				<section class="edu-info-content">
					<h1 class="content-title">교육 목표 3 : 직업정신</h1>
						<span>원활한 의사소통, 협동 능력 및 리더쉽을 기반으로, 컴퓨터기술이 사회, 경제, 윤리에 미치는 영향력에 대한 이해와 새로운 기술에 대한 지속적 탐구 정신을 통해 컴퓨터 엔지니어로서의 직업정신을 갖도록 한다.</span>
						<ul class="edu-info-list">
							<li>화합능력 : 구성원들 간에 원활한 의사소통을 통하여 협동적으로 업무를 처리하는 능력</li>
							<li>산업이해 : XML, Sensor Network 또는 기타 최신의 컴퓨터기술의 발전이 기업과 산업에 미치는 영향력에 대한 충분한 이해</li>
						</ul>
				</section>
				<section class="edu-info-content last">
					<h1 class="content-title">교육 목표 4 : 국제경쟁력</h1>
						<span>외국어 능력, 세계 문화 이해 및 컴퓨터공학 국제 표준 이해를 통해 국제적 경쟁력을 갖도록 한다.</span>
						<ul class="edu-info-list">
							<li>국제소통 : 영어 등의 외국어를 사용하여 외국인과 업무를 처리할 수 있는 능력</li>
							<li>국제역량 : 영어 등의 외국어로 된 컴퓨터 분야의 신기술 관련 서류 및 표준안 등을 이해할 수 있는 능력</li>
						</ul>
				</section>
			</div>
		</div>
	</div>
	<% }else if(sub.equals("educationloadmap")) { %>
	<div class="deptinfo-main">
		<div class="contents-breadcrumb">
			<ul class="content-crumbs">
				<li><a href="index.jsp">Home</a></li>
				<li><a href="deptinfo.jsp?sub=outline">학과소개</a></li>
				<lI><a href="#">교과과정로드맵</a></lI>
			</ul>
		</div>
		<div class="info-main">
			<%@ include file="page/dept-sidemenu.jsp" %>
			<div class="info-right">
				<h1 class="dept-content-title">교과과정로드맵</h1>
				<p><strong>교과과정로드맵</strong><br/>
					교과과정로드맵
				</p>
			</div>
		</div>
	</div>
	<% }else if(sub.equals("dept-event")) { %>
	<div class="deptinfo-main">
		<div class="contents-breadcrumb">
			<ul class="content-crumbs">
				<li><a href="index.jsp">Home</a></li>
				<li><a href="deptinfo.jsp?sub=outline">학과소개</a></li>
				<lI><a href="#">학과행사</a></lI>
			</ul>
		</div>
		<div class="info-main">
			<%@ include file="page/dept-sidemenu.jsp" %>
			<div class="info-right">
				<h1 class="dept-content-title">학과행사</h1>
				<p><strong>학과행사</strong><br/>
					학과행사
				</p>
			</div>
		</div>
	</div>
	<% }else if(sub.equals("admissions")) { %>
	<div class="deptinfo-main">
		<div class="contents-breadcrumb">
			<ul class="content-crumbs">
				<li><a href="index.jsp">Home</a></li>
				<li><a href="deptinfo.jsp?sub=outline">학과소개</a></li>
				<lI><a href="#">입학안내</a></lI>
			</ul>
		</div>
		<div class="info-main">
			<%@ include file="page/dept-sidemenu.jsp" %>
			<div class="info-right">
				<h1 class="dept-content-title">입학안내</h1>
				<p><strong>입학안내</strong><br/>
					입학안내
				</p>
			</div>
		</div>
	</div>
	<% }else if(sub.equals("scholarships")) { %>
	<div class="deptinfo-main">
		<div class="contents-breadcrumb">
			<ul class="content-crumbs">
				<li><a href="index.jsp">Home</a></li>
				<li><a href="deptinfo.jsp?sub=outline">학과소개</a></li>
				<lI><a href="#">장학제도</a></lI>
			</ul>
		</div>
		<div class="info-main">
			<%@ include file="page/dept-sidemenu.jsp" %>
			<div class="info-right">
				<h1 class="dept-content-title">장학제도</h1>
				<p><strong>장학제도</strong><br/>
					장학제도
				</p>
			</div>
		</div>
	</div>
	<% }else if(sub.equals("location")){ %>
	<div class="deptinfo-main">
		<div class="contents-breadcrumb">
			<ul class="content-crumbs">
				<li><a href="index.jsp">Home</a></li>
				<li><a href="deptinfo.jsp?sub=outline">학과소개</a></li>
				<li><a href="#">찾아오시는 길</a></li>
			</ul>
		</div>
		<div class="info-main">
			<%@ include file="page/dept-sidemenu.jsp" %>
			<div class="info-right">
				<h1 class="content-title">찾아오시는 길</h1>
<!-- 				<img class="location-img" src="resources/img/info/waymap/img_trap1.png"></br> -->
				<div id="map_canvas"></div>
				<ul class="location-info">
					<li>주소 : 경기도 용인시 처인구 명지로 116</li>
					<li>학과사무실 : 제5공학관 5351호</li>
					<li>교수실 및 연구실 : 제5공학관 6,7층</li>
					<li>강의실 : 제5공학관 4층</li>
				</ul>
				<h1 class="content-title">길안내(주요거점)</h1>
				<img class="location-img" src="resources/img/info/waymap/way_map1_01.png">
				<img class="location-img" src="resources/img/info/waymap/way_map1_02.png">
				<img class="location-img" src="resources/img/info/waymap/way_map1_03.png">
				<img class="location-img" src="resources/img/info/waymap/way_map1_04.png">
				<img class="location-img" src="resources/img/info/waymap/way_map1_05.png">
				<img class="location-img" src="resources/img/info/waymap/way_map1_06.png">
			</div>
		</div>
	</div>
	<% } %> 
	<%@ include file="page/footer.jsp" %>
</div>
</body>
</html>
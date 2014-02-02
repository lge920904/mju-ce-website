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
<title>명지대학교 컴퓨터공학과::공지사항</title>
</head>
<body>
<div class="ct-container">
	<%@ include file="page/header.jsp" %>
	<% if(sub.equals("notice")){ %>
	<div class="deptinfo-main">
		<div class="contents-breadcrumb">
			<ul class="content-crumbs">
				<li><a href="index.jsp">Home</a></li>
				<li><a href="#">공지사항</a></li>
			</ul>
		</div>
		<div class="info-main">
			<%@ include file="page/notice-sidemenu.jsp" %>
			<div class="info-right">
				<h1 class="dept-content-title">공지사항</h1>
				<p><strong>공지사항</strong><br/>
				공지사항
			</div>
		</div>
	</div>
	<% } else if(sub.equals("dept-schedule")){%>
	<div class="deptinfo-main">
		<div class="contents-breadcrumb">
			<ul class="content-crumbs">
				<li><a href="index.jsp">Home</a></li>
				<li><a href="#">공지사항</a></li>
				<li><a href="#">학과 일정</a></li>
			</ul>
		</div>
		<div class="info-main">
			<%@ include file="page/notice-sidemenu.jsp" %>
			<div class="info-right">
				<h1 class="dept-content-title">학과 일정</h1>
				<nav class="cbp-spmenu cbp-spmenu-horizontal cbp-spmenu-top">
				<a href="#">컴퓨터공학과 일정</a> <a href="#">명지대학교 학사 일정</a> <a href="#">학술대회
					일정</a> <a href="#">학생회 일정</a>
				</nav>
				<div class="cbp_calender">
						<p>2014년 3월</p>
							<table class="bordered">
								<thead>
									<tr>
										<th style="text-align: center">Sun</th>
										<th style="text-align: center">Mon</th>
										<th style="text-align: center">Tue</th>
										<th style="text-align: center">Wen</th>
										<th style="text-align: center">Thu</th>
										<th style="text-align: center">Fri</th>
										<th style="text-align: center">Sat</th>
									</tr>
								</thead>

								<tr>
									<td style="text-align: center">1</td>
									<td>2</td>
									<td style="text-align: center">3</td>
									<td style="text-align: center">4</td>
									<td>5</td>
									<td>6</td>
									<td>7</td>
								</tr>
								<tr>
									<td style="text-align: center">8</td>
									<td>9</td>
									<td style="text-align: center">10</td>
									<td style="text-align: center">11</td>
									<td>12</td>
									<td>13</td>
									<td>14</td>
								</tr>
								<tr>
									<td style="text-align: center">15</td>
									<td>16</td>
									<td style="text-align: center">17</td>
									<td style="text-align: center">18</td>
									<td>19</td>
									<td>20</td>
									<td>21</td>
								</tr>
								<tr>
									<td style="text-align: center">22</td>
									<td>23</td>
									<td style="text-align: center">24</td>
									<td style="text-align: center">25</td>
									<td>26</td>
									<td>27</td>
									<td>28</td>
								</tr>
								<tr>
									<td style="text-align: center">29</td>
									<td>30</td>
									<td style="text-align: center">31</td>
									<td style="text-align: center">1</td>
									<td>2</td>
									<td>3</td>
									<td>4</td>
								</tr>
							</table>
						</div>
						<div class="cbp_summary"></div>
						<div class="cbp_tmlabel">
							<h2>[컴퓨터공학과] 수강신청변경</h2>
							<p>기간 : 2014-3-15(월) ~ 2014-3-27(수)</p>
							<p>장소 : Myiweb</p>
							<p>기타 : 변경가능 기간</p>
						</div>
			</div>
		</div>
	</div>
	<% } else if(sub.equals("recruit")) { %>
	<div class="deptinfo-main">
		<div class="contents-breadcrumb">
			<ul class="content-crumbs">
				<li><a href="index.jsp">Home</a></li>
				<li><a href="#">공지사항</a></li>
				<li><a href="#">구인/취업</a></li>
			</ul>
		</div>
		<div class="info-main">
			<%@ include file="page/notice-sidemenu.jsp" %>
			<div class="info-right">
				<h1 class="dept-content-title">구인/취업</h1>
				<p><strong>구인/취업</strong><br/>
			</div>
		</div>
	</div>
	<% } else if(sub.equals("subscription")) { %>
	<div class="deptinfo-main">
		<div class="contents-breadcrumb">
			<ul class="content-crumbs">
				<li><a href="index.jsp">Home</a></li>
				<li><a href="#">공지사항</a></li>
				<li><a href="#">증원신청</a></li>
			</ul>
		</div>
		<div class="info-main">
			<%@ include file="page/notice-sidemenu.jsp" %>
			<div class="info-right">
				<h1 class="dept-content-title">증원신청</h1>
				<p><strong>증원신청</strong><br/>
			</div>
		</div>
	</div>
	<% } else if(sub.equals("servay")) {%>
	<div class="deptinfo-main">
		<div class="contents-breadcrumb">
			<ul class="content-crumbs">
				<li><a href="index.jsp">Home</a></li>
				<li><a href="#">공지사항</a></li>
				<li><a href="#">설문조사</a></li>
			</ul>
		</div>
		<div class="info-main">
			<%@ include file="page/notice-sidemenu.jsp" %>
			<div class="info-right">
				<h1 class="dept-content-title">설문조사</h1>
				<p><strong>설문조사</strong><br/>
			</div>
		</div>
	</div>
	<% } else if(sub.equals("equipment")) {%>
	<div class="deptinfo-main">
		<div class="contents-breadcrumb">
			<ul class="content-crumbs">
				<li><a href="index.jsp">Home</a></li>
				<li><a href="#">공지사항</a></li>
				<li><a href="#">장비 및 시설 신청</a></li>
			</ul>
		</div>
		<div class="info-main">
			<%@ include file="page/notice-sidemenu.jsp" %>
			<div class="info-right">
				<h1 class="dept-content-title">장비 및 시설 대여 신청</h1>
				<p><strong>장비 및 시설 신청</strong><br/>
			</div>
		</div>
	</div>
	<% } else if(sub.equals("lectureroom")) {%>
	<div class="deptinfo-main">
		<div class="contents-breadcrumb">
			<ul class="content-crumbs">
				<li><a href="index.jsp">Home</a></li>
				<li><a href="#">공지사항</a></li>
				<li><a href="#">실습실 현황</a></li>
			</ul>
		</div>
		<div class="info-main">
			<%@ include file="page/notice-sidemenu.jsp" %>
			<div class="info-right">
				<h1 class="dept-content-title">실습실 현황</h1>
				<p><strong>실습실 현황</strong><br/>
			</div>
		</div>
	</div>
	<% } else if(sub.equals("recent-it")){ %>
	<div class="deptinfo-main">
		<div class="contents-breadcrumb">
			<ul class="content-crumbs">
				<li><a href="index.jsp">Home</a></li>
				<li><a href="#">공지사항</a></li>
				<li><a href="#">최신 IT 뉴스</a></li>
			</ul>
		</div>
		<div class="info-main">
			<%@ include file="page/notice-sidemenu.jsp" %>
			<div class="info-right">
				<h1 class="dept-content-title">최신 IT뉴스</h1>
				<p><strong>최신 IT뉴스</strong><br/>
			</div>
		</div>
	</div>
	<% } %>
	<%@ include file="page/footer.jsp" %>
</div>
</body>
</html>
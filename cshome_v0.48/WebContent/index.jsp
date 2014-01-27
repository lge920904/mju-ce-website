<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="kr.ac.mju.cs.bean.User"%>

<!DOCTYPE html>
<html dir="ltr" lang="en-US">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>명지대학교 컴퓨터공학과</title>
<link rel="stylesheet" type="text/css" media="print" href="css/user.css" />
<link rel="stylesheet" type="text/css" href="css/default.css" />

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type='text/javascript' src='js/userscripts.js?ver=3.7.1'></script>
<script type='text/javascript' src='js/jquery.js?ver=1.10.2'></script>
<script type='text/javascript' src='js/jquery-migrate.min.js?ver=1.2.1'></script>
<script type="text/javascript" src="js/modernizr.custom.70736.js"></script>

<!--[if lt IE 9 ]>
			<script type="text/javascript" src="http://codropspz.tympanus.netdna-cdn.com/codrops/wp-content/themes/codropstheme02/js/css3-mediaqueries.js"></script>
			<link rel="stylesheet" href="http://codropspz.tympanus.netdna-cdn.com/codrops/wp-content/themes/codropstheme02/css/ie.css"/>
		<![endif]-->
<!--[if lt IE 8 ]>
			<script type="text/javascript" src="http://codropspz.tympanus.netdna-cdn.com/codrops/wp-content/themes/codropstheme02/js/iconfonts.js"></script>
		<![endif]-->
</head>
<body>
	<div class="ct-container">
		<%@ include file="page/header.jsp" %>
		<div class="ct-content ct-index">
			<div class="ct-inner">
				<div class="ct-main">
					<!-- begin featured -->
					<section class="ct-featured">
						<article>
							<div class="ct-feat-right">
								<div class="ct-feat-inner">
<!-- 									<embed width="765" height="460" -->
<!-- 										src="//www.youtube.com/embed/BDQqxCKT_vA?autohide=1;autoplay=1&loop=0;showinfo=0" -->
<!-- 										frameborder="0" allowfullscreen /> -->
									<video autoplay preload>
										<source src="resources/video/mju_advertisement_video.mp4" type="video/mp4"></source>
										이 인터넷 환경에서는 HTML5 video 형식을 지원하지 않습니다.
									</video>
								</div>
							</div>
							<div class="clr"></div>
						</article>
						<!-- end featured -->
					</section>
					<div class="clr"></div>
					<div class="ct-main-left">
						<section class="ct-latest-any ct-latest-blueprint">
							<div class="ct-latest-any-wrap">
								<h2>학사 - 공학 인증 &amp; 기초 전공</h2>
								<article>
									<div class="ct-latest-thumb">
										<a href="#" class="ct-trans"> <img src="./resources/img/engineering-authority-educationcenter.png" width="105" height="105" />
										</a>
									</div>
									<h3>
										<a href="#">공학인증 도입목적 및 인증혜택</a>
									</h3>
									<div class="clr"></div>
								</article>
								<article>
									<div class="ct-latest-thumb">
										<a href="#" class="ct-trans"> <img src="./resources/img/engineering-authority-road-map.png" width="105" height="105" />
										</a>
									</div>
	
									<h3>
										<a href="#">공학인증 로드맵</a>
									</h3>
									<div class="clr"></div>
								</article>
							</div>
							<footer class="ct-latest-any-bottom">
								<a href="engineering-auth.jsp">전체보기</a>
							</footer>
						</section>	
						<!-- Latest Collective Posts -->
						<section class="ct-latest-any ct-coll-archive">
							<div class="ct-latest-any-wrap">
								<h2>대학원 - 연구 분야 &amp; 심화 전공</h2>
								<article>
									<div class="ct-latest-thumb">
										<a href="#" class="ct-trans"> <img width="75" height="105"
											src="./resources/img/nlp.png" class="attachment-thumbnail wp-post-image"
											alt="Collective98" />
										</a>
									</div>
									<h3>
										<a href="#" class="">NLP</a>
									</h3>
									<p class="ct-feat-excerpt">
										인간이 발화하는 언어 현상을 기계적으로 분석해서 컴퓨터가 이해할 수 있는 형태로 만드는 자연 언어 이해 혹은 그러한 형태를 다시 인간이 이해할 수 있는 언어로 표현...
										<span>
											<a href="#">더보기</a>
										</span>
									</p>
									<div class="clr"></div>
								</article>
								<article>
									<div class="ct-latest-thumb">
										<a href="#" class="ct-trans"> <img width="75" height="105"
											src="./resources/img/ai.png" class="attachment-thumbnail wp-post-image"
											alt="Collective 97" />
										</a>
									</div>
									<h3>
										<a href="#" class="">A.I</a>
									</h3>
									<p class="ct-feat-excerpt">
										철학적으로 인간이나 지성을 갖춘 존재, 혹은 시스템에 의해 만들어진 지능, 즉 인공적인 지능을 뜻한다. 일반적으로 범용 컴퓨터에 적용한다고 가정한다....
										<span>
											<a href="#">더보기</a>
										</span>
									</p>
									<div class="clr"></div>
								</article>
								<footer class="ct-latest-any-bottom">
									<a href="/codrops/collective">전체보기</a>
								</footer>
							</div>
						</section>
					</div>
					<div class="ct-main-right">
						<!-- begin latest list -->
						<section class="ct-latest">
							<h2>최신글</h2>
								<article>
									<header>
										<p class="ct-subline">
											<time pubdate="pubdate">2014-01-08</time>
											<a href="#">[서울어코드] 2014년 동계 블랜디드 TOEIC...</a>
										</p>
									</header>
								</article>
								<article>
									<header>
										<p class="ct-subline">
											<time pubdate="pubdate">2014-01-08</time>
											<a href="#">[서울어코드] 오라클 자격증 교육과정 시간 및...</a>
										</p>
									</header>
								</article>
								<article>
									<header>
										<p class="ct-subline">
											<time pubdate="pubdate">2014-01-06</time>
											<a href="#">[학사] 2014학년도 전기 재입학 일정 통보</a>
										</p>
									</header>
								</article>
								<article>
									<header>
										<p class="ct-subline">
											<time pubdate="pubdate">2014-01-03</time>
											<a href="#">[서울어코드] 오라클 자격증 교육과정 수강생...</a>
										</p>
									</header>
								</article>
								<article>
									<header>
										<p class="ct-subline">
											<time pubdate="pubdate">2013-12-26</time>
											<a href="#">[학과] MBC 방송 프로그램 IT매거진" 내일 ON" 방영...</a>
										</p>
									</header>
								</article>
								<article>
									<header>
										<p class="ct-subline">
											<time pubdate="pubdate">2013-12-24</time>
											<a href="#">[서울어코드] 2014년 동계 오라클 OCJP취득 교...</a>
										</p>
					 				</header> 
								</article>
						</section>
						<section class="ct-latest">
							<h2>최근사진</h2>
							<article>
								<header>
									<a href="#"><img alt="" src="resources/img/main-thum01.png"></a>
									<a href="#"><img alt="" src="resources/img/main-thum02.png"></a>
									<a><img alt="" src="resources/img/main-thum03.png"></a>
									<a><img alt="" src="resources/img/main-thum04.png"></a>
								</header>
							</article>
							<article class="ct-latest-thumimg">
								<header>
									<a><img alt="" src="resources/img/main-thum05.png"></a>
									<a><img alt="" src="resources/img/main-thum06.png"></a>
									<a><img alt="" src="resources/img/main-thum07.png"></a>
									<a><img alt="" src="resources/img/main-thum08.png"></a>
								</header>
							</article>
							<!-- end latest list -->
							<footer class="ct-latest-bottom">
								<a href="#">전체보기</a>
							</footer>
						</section>
					</div>
					<!-- // Latest Collective Posts -->
				</div>
				<aside class="ct-sidebar">
					<div class="ct-ads">
						<div class="ct-ads-info" style="margin-top: 10px;">
						<% 
							User user = (User)session.getAttribute("sessionUser");
							String loginError = (String)session.getAttribute("loginError");
							if(user == null ){ %>
								<% if(loginError != null){%>
									<script>
										$(function(){
											alert("<%= loginError %>");
										});
									</script>
								<% } %>
							<form class="login" id="login-form" action="UserInfoServlet?action=login" method="post" autocomplete="off">
								<input type="hidden" name="requestUrl" value="<%= request.getRequestURI() %>">
								<input type="text" name="user-id" placeholder="Email or ID"
									style="width: 275px; margin: 0"> 
								<input type="text" name="user-password"
									placeholder="password" style="width: 185px; margin: 0">
								<input class="buttonbig" name="btn-user-login" type="button"  value="로그인">
							</form>
							<script>
							$(function(){
								$('input[name=btn-user-login]').click(function(){
									if($('input[name=user-id]').val().length < 4 ||
										$('input[name=user-password]').val().length < 4){
										alert("아이디와 비밀번호를 모두 입력하세요.");
									}else{
										$('#login-form').submit();
									}
								});
							});
							</script>
							<p class="ct-subline-login">
								<a href="join.intro.jsp">회원가입 | </a><a href="findmenu.jsp">비밀번호 찾기</a>
							</p>
						<% } else {%>
							<p>
								<%= user.getName() %>님 반갑습니다.
							</p>
							<p class="ct-subline-login">
								<a href="modify.do.jsp">정보수정 | </a><a href="logout.jsp?requestUrl=<%=request.getRequestURI()%>">로그아웃</a>
						<% } %>
						</div>
						<div class="clr"></div>
					</div>
					<div class="ct-widget-wrapper">
						<div class="ct-widget ct-widget-default">
							<h5>학과 일정</h5>
							<article>
								<div class="ct-latest-thumb">
									<a href="schedule.jsp" class="ct-trans"> <img src="resources/img/department-notice.png" width="105" height="105" /></a>
								</div>
								<h3>
									<a href="schedule.jsp" class="">2014학년도 1학기 수강신청 변경</a>
								</h3>

								<div class="clr"></div>
							</article>
							<article>
								<div class="ct-latest-thumb">
									<a href="schedule.jsp" class="ct-trans"> <img src="resources/img/society-notice.png" width="105" height="105" /></a>
								</div>
								<h3>
									<a href="schedule.jsp" class="">2014년 컴퓨터공학과 개강파티</a>
								</h3>

								<div class="clr"></div>
							</article>
							<article>
								<div class="ct-latest-thumb">
									<a href="schedule.jsp" class="ct-trans"> <img src="resources/img/seoulaccord-notice.png" width="105" height="105" /></a>
								</div>
								<h3>
									<a href="schedule.jsp" class="">2014년 1학기 과목 도우미 모집</a>
								</h3>

								<div class="clr"></div>
							</article>
							<article>
								<div class="ct-latest-thumb">
									<a href="schedule.jsp" class="ct-trans"> <img src="resources/img/seoulaccord-notice.png" width="105" height="105" /></a>
								</div>
								<h3>
									<a href="schedule.jsp" class="">2014년 노트북 대여</a>
								</h3>

								<div class="clr"></div>
							</article>
							<article>
								<div class="ct-latest-thumb">
									<a href="schedule.jsp" class="ct-trans"> <img src="resources/img/seoulaccord-notice.png" width="105" height="105" /></a>
								</div>
								<h3>
									<a href="schedule.jsp" class="">기초프로그래밍 캠프 신청</a>
								</h3>

								<div class="clr"></div>
							</article>
							<article>
								<div class="ct-latest-thumb">
									<a href="schedule.jsp" class="ct-trans"> <img src="resources/img/department-notice.png" width="105" height="105" /></a>
								</div>
								<h3>
									<a href="schedule.jsp" class="">2014학년도 1학기 수강신청</a>
								</h3>

								<div class="clr"></div>
							</article>
							<article>
								<div class="ct-latest-thumb">
									<a href="schedule.jsp" class="ct-trans"> <img src="resources/img/department-notice.png" width="105" height="105" /></a>
								</div>
								<h3>
									<a href="schedule.jsp" class="">2014학년도 전기 재입학 신청</a>
								</h3>

								<div class="clr"></div>
							</article>
							<footer class="ct-latest-bottom">
								<a href="schedule.jsp">전체보기</a>
							</footer>
						</div>

						<div class="ct-widget" id="md-widget">
							<h5>Family Sites</h5>
							<article class="ct-familysite">
								<div class="ct-latest-thumb">
									<a
										href="http://myiweb.mju.ac.kr/"
										class="ct-trans" target="_blank"> <img src="resources/img/familysites/1.png" alt="myiweb.mju.ac.kr"/>
									</a>
								</div>
								<div class="ct-latest-thumb">
									<a
										href="http://abeek.mju.ac.kr/main/main.do"
										class="ct-trans" target="_blank"> <img src="resources/img/familysites/2.png" alt="ProgressButtonStyles" />
									</a>
								</div>
								<div class="ct-latest-thumb">
									<a
										href="http://gs.mju.ac.kr"
										class="ct-trans" target="_blank"> <img src="resources/img/familysites/3.png" alt="ProgressButtonStyles" />
									</a>
								</div>
								<div class="ct-latest-thumb">
									<a
										href="http://mju.ac.kr"
										class="ct-trans" target="_blank"> <img src="resources/img/familysites/4.png" alt="ProgressButtonStyles" />
									</a>
								</div>
								<div class="ct-latest-thumb">
									<a
										href="http://www.myongcom.kr"
										class="ct-trans" target="_blank"> <img src="resources/img/familysites/5.png" alt="ProgressButtonStyles" />
									</a>
								</div>
								<div class="ct-latest-thumb">
									<a
										href="http://117.17.158.196"
										class="ct-trans" target="_blank"> <img src="resources/img/familysites/6.png" alt="ProgressButtonStyles" />
									</a>
								</div>
								<div class="ct-latest-thumb">
									<a
										href="#"
										class="ct-trans" target="_blank"> <img src="resources/img/familysites/7.png" alt="ProgressButtonStyles" />
									</a>
								</div>
								<div class="ct-latest-thumb">
									<a
										href="#"
										class="ct-trans" target="_blank"> <img src="resources/img/familysites/8.png" alt="ProgressButtonStyles" />
									</a>
								</div>
								<div class="clr"></div>
							</article>
						</div>
					</div>
					<div class="clr"></div>
				</aside>
				<div class="clr"></div>
			</div>
		</div>
				<%@ include file="page/footer.jsp" %>		
	</div>
</body>
</html>
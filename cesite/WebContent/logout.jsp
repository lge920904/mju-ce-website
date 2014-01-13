<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
session.invalidate();
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
  <section> 로그아웃 되었습니다. <br/>
	 곧 메인 화면으로 이동합니다. <br/>
  </section> 
</body>
<script>
setTimeout("location.href='index.jsp'",1000);
</script>
</html>


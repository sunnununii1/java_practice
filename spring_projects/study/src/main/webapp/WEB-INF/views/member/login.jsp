<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<h1>로그인</h1>
	<form action="<c:url value='/member/login'/>" method="post">
		<input type="text" name="me_id" placeholder="아이디" required> <br>
		<input type="password"  name="me_pw" placeholder="비번" required> <br>
		<!-- form태그 안에 자동로그인, value값 트루는 boolean지정 위함(안하면 on으로 처리됨) -->
		<input type="checkbox" name="autoLogin" value="true">자동로그인
		<button>로그인</button>
	</form>
</body>
</html>
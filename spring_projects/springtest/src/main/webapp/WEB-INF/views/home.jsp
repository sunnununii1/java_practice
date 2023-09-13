<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
 pageEncoding="utf-8" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Login  
</h1>
<!-- 데이터 전송 2가지 복습 -->
<a href="<c:url value='/member/login?id=abc&pw=def'/>">id와 pw을 전송</a>
<form action="<c:url value='/member/login'/>" method="get">
	<input type="text" name="id"> <br>
	<input type="password" name="pw"> <br>
	<button>전송</button>
</form>

<h1>여러 회원정보를 서버에 전송하기</h1>
<form action="<c:url value='/member/login3'/>" method="get">
	<h3>회원1</h3>
	<input type="text" name="id"> <br>
	<input type="password" name="pw"> <br>
	<h3>회원2</h3>
	<input type="text" name="id"> <br>
	<input type="password" name="pw"> <br>
	<h3>회원3</h3>
	<input type="text" name="id"> <br>
	<input type="password" name="pw"> <br>
	<button>전송</button>
</form>

<h1>여러 회원정보를 서버에 전송하기(server)</h1>
<form action="<c:url value='/member/login3'/>" method="get">
	<c:forEach begin="0" end="2" var="i">
		<h3>회원${i+1}</h3>
		<input type="text" name="list[${i}].id"> <br>
		<input type="password" name="list[${i}].pw"> <br>
	</c:forEach>
	<button>전송</button>
	</form>

<h1>여러 회원정보를 서버에 전송하기(login4)</h1>
<form action="<c:url value='/member/login4'/>" method="get">
	<c:forEach begin="0" end="2" var="i">
		<h3>회원${i+1}</h3>
		<input type="text" name="list[${i}].id"> <br>
		<input type="password" name="list[${i}].pw"> <br>
	</c:forEach>
	<button>전송</button>
</form>
</body>
</html>

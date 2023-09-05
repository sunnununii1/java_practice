<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update</title>
</head>
<body>
	<h3>게시글 수정</h3>
	<form action="<c:url value='/board/update'/>" method="post">
		<input type="hidden" name="bo_num" value ="${board.bo_num}">
		<input type="text" name="bo_title" placeholder="제목" value="${board.bo_title}"> <br>
		<textarea rows="20" cols="30" name="bo_contents" placeholder="내용">${board.bo_contents}</textarea> <br>
		<button>수정</button>
	</form>
</body>
</html>
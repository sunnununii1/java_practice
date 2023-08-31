<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
 pageEncoding="utf-8" %>
<!doctype html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 상세</h1>
	
	<div class="form-group">
		<label>제목</label>
		<div class="form-control">${board.bo_title}</div>
	</div>
	<div class="form-group">
		<label>작성자</label>
		<div class="form-control">${board.bo_me_id}</div>
	</div>
	<div class="form-group">
		<label>조회수</label>
		<div class="form-control">${board.bo_views}</div>
	</div>
	<div class="form-group">
		<label>등록일</label>
		<div class="form-control">${board.bo_reg_date_str}</div>
	</div>
	<c:if test="${board.bo_up_date != null }">
	<div class="form-group">
		<label>수정일</label>
		<div class="form-control">${board.bo_up_date_str}</div>
	</div>
	</c:if>
	
	<!-- 추천비추천 버튼 -->
	<div class="form-group clearfix">
		<button class="btn btn-outline-primary btn-up col-6 float-left">추천(${board.bo_up})</button>
		<button class="btn btn-outline-danger btn-up col-6 float-right">비추천(${board.bo_down})</button>
	</div>
	
	<div class="form-group">
		<label>내용</label>
		<div class="form-control" style="min-height:400px">${board.bo_contents}</div>
	</div>
	
	<!-- 목록으로 돌아가기 버튼 -->
	<!-- ${cri.currentUrl} 추가하면 이전페이지 그대로 잔류기능 -->
	<a href="<c:url value='/board/list${cri.currentUrl}'/>" class="btn btn-outline-primary">목록으로</a>
</body>
</html>
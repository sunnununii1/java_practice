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
		<h3>첨부파일</h3>
		<c:forEach items="${fileList}" var="file">
			<div class="box">
				<a href=
					"<c:url value='/download${file.fi_name}'/>" 
					download="${file.fi_ori_name}"> ${file.fi_ori_name}
				</a>
				<a href="#" class="btn-del" data-num="${file.fi_num}"><button type="button">X</button></a> <!-- sumit안되게 버튼타입지정 하기 -->
			</div>
		</c:forEach>
		<!-- 첨부파일 개수에 따라 추가가능 파일 갯수 정해주기 -->
		<c:forEach begin="1" end="${3 - fileList.size()}">
			<input type="file" name="files"> <br>
		</c:forEach>
		<button class="btn-submit">수정</button>
	</form>
	<script type="text/javascript" src="//code.jquery.com/jquery-3.6.1.js"></script>
	<script type="text/javascript">
		$('.btn-del').click(function(e){
			e.prevenDefault();
			let fi_num = $(this).data('num');
			$('.btn-submit').before('<inpur type="file" name="files"><br>')
			$('.btn-submit').before('<inpur type="hidden" name="delNums" value="'+fi)num+'"><br>');
			$(this).parent().remove();
		})
	</script>
</body>
</html>
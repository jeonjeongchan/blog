<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>[게시판 글쓰기]</h2>
	<form action='<c:url value='/board'/>' method="post">
	    <div>작성자<input type="text" name="name"></div>
	    <div>제목<input type="text" name="title"></div>
	    <div>내용<textarea rows="5" cols="13" name="content"></textarea></div>
	    <button type="submit">완료</button>
	    <button type="button" onclick="location.href='board/list'">목록</button>
	</form>

</body>
</html>
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
<h2>[게시판 내용]</h2>
<form name="form" action='<c:url value='/board/${id}'/>' method="post">
	<input type="hidden" name="_method" value="delete"/>
    <div>글번호<input name="id" readonly="readonly" value="${id}"></div>
    <div>제목<input name="title" readonly="readonly" value="${data.title}"></div>
    <div>내용<input name="content" readonly="readonly" value="${data.content}"></div>
    <button type="submit">삭제</button>
</form>
    <button onclick="location.href='/board/list'">목록</button>
	<button id="modify" onclick="location.href='/board/edit/${id}'">수정</button>
<!-- 두가지 모두 가능 -->
</body>
</html>
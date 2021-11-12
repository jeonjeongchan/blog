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
<h2>[게시판 수정]</h2>
<form action='<c:url value='/board/edit/${id}'/>' method="post">
	<input type="hidden" name="_method" value="put"/>
    <div><label>글번호</label>
         <input name="id" readonly="readonly" value="${id}">
    </div>
    <div>
        <label>제목</label>
        <textarea rows="5" cols="13" name="title">${data.title}</textarea>
    </div>
    <div>
        <label>내용</label>
        <textarea rows="5" cols="13" name="content">${data.content}</textarea>
    </div>
    <button type="submit">수정완료</button>
    <button type="button" onclick="location.href='/board/list'">돌아가기</button>
</form>
<input type="hidden" name="id" value="${id}">
</body>
</html>
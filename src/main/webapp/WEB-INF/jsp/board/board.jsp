<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.jeon.blog.domain.UserVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>[게시판 리스트]</h2> 
<div style="margin-bottom: 10px">
    <% 
        if (session.getAttribute("user") == null) {
            out.println("<a href='/'로그인</a>");
        } else {
        	UserVO userVO = (UserVO)session.getAttribute("user");
            out.println(userVO.getId() + "님 반갑습니다.<br>");
        }
    %>
<button type="button" onclick="location.href='/user/Modify'">회원정보 수정</button>
<button type="button" onclick="location.href='/logout'">로그아웃</button>
</div>
<table border="1">
    <tr>
        <th>글번호</th>
        <th>작성자</th>
        <th>제목</th>
        <th>내용</th>
        <th>작성날짜</th>
        <th>수정날짜</th>
    </tr>
    
    <c:forEach items="${list}" var="data">
    <tr>
        <td>${data.id}</td>
        <td>${data.user_id}</td>
        <td>${data.title}</td>
        <td><a href="/board/${data.id}">${data.content}</a></td>
        <td>${data.register_date}</td>
        <td>${data.update_date}</td>
    </tr>
    </c:forEach>
</table>
<button type="button" onclick="location.href='/board'">글쓰기</button> 
    
<ul class="paging">
    <c:if test="${paging.prev}">
        <span><a href='<c:url value="/board/list?page=${paging.startPage - 1}"/>'>이전</a></span>
    </c:if>
    <c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="id">
        <span><a href='<c:url value="/board/list?page=${id}"/>'>${id}</a></span>
    </c:forEach>
    <c:if test="${paging.next && paging.endPage > 0}">
        <span><a href='<c:url value="/board/list?page=${paging.endPage + 1}"/>'>다음</a></span>
    </c:if>
</ul>

</body>
</html>
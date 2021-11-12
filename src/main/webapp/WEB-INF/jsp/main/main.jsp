<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.jeon.blog.domain.UserVO"%>
<!DOCTYPE html>
<html>
<script type="text/javascript">

	function listClick() {
		
		var user = '<%=session.getAttribute("user")%>';
		console.log(user); 

		if (user == 'null') {
			alert('로그인이 필요합니다.')
			location.href="/login";
		} else {
			location.href="/board/list";
		}
			
	}
	
	function loginClick() {
		
		var user = '<%=session.getAttribute("user")%>';
		console.log(user); 

		if (user == 'null') {
			location.href="/login";
		} else {
			location.href="/board/list";
		}
		
	}


</script>
<head>

<meta charset="UTF-8">
<title>전정찬의 블로그</title>

</head>
<body>
<h2>환영합니다</h2>

<div>
	<c:if test="${user == null}">
		<button type="button" onclick="listClick()">게시판</button>
		<button type="button" onclick="loginClick()">로그인</button> 
	</c:if>
	<c:if test="${user != null}">
		<button type="button" onclick="listClick()">게시판</button>
		<button type="button" onclick="location.href='/user/Modify'">회원정보 수정</button>
		<button type="button" onclick="location.href='/logout'">로그아웃</button>
	</c:if> 
</div>	
</body>
</html>
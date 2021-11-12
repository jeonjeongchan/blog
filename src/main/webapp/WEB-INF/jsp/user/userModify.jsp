<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
<html>
<head>
<script type="text/javascript">
 
/* ajax를 통한 비밀번호 수정처리 */
function modifyUser() {
    
    var id = $("#id").val();
    var password = $("#password").val();
    
    var param = {"id":id, "password":password}
    
    if(password == '') {
        alert("비밀번호를 올바르게 입력해주세요.");
    } else {
        $.ajax({
            anyne:true,
            type:'PUT',
            data: JSON.stringify(param),
            url:"/user/edit/" + id,
            dataType: "text",
            contentType: "application/json; charset=UTF-8",
            success : function(data) {
                alert("비밀번호 변경이 완료되었습니다.");
                location.href="/board/list";
            },
            error: function(jqXHR, textStatus, errorThrown) {
            	
            	alert("ERROR : " + textStatus + " : " + errorThrown);
                
            }        
        })
    }
    
}

/* ajax를 통한 비밀번호 삭제처리 */
function deleteUser() {
    
	var inputPass1 = prompt("비밀번호를 입력해주세요.");
	 
    if(inputPass1 != null) {
        var trimPass1 = inputPass1.trim();
 
        if(trimPass1 != "" && trimPass1 != undefined) {            
            var inputPass2 = prompt("비밀번호를 다시 입력해주세요.");
            var trimPass2 = inputPass2.trim();
            
            if(trimPass1 == trimPass2) {
                
                var id = $("#id").val();
                var param = {"id":id, "password":trimPass1}
            
                $.ajax({            
                    async: true,
                    type: 'DELETE',
                    data: JSON.stringify(param),
                    url: "/user/" + id,
                    dataType: "text",
                    contentType: "application/json; charset=UTF-8",
                    success: function(data) {                    
                        alert("탈퇴가 처리되었습니다.");
                        location.href="/";
                    },
                    error: function(jqXHR, textStatus, errorThrown) {
                        alert("ERROR : " + textStatus + " : " + errorThrown);
                    }            
                })    
            } else alert("비밀번호가 일치하지 않습니다.");    
        } else {
            alert("비밀번호를 제대로 입력해주세요.");
        }
    } 

}


</script>
</head>
<body>
<h2>[회원정보 수정]</h2>
<form action='<c:url value='/user/edit/{id}'/>' method="post">
	<input type="hidden" name="_method" value="put"/>
    <div>이름<input type="text" name="name" id="name" value="${name}" readonly="readonly"></div>    
    <div>아이디<input type="text" name="id" id="id" value="${id}" readonly="readonly"></div>
    <div>비밀번호<input type="text" name="password" id="password" value="${password}"></div>
</form>
    <button type="button" id="submit" onclick="modifyUser()">수정완료</button>
    <button type="button" onclick="location.href='/board/list'">처음으로</button>
    <button type="button" onclick="deleteUser()">회원 탈퇴</button>
</body>
</html>
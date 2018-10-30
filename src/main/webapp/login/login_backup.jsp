<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login.jsp</title>
</head>
<body>
	<%--
		브라우저 주소줄에 입력한 경우 : get
		form 태그의 method 속성 : get/post 
	--%>
	<form method="post" action="/dditLogin">
		아이디 : <input type="text" name="user_id" value="brown"><br>
<!-- 		아이디 : <input type="text" name="user_id" value="샐리"><br> -->
		패스워드 : <input type="password" name="user_pw" value="pass1234"><br>
		<input type="submit" value="로그인">
	</form> 
</body>
</html>
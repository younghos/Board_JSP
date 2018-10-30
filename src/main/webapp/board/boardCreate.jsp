<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>boardCreate.jsp</title>

<%@ include file="/common/basicLib.jsp" %>
<style type="text/css">

	.select {
		width : 50px;
		height: 27px;
	}
</style>
</head>
<body>
	<%@ include file="/common/header.jsp" %> 
	
	<div class="container-fluid">
		<div class="row">
		
			<%-- left --%>
			<%@ include file="/common/left.jsp" %>
			
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<br><br>
				<h2>게시판 생성</h2><br>
				<form action="/boardCreate" method="post">
					<span>게시판 이름</span>&nbsp; : &nbsp;<input type="text" id="boardName" name="boardName" /> &nbsp;&nbsp; 
					<select class="select" id="check" name="check" width="200">
						<option value="0">사용</option>
						<option value="1">미사용</option>
					</select>
					&nbsp;&nbsp;
					<input type="submit" value="생성" /> <br>
				</form>
				<br><br>
				<h2>게시판 수정</h2><br>
				<c:choose>
					<c:when test="${selectList != null }">
						<c:forEach items="${selectList }" var="board">
							<form action="/boardUpdate" method="post">
								<span>게시판 이름</span>&nbsp; : &nbsp;<input type="text" id="${board.board_id }" name="boardName" value="${board.board_name }" /> &nbsp;&nbsp; 
								<select class="select" id="check" name="check" width="200">
									<c:choose>
										<c:when test="${board.board_chk == 0 }">
											<option value="0" selected>사용</option>
											<option value="1">미사용</option>	
										</c:when>
										<c:otherwise>
											<option value="0">사용</option>
											<option value="1" selected>미사용</option>	
										</c:otherwise>
									</c:choose>
									
								</select>
								&nbsp;&nbsp;
								<input type="hidden" id="boardId" name="boardId" value="${board.board_id }"/>
								<input type="submit" value="수정" /> <br><br>
							</form>
						</c:forEach>
					</c:when>
				</c:choose>
				
			</div>
		</div>
	</div>
</body>
</html>
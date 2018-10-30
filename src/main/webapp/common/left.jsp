<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	#disable{
		pointer-events:none; 
		opacity:0.6;
	}
</style>
</head>
<body>
<% UserVo userVo = (UserVo)session.getAttribute("S_USER"); %>
<div class="col-sm-3 col-md-2 sidebar">
	<ul class="nav nav-sidebar">
		<li class="active"><a href="/main.jsp">Main <span class="sr-only">(current)</span></a></li>
		<c:choose>
			<c:when test="${S_USER.userId != null }">
				<li class="active"><a href="/boardCreate?userId=<%=userVo.getUserId() %>">게시판 생성</a></li>
				<c:forEach items="${boardList }" var="vo">
					<c:choose>
						<c:when test="${vo.board_chk != 1 }">
							<li class="active"><a href="/noticeFree?page=1&pageSize=10&board_id=${vo.board_id }">${vo.board_name }</a></li>
						</c:when>
						<c:otherwise>
							<li class="active" id="disable"><a href="/noticeFree?page=1&pageSize=10&board_id=${vo.board_id }">${vo.board_name }</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<li class="active"><a href="#>">게시판 생성</a></li>
			</c:otherwise>
		</c:choose>
		
		
	</ul>
</div>
</body>
</html>
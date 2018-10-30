<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<link rel="shortcut icon" href="favicon.ico" />

<title>boardDetail.jsp</title>
<%@ include file="/common/basicLib.jsp" %>
<script src="/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#delete").click(function(){
		$("#deleteFrm").submit();
	});
	
	$("#reply").click(function(){
		$("#replyFrm").submit();
	});
	$("#update").click(function(){
		$("#upFrm").submit();
	});
	
});
</script>
</head>
<body>
<form action="/noticeDelete" method="post" id="deleteFrm">
	<input type="hidden" id="notice_no" name="notice_no" value="${noticeVo.notice_no }"/>
	<input type="hidden" id="notice_board" name="notice_board" value="${noticeVo.notice_board }"/>
</form>

<form action="/noticeReply" method="get" id="replyFrm">
	<input type="hidden" id="notice_no" name="notice_no" value="${noticeVo.notice_no }"/>
	<input type="hidden" id="notice_board" name="notice_board" value="${noticeVo.notice_board }"/>
	<input type="hidden" id="notice_name" name="notice_name" value="${noticeVo.notice_name }" />
</form>

	<%@ include file="/common/header.jsp" %> 
	
	<div class="container-fluid">
		<div class="row">
			<%@ include file="/common/left.jsp" %>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h2>게시글 상세조회</h2><br><br>
				<form class="form-horizontal" role="form" action="/noticeUpdate" method="get" id="upFrm">
				<input type="hidden" id="notice_no" name="notice_no" value="${noticeVo.notice_no }" />
<!-- 					<div class="form-group"> -->
<!-- 						<label for="userNm" class="col-sm-2 control-label">사용자 사진</label> -->
<!-- 						<div class="col-sm-10"> -->
<%-- 							<c:choose> --%>
<%-- 								<c:when test="${userVo.profile != null }"> --%>
<%-- 									<img src="${userVo.profile }" width="200" height="200"/> --%>
<%-- 								</c:when> --%>
<%-- 								<c:otherwise> --%>
<!-- 									<img src="/profile/noImage.png" width="200" height="200"/> -->
<%-- 								</c:otherwise> --%>
<%-- 							</c:choose> --%>
<!-- 						</div> -->
<!-- 					</div> -->
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">게시글 제목</label>
						<div class="col-sm-10">
							<label class="control-label">${noticeVo.notice_name }</label>
							<input type="hidden" id="notice_name" name="notice_name" value="${noticeVo.notice_name }" />
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">게시글 내용</label>
						<div class="col-sm-10">
							<label class="control-label">${noticeVo.notice_content}</label>
							<input type="hidden" id="notice_content" name="notice_content" value="${noticeVo.notice_content }" />
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">첨부파일</label>
						<div class="col-sm-10">
							<c:forEach items="${attachmentList }" var="attachment">
								<label class="control-label">${attachment.file_name }</label><br>
							</c:forEach>
						</div>
					</div>
										
				</form>
				<div class="form-horizontal">
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<c:if test="${S_USER.userId == noticeVo.notice_user }">
								<button id="update" type="submit" class="btn btn-default">수정</button>
								<button id="delete" class="btn btn-default">삭제</button>
							</c:if>
							<button id="reply" class="btn btn-default">답글</button>
							<input type="hidden" name="userId" value="${userVo.userId }"/>
						</div>
					</div>
					<br>
				</div>
				<div class="form-horizontal">
					<form action="/commentDelete" method="post">
						<div class="form-group">
							<label for="userNm" class="col-sm-2 control-label">댓글</label>
							<div class="col-sm-10">
								<c:forEach items="${ctList }" var="ct">
									<label class="control-label">${ct.ct_content}(${ct.ct_user }&nbsp; / &nbsp;${ct.ct_date })</label>
									<c:if test="${ct.ct_user == S_USER.userId }">
										<button type="submit" class="btn btn-default">댓글 삭제</button>
										<input type="hidden" id="ct_id" name="ct_id" value="${ct.ct_id }" />
										<input type="hidden" id="ct_notice" name="ct_notice" value="${ct.ct_notice }" />
									</c:if>
									<br>
								</c:forEach>
							</div>
						</div>
					</form>
					<form action="/commentInsert" method="post">
						<div class="form-group">
							<label for="userNm" class="col-sm-2 control-label">댓글쓰기</label>
							<div class="col-sm-10">
								<input type="text" size="50" maxlength="500" name="ct_content" id="ct_content" /> 
								<input type="hidden" id="ct_notice" name="ct_notice" value="${noticeVo.notice_no }" />
								<button id="comment" class="btn btn-default" type="submit">댓글 저장</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
<body>

</html>
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

<title>boardFree.jsp</title>

<%@ include file="/common/basicLib.jsp" %>
<style type="text/css">
	.noticeClick{
		cursor:pointer;
	}
	#hidden{
		display:none;
	}
	#disabled{
		cursor : default;
		pointer-events : none;
	}
	
</style>
<script src="/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">

$(document).ready(function(){	
	var ev = "click";
	$(".noticeClick").on(ev, function(){
		var notice_no = $(this).children()[1].innerText;
		$("#notice_no").val(notice_no);
		$("#frm").submit();
	});
	
});
</script>
</head>
<body>
<form action="/noticeDetail" method="get" id="frm">
	<input type="hidden" id="notice_no" name="notice_no" />
</form>

	<%@ include file="/common/header.jsp" %> 
	
	<div class="container-fluid">
		<div class="row">
		
			<%-- left --%>
			<%@ include file="/common/left.jsp" %>
			
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">게시판</h2>
						<div class="table-responsive">
							<table class="table table-striped table-hover" id="tableId">
								<tr>
									<th>번호</th>
									<th id="hidden">고유번호</th>
									<th>게시글 제목</th>
									<th>등록자 아이디</th>
									<th>게시글 등록일</th>
								</tr>
								
								<c:forEach items="${boardFreeList }" var="vo">
									<c:choose>
										<c:when test="${vo.notice_chk == 0 }">
											<tr class="noticeClick">
												<td>${vo.rnum }</td>
												<td id="hidden">${vo.notice_no }</td>
												<td>${vo.notice_name }</td>
												<td>${vo.notice_user }</td>
												<td><fmt:formatDate value="${vo.notice_date }" pattern="yyyy-MM-dd hh:mm:ss" /></td>
											</tr>
										</c:when>
										<c:otherwise>
											<tr>
												<td>${vo.rnum }</td>
												<td id="hidden">${vo.notice_no }</td>
												<td>${vo.notice_name }</td>
												<td>${vo.notice_user }</td>
												<td><fmt:formatDate value="${vo.notice_date }" pattern="yyyy-MM-dd hh:mm:ss" /></td>
											</tr>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</table>
						</div>
						<form action="/boardInsert" method="post">
							<button class="btn btn-default pull-right" type="submit">게시글 등록</button>
							<input type="hidden" name="board_id" value="${notice_board }" />
						</form>

						<div class="text-center">
							<ul class="pagination">
								<c:choose>
									<c:when test="${page == 1 }">
										<li><a id="disabled" href="/noticeFree?page=1&pageSize=10&board_id=${notice_board}" aria-label="Previous"> <span
												aria-hidden="true">&laquo;</span>
										</a></li>		
									</c:when>
									<c:otherwise>
										<li><a href="/noticeFree?page=1&pageSize=10&board_id=${notice_board}" aria-label="Previous"> <span
												aria-hidden="true">&laquo;</span>
										</a></li>
									</c:otherwise>
								</c:choose>
							
								<c:choose>
									<c:when test="${page > 1 }">
										<li><a href="/noticeFree?page=${page-1 }&pageSize=10&board_id=${notice_board}"> <span
												aria-hidden="true">&lt;</span>
										</a></li>
									</c:when>
									<c:otherwise>
										<li><a id="disabled" href="/noticeFree?page=1&pageSize=10&board_id=${notice_board}"> <span
												aria-hidden="true">&lt;</span>
										</a></li>
									</c:otherwise>
								
								</c:choose>
								<c:forEach begin="1" end="${pageCnt }" var="i">
									
										<li><a href="/noticeFree?page=${i }&pageSize=10&board_id=${notice_board}">${i }</a>
									
								</c:forEach>
								<c:choose>
									<c:when test="${page eq pageCnt}">
										<li><a id="disabled" href="/noticeFree?page=${pageCnt }&pageSize=10&board_id=${notice_board}" > <span
												aria-hidden="true">&gt;</span>
										</a></li>
									</c:when>
									<c:otherwise>
										<li><a  href="/noticeFree?page=${page+1 }&pageSize=10&board_id=${notice_board}" > <span
												aria-hidden="true">&gt;</span>
										</a></li>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${page == pageCnt }">
										<li><a id="disabled" href="/noticeFree?page=${pageCnt }&pageSize=10&board_id=${notice_board}" aria-label="Next"> <span
														aria-hidden="true">&raquo;</span>
										</a></li>
									</c:when>
									<c:otherwise>
										<li><a  href="/noticeFree?page=${pageCnt }&pageSize=10&board_id=${notice_board}" aria-label="Next"> <span
														aria-hidden="true">&raquo;</span>
										</a></li>
									</c:otherwise>
								</c:choose>
							</ul>
						</div>
					</div>
				</div>
				
			</div>
		</div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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

<title>board Jsp</title>

<%@ include file="/common/basicLib.jsp" %>

</head>

<body>
	<%-- @은 지시자 --%>
	<%-- header --%>
	<%@ include file="/common/header.jsp" %> 
	
	<div class="container-fluid">
		<div class="row">
		
			<%-- left --%>
			<%@ include file="/common/left.jsp" %>
			
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="blog-header">
					<h1 class="blog-title">JSP 과제</h1>
					<p class="lead blog-description">게시판 연습</p>
				</div>

				<div class="row">

					<div class="col-sm-8 blog-main">

						<div class="blog-post">
							<h2 class="blog-post-title">Seo Jun Young</h2>
							<%

							 java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
							 String today = formatter.format(new java.util.Date());
							
							%>
							<p class="blog-post-meta"><%=today %>)</p>

							<p>jsp를 통한 웹 프로그래밍 학습(게시판만들기)</p>
							<hr>

							<h3>상세내역</h3>
							<p>다음 아래와 같은 내용의 게시판을 만든다.</p>
							<ul>
								<li>로그인에 성공한 회원만 사용가능</li>
								<li>유연한 게시판 생성</li>
								<li>계층형 게시판(최신순으로 정렬)</li>
								<li>사진첨부가 가능한 게시글(최대 5개)</li>
								<li>페이징처리(1페이지 당 10건)</li>
								<li>게시글 삭제시 삭제메세지 표시</li>
							</ul>
						</div>
					</div>
					<!-- /.blog-main -->
				</div>
			</div>
		</div>
	</div>
</body>
</html>

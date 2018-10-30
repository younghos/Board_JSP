<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
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

<title>noticeUpdate.jsp</title>

<%@ include file="/common/basicLib.jsp"%>
<script type="text/javascript" src="/js/jquery-3.3.1.min.js"></script>
<script src="/SE2/js/HuskyEZCreator.js"></script>
<style type="text/css">
	.delete{
		cursor:pointer;
	}
	li{
		list-style: none;
	}
</style>
<script type="text/javascript">
var oEditors = []; // 개발되어 있는 소스에 맞추느라, 전역변수로 사용하였지만, 지역변수로 사용해도 전혀 무관 함.

$(document).ready(function() {
	// Editor Setting
	nhn.husky.EZCreator.createInIFrame({
		oAppRef : oEditors, // 전역변수 명과 동일해야 함.
		elPlaceHolder : "smarteditor", // 에디터가 그려질 textarea ID 값과 동일 해야 함.
		sSkinURI : "/SE2/SmartEditor2Skin.html", // Editor HTML
		fCreator : "createSEditor2", // SE2BasicCreator.js 메소드명이니 변경 금지 X
		htParams : {
			// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseToolbar : true,
			// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseVerticalResizer : true,
			// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
			bUseModeChanger : true, 
		}
	});
	
	// 전송버튼 클릭이벤트
	$("#savebutton").click(function(){
		if(confirm("저장하시겠습니까?")) {
			// id가 smarteditor인 textarea에 에디터에서 대입
			oEditors.getById["smarteditor"].exec("UPDATE_CONTENTS_FIELD", []);
			// 이부분에 에디터 validation 검증
			if(validation()) {
				$("#frm").submit();
			}
		}
	});
	//var cnt = 0;
	var cnt = $("input[name=fileName]").length;
	$("#append").click(function(){
		++cnt;
		if(cnt < 6){
			$(".a").append("<input class=\"input"+cnt+"\""+"type=\"file\" id=\"noticeFile"+cnt+"\""+" name=\"noticeFile"+cnt+"\" />");
		} else{
			alert("파일은 최대 5개까지입니다.");
		}
	});
	
	$("#remove").click(function(){
		if(cnt<1){
			return false;
		} else{
			$(".input"+cnt).remove();
			$(".label"+cnt).remove();
			cnt--;
		}
	});
	
});

function validation(){
	var contents = $.trim(oEditors[0].getContents());
	if(contents === '<p>&nbsp;</p>' || contents === ''){ // 기본적으로 아무것도 입력하지 않아도 <p>&nbsp;</p> 값이 입력되어 있음. 
		alert("내용을 입력하세요.");
		oEditors.getById['smarteditor'].exec('FOCUS');
		return false;
	}

	return true;
}
</script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	<%@ include file="/common/header.jsp"%>

	<div class="container-fluid">
		<div class="row">

			<%-- left --%>
			<%@ include file="/common/left.jsp"%>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<form class="form-horizontal" role="form" action="/noticeUpdate" method="post" id="frm">
				<input type="hidden" id="notice_no" name="notice_no" value="${notice_no }" />
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">게시글 제목</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="notice_name" id="notice_name" value="${notice_name }">
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">게시글 내용</label>
						<div class="col-sm-10">
							<textarea name="smarteditor" id="smarteditor" rows="10" cols="100" style="width:766px; height:412px;">${notice_content }</textarea>
						</div>
					</div>
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">첨부파일</label>
						<div class="col-sm-10 a">
							<i class="fa fa-plus" id="append"></i>
							<i class="fa fa-minus" id="remove"></i><br>
							<c:forEach items="${attachmentList }" var="attachment" begin="0" varStatus="i">
								<input class="input${i.index }" type="file" id="fileName" name="fileName" />
								<label class="label${i.index }">${attachment.file_name }</label><br>
							</c:forEach>
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" id="savebutton" class="btn btn-default">수정</button>
						</div>
					</div>
				</form>	
			</div>
		</div>
	</div>
</body>
</html>
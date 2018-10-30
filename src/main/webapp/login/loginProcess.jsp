<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>loginProcess.jsp</title>
</head>
<body>
	<%-- login.jsp 에서 전송한 파라미터 : user_id, user_pw --%>
	<%-- 
		request parameter 관련 메소드
		1. getParameter(String name);
		2. getParameterValues(String name);
		3. getParameterMap();
		4. getParameterNames();
	 --%>
	<%
		String[] useridValues = request.getParameterValues("user_id");
	
		Map<String, String[]> param = request.getParameterMap();
		
		// user_id, user_pw 파라메터 이름이 있다는 것을 알 수 잇음
		Enumeration<String> parameterNames = request.getParameterNames();
		while(parameterNames.hasMoreElements()){
			String parameterName = parameterNames.nextElement();
			System.out.println("parameterName : "+parameterName);
		}
	%> 
	<h2>requsetParameter</h2>
	request.getParameter("user_id") : <%= request.getParameter("user_id") %> <br>
	request.getParameterValues("user_id") : 
		<% 
			for(int i=0;i<useridValues.length;i++){
				out.write(useridValues[i] + "<br>");
			}
		%>
	request.getParameter("user_pw") : <%= request.getParameter("user_pw") %> <br>
	
	<h2>requestMap</h2>
	
	<% for(String str : param.get("user_id")){ %>
			str : <%=str%> <br>
	<% }%>
	param.get("user_pw") : <%= param.get("user_pw") %>
</body>
</html>
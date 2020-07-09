<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		 pageContext.setAttribute("page_", "page_value");
	
		request.setAttribute("request_", "request_value");
	
		session.setAttribute("session_", "session_value");
		
		application.setAttribute("application_", "application_value");
	%>


	<%=pageContext.getAttribute("page_") %>
	<%=request.getAttribute("request_") %>
	
	<%=session.getAttribute("session_") %>
	
	<%=application.getAttribute("application_") %>
	<%-- <jsp:forward page="page4.jsp"></jsp:forward> --%>
<%
	 response.sendRedirect("page4.jsp"); 
%>
</body>
</html>
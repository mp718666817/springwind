<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<%-- <%!
	class  M{
	
	
	public void add(){
		
		
	}
	
}


public void show(){
	
}
%> --%>

<%-- <%
	 int  x = 10;
	int y = 20;

	for(int i=0;i<5;i++){
		%>
		<br/>
		
		<%
		
	}
	
%>

<%= x %> --%>

<%-- <%
	 int  x = 10;
	int y = 0;

%>

<%=x/y %> --%>

index.jsp


<%
	 int i = 20;
%>


<!-- 先包含 再一起编译 -->

<%@ include file="top.jsp" %>


<c:if test="${0==0 }">
	if content
</c:if>
<c:if test="${0!=0 }">
	if  else content
</c:if>



</body>
</html>
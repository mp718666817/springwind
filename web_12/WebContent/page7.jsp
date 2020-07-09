<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="java.util.*" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		 request.setAttribute("m", "m_value");
	%>

	<%="Hello" %>
	
	<c:out value="${m }"  default="H"></c:out>
	<c:set  value="M_z" var="a" scope="request"></c:set>
	
	<c:remove var="a" scope="request"/>
	${requestScope.a }
	
	<%
		request.setAttribute("age", 10);
	
	
		%>
	
	<c:if test="${age>=10 }">
	
		  age is 10
	</c:if>
	
	<c:if  test="${age<=10 }">
	
		 age lt 10
	</c:if>
	
<%-- 	<c:import url="http://localhost:8686/web_12/top.jsp"></c:import> --%>
	
	<hr/>
	
	<c:forTokens items="1-2-3-4-5" delims="-" var="s">
		${s }
	</c:forTokens>
	
<%-- 	<c:redirect url="http://localhost:8686/web_login/login.html">
		<c:param name="uname" value="xiaoming"></c:param>
	</c:redirect> --%>
	
	<c:url value="http://www.baidu.com"></c:url>
	
	
	<c:choose>
		<c:when test="${1!=1 }">
			1....
		</c:when>
		<c:when test="${1!=1 }">
			2....
		</c:when>
		<c:otherwise>
			other...
		</c:otherwise>
	</c:choose>
	
	
	<hr/>
	
	
	<%
		List<String> names =   new ArrayList<>();
		names.add("JAVA");
		names.add("WEB");
		names.add("SCRIPT");
		names.add("WEB1");
		names.add("SCRIPT2");
		names.add("WEB3");
		names.add("SCRIPT4");
		
		request.setAttribute("names", names);
	%>
	
	
	<c:forEach items="${names }" var="s"  step="3">
		${s }
	</c:forEach>
	
	
</body>
</html>
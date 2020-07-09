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
		
	
	%>
	
	${param.name }
	
	-->
	
	${paramValues.hab[0] }---> ${paramValues.hab[1] }
	
	<%= request.getHeader("User-Agent") %>
	--->
	${header["User-Agent"] }
	
	<br/>
	
	${initParam.pageSize }
	
	<br/>
	
	
	${ cookie.JSESSIONID.value}
<h3>获取PageContext中的对象</h3>
IP地址：${ pageContext.request.remoteAddr }
工程路径:${ pageContext.request.contextPath }
	
</body>
</html>
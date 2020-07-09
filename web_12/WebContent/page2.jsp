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
		 int i = 30;
	%>
	<!-- 先分别编译  再合并 -->
<%-- 	<jsp:include page="page1.jsp"></jsp:include> --%>

	<jsp:useBean id="u" class="entity.User"></jsp:useBean>
	<jsp:setProperty property="name" name="u"  value="Hello"/>


	<%=u.getName() %>
	
	<jsp:getProperty property="name" name="u"/>
	
	<!-- 转发 -->
	<jsp:forward page="page1.jsp">
		<jsp:param value="zz" name="ux"/>
		<jsp:param value="_zz" name="ux_"/>
	</jsp:forward>
	
	
</body>
</html>
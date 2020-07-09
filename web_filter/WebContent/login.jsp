<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
<form action="getDataSEervlet" method="post">
用户名：<input type="text" name="name"/></br>
密码：<input type="password" name="pwd"/></br>
自动登录：<input type="checkbox" name="checked"/>
<input type="submit" value="登录"/>
</form>
</body>
</html>
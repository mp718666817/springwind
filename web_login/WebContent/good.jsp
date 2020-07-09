<%@page import="domain.Goods"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
	Goods good=(Goods)request.getAttribute("good");
	%>
	<div style="width:200px;float:left;margin: 5px 5px;border:1px solid black;height:250px ">
		<img src="<%=good.getGoodsImg() %>" width="200px" height="250px"> 
		商品名称:<%=good.getGoodsName() %></br>
		商品价格:<%=good.getGoodsPrice() %></br>
		<a href="<%=request.getContextPath() %>/BuyGoodsServlet?goodsId=<%=good.getGoodsId()%>">加入购物车</a>
	</div>
</body>
</html>
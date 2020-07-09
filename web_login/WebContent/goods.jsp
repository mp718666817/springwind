<%@page import="domain.Goods"%>
<%@page import="java.util.List"%>
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
	List<Goods> goodsList=(List<Goods>)request.getAttribute("list");
	if(goodsList!=null){
		for(Goods g:goodsList){
			%>
			<div style="width:200px;float:left;margin: 5px 5px;border:1px solid black;height:250px ">
				<img src="<%=g.getGoodsImg() %>" width="200px" height="250px"> 
				商品名称<%=g.getGoodsName() %></br>
				<a href="<%=request.getContextPath()%>/GoodsIdServlet?goodsId=<%=g.getGoodsId() %>">查看商品信息</a>
			</div>
			<%
		}
	}
	else
	{
		%>
			没有商品！还不能查看
		<% 
	}
	%>
</body>
</html>
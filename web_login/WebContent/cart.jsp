<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Set"%>
<%@page import="domain.GoodsItem"%>
<%@page import="java.util.Map"%>
<%@page import="domain.Cart"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js">
</script>
<head>
<meta charset="UTF-8">
<style>
table,table tr th, table tr td { border:1px solid #0094ff; text-align: center; }
a{
	text-decoration: none;
}
.add{
	width: 20px;
	height: 20px;
	display:inline-block;
	text-align:center;
	line-height: 20px;
	border: 1px solid gray;
}
.del{
	width: 20px;
	height: 20px;
	display:inline-block;
	text-align:center;
	line-height: 20px;
	border: 1px solid gray;
}
</style>
<title>购物车</title>
</head>
<body>
<div style="width: :80%;margin: :0 auto;">
	<%Cart cart=(Cart)session.getAttribute("cart");
		if(cart==null){
			%>
			 	你还没有购买过商品，点击<a href="<%=request.getContextPath()%>/GoodsServlet"> </a>
			<%
		}
		else{
	
	%> 
<table width="80%" align="center">
	<tr>
		<td>商品编号</td>
		<td>商品名称</td>
		<td>商品单价</td>
		<td>商品图片</td>
		<td>商品数量</td>
			<td>操作</td>
	</tr>
		<%
		Map<Integer,GoodsItem> map = cart.getMap();
		Set<Entry<Integer,GoodsItem>> entries = map.entrySet();
		for(Entry<Integer,GoodsItem> entry:entries){
		%>
	<tr>
		<td><%=entry.getKey() %></td>
		<td><%=entry.getValue().getGoods().getGoodsName() %>
		</td>
		<td><%=entry.getValue().getGoods().getGoodsPrice() %></td>
		<td><img src="<%=entry.getValue().getGoods().getGoodsImg() %>" width="100px"></td>
		<td>
		<input type="hidden" value="<%=entry.getKey() %>">
		<a href="javascript:;" class="add">+</a>
		<span><%=entry.getValue().getNumber() %></span>
		<a href="javascript:;" class="del"> -</a>
		</td>
		<td><a href="javascript:;">删除</td>
	</tr>
	<%
	}
	%>
	<tr>
		<td colspan="6" style="text-align: left;">总金额：<span style="font-size: 20px;font-weight: bold;color: red;">$<%=cart.getMoney()%></span></td>
	</tr>
</table>
<%
	}
%>
</div>
<script type="text/javascript">
	$(function() {
		$(".add").mouseover(function() {
			$(this).css('backgroundColor','gray');
		})
		$(".add").mouseout(function() {
			$(this).css('backgroundColor','white');
		})
		$(".del").mouseover(function() {
			$(this).css('backgroundColor','gray');
		})
		$(".del").mouseout(function() {
			$(this).css('backgroundColor','white');
		})
		$(".add").click(function(){
			var id=$(this).prev().val();
			var obj=$(this)
		 	$.ajax(
			{	type:'post',
				url:'goodsMemberModifyServlet',
				data:'goodsId='+id,
				success:function(msg){
					$(obj).next().text(parseInt($(obj).next().text())+1);
					parseInt($(obj).parent().prev().prev.text())+
				}
			}) 
		})
	})
</script>>
</body>
</html>
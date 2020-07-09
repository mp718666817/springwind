<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="javascript:;">ajax</a>
</body>
<script type="text/javascript">
	$(function () {
		$('a:last').click(function () {
			$.ajax({
				type:'get',
				url:'JqueryServlet',
				success:function(msg){
					alert  (msg);
					var flag=confirt(msg);
					if (flag==true) {
						
					}
				}
				})	
		})
	})
</script>
</html>
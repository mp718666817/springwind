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
	pageContext.setAttribute("v__", "page_value");
//  pageScope
	request.setAttribute("v__", "request_value");
// requestScope
	session.setAttribute("v___", "session_value");
	// sessionScope
	application.setAttribute("v_", "application_value");
	//applicationScope
	
	entity.User u = new entity.User();
	u.setName("小明");
	u.setAge(10);
	
	request.setAttribute("user", u);
	
%>

${requestScope.request_ }

<br/>
${pageScope.request_ }
<br/>
${sessionScope.session_ }
<br/>
${applicationScope.application_ }


<hr/>

${v_ }
<!-- EL表达式获取对象的属性值 -->
${requestScope.user.name }  ==> ${user.age }
<br/>
${requestScope.user['name'] } ==> ${user['age'] }

<!-- EL 表达式操作 数组(通过下标获取元素) -->
<%
String[] names = new String[]{"JAVA","WEB"};
request.setAttribute("names", names);
%>
	
	<br/>
${names[0] }  ===> ${names[1] }

<br/>
<!-- El 操作集合 -->
<%
	 java.util.List<entity.User> list = new java.util.ArrayList<>();
	list.add(u);
	request.setAttribute("list", list);
%>
	
	${list.get(0).name }  ==>  ${list[0]['name'] } ==> ${list[0].age }


<!-- El 操作Map -->

<%
	 java.util.Map<String,String> map = new java.util.HashMap<>();
	map.put("javaSE", "javaSE_value");
	map.put("javaEE", "javaEE_value");
	
	request.setAttribute("map", map);
%>
<br/>

${map.get("javaSE") }  ==>${map["javaSE"] }  

<%
	pageContext.setAttribute("num1", 10);
pageContext.setAttribute("num2", 10);
%>

<br/>


${num1+num2}

${num1 eq num2}

${3>5 && 5>4 }

${ num1 ==num2 ? "正确":"错误" }

<br/>


${users ==null }  ----> ${empty users  }
${users !=null }  ----> ${not empty users  }
</body>
</html>
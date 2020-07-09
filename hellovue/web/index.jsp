<%--
  Created by IntelliJ IDEA.
  User: mp718
  Date: 2020/6/13
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<vue.js
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <script type="text/javascript" src="js/vue.js"></script>
  <script type="text/javascript">
    var vue = new Vue({
      el:"#myDiv",
      data:{
        username:"张三"
      }
    });
  </script>
  <div>
    {{username}}
  </div>
  </body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: mp718
  Date: 2020/6/9
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <div id="myDiv">
    {{username}}
  </div>
  </body>
  <script type="application/javascript" src="js/vue.js"></script>
  <script type="text/javascript">
    var vue = new Vue({
      el:"#myDiv",
      data: {
        username:"你好vue"
      }
    });
  </script>
</html>

/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.52
 * Generated at: 2020-05-14 11:34:12 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class write_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("    \r\n");

String name = (String) session.getAttribute("uname");
if (name==null){response.sendRedirect("/Blog_Project/login.jsp");}

      out.write("\r\n");
      out.write("\r\n");

    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("<base href=\" ");
      out.print(basePath);
      out.write("\">\r\n");
      out.write("  <meta charset=\"utf-8\">\r\n");
      out.write("  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\r\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\">\r\n");
      out.write("  <title>创作工作室</title>\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"res/layui/css/layui.css\"   media=\"all\">\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"bootstrap/css/bootstrap.min.css\">\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"bootstrap/css/nav_no_content.css\">\r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<body class=\"layui-layout-body\">\r\n");
      out.write("\r\n");
      out.write("<nav class=\"navbar navbar-default navbar-fixed-top\" role=\"navigation\"  >\r\n");
      out.write("\r\n");
      out.write("    <div class=\"container\" >\r\n");
      out.write("        <!--小屏幕的导航按钮和logo-->\r\n");
      out.write("        <div class=\"navbar-header\">\r\n");
      out.write("        <button type=\"button\" class=\"navbar-toggle\"  data-toggle=\"collapse\"   data-target=\"#nav-all\">  <!-- 为了小窗口下点击按钮出现选项-->\r\n");
      out.write("            <span class=\"icon-bar\"></span>\r\n");
      out.write("            <span class=\"icon-bar\"></span>\r\n");
      out.write("            <span class=\"icon-bar\"></span>\r\n");
      out.write("        </button>\r\n");
      out.write("\r\n");
      out.write("        <!--小屏幕的导航按钮和logo-->\r\n");
      out.write("        <a href=\"index.html\" class=\"navbar-brand\">写博客</a>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!--导航-->\r\n");
      out.write("        <div class=\"collapse navbar-collapse\" id=\"nav-all\">\r\n");
      out.write("            <ul class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("            <li><img src=\"res/img/header.jpg\" height=\"40px\" width=\"40px\"></li>\r\n");
      out.write("             \r\n");
      out.write("            <li><a href=\"#\">");
      out.print(name );
      out.write("的博客</a></li>\r\n");
      out.write("               \r\n");
      out.write("                <li> <a href=\"pressSuccess.jsp\">查看刚刚发表博客</a></li>\r\n");
      out.write("                <li><a href=\"#\">个人中心</a></li>\r\n");
      out.write("                <li><a href=\"invalidate.jsp\">注销</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</nav>\r\n");
      out.write("  \r\n");
      out.write("  <div id=\"content\" >\r\n");
      out.write("  \t<form action=\"/Blog_Project/com/blog/servlet/Article_in_servlet\" >\r\n");
      out.write("  \t\r\n");
      out.write("  \t\t\r\n");
      out.write("    \t\t<legend>添加文章</legend>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<input type=text  placeholder=\"文章标题\"  name=\"article_title\"><br>\r\n");
      out.write("\t\t<br>\r\n");
      out.write("\t\t<div class=\"layui-form-item layui-form-text\"  >\r\n");
      out.write("   \t\t\t <div class=\"layui-input-block\" style=\"margin-left: 0px;\">\r\n");
      out.write("     \t\t <textarea name=\"t1\"  placeholder=\"请输入内容\" class=\"layui-textarea\"></textarea>\r\n");
      out.write("   \t\t \t </div>\r\n");
      out.write("  \t\t</div>\r\n");
      out.write("\r\n");
      out.write("    \t\r\n");
      out.write("    \t<input type=\"submit\" value=\"发表文章\" />\r\n");
      out.write("\r\n");
      out.write("\t</form>\r\n");
      out.write("  </div>\r\n");
      out.write("  \r\n");
      out.write(" <!--底部-->\r\n");
      out.write("<nav class=\"navbar navbar-default navbar-fixed-bottom\">\r\n");
      out.write("    <div style=\"text-align:center\">\r\n");
      out.write("        版权所有 CopyRight  <br>京备字号  邮编 1000044\r\n");
      out.write("    </div>\r\n");
      out.write("</nav>\r\n");
      out.write("\r\n");
      out.write("<script src=\"https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js\"></script><!-- 引入jquery文件 因为bootstrap依赖它-->\r\n");
      out.write("<script src=\"bootstrap/js/bootstrap.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

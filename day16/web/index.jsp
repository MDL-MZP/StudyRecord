<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="500.jsp" %>

<%-- 3. 引入标签库 prefix 自定义前缀  uri导入路径 --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

    <% // 2. page 指令
        List list = new ArrayList();
//        如果没有上面那个是会出现500异常的 。errorPage="500.jsp" ：跳转到500.jsp资源
        int i = 3/0;
    %>



 <%--  1. 以下的java代码都是定义在类似service的方法中 --%>
  <%
//    System.out.println("hello jsp");
////    内置对象，request、out
//    String contextPath = request.getContextPath();
//    out.print(contextPath);
  %>
 <h1>hi !  jsp </h1>
  <%
//    response.getWriter().write("response语句在后面，能否先于 out 执行呢？能 !");
  %>



  </body>
</html>

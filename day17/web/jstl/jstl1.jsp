<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>if标签</title>
</head>
<body>
<%--
    c:if标签
    接收boolean表达式,结合EL表达式，必须有test
--%>
    <c:if test="true">
        <h1>我是真...</h1>
    </c:if>
<br>
    <%
        List list = new ArrayList();
        list.add("aaa");
        request.setAttribute("list",list);

        request.setAttribute("number",3);
    %>
    <c:if test="${not empty list}">
        遍历集合
    </c:if>
<br>
    <c:if test="${number % 2 != 0}">
        ${number}为奇数
    </c:if>
    <c:if test="${number % 2 == 0}">
        ${number}为偶数
    </c:if>
</body>
</html>

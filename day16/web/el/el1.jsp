<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%-- 设置 page isELIgnored="true" ： 忽略整个页面的EL表达式--%>
    ${3 > 4}
 <%--  "\" 忽略当前EL --%>
    \${3 > 4}
<hr>
    <h3>算术运算符</h3>
    ${3+4}<br>
    ${3/4}<br>
    ${3 div 4}<br>
    ${3 % 4}<br>
    ${3 mod 4}<br>
<hr>
    <h3>比较运算符</h3>
    ${3==4}<br>
    ${3!=4}<br>
    ${3 > 4}<br>
    ${3 < 4}<br>
<hr>
    <h3>逻辑运算符</h3>
    ${3 > 4 && 3 < 4}<br>
    ${3 > 4 and 3 < 4}<br>
<hr>
    <h3>empty运算符</h3>
    <%
        String str = "";
        request.setAttribute("str",str);

        List list = new ArrayList();
        request.setAttribute("list",list);
    %>
    ${empty str}
    ${not empty str}
    ${empty list}
</body>
</html>

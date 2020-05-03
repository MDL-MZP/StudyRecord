<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>foreach标签</title>
</head>
<body>

    <%
//        foreach，用于完成重复操作for、遍历容器foreach


    %>
<%--
for：
    属性:
        begin       开始值
        end         结束值
        var         临时变量
        step        步长
        varStatus   循环状态对象
             index 容器中元素的索引，从0开始
             count 遍历次数，从1开始
foreach：
    属性：
        items       容器对象
        var         容器中元素的临时变量
        varStatus   循环状态对象
             index 容器中元素的索引，从0开始
             count 遍历次数，从1开始
--%>
    <%--  for(i=1;i<=10;i++)  --%>
    <c:forEach begin="1" end="10" var="i" step="1" varStatus="s">
        ${i} ${s.index} ${s.count} <br>
    </c:forEach>
<hr>
    <c:forEach begin="1" end="10" var="i" step="2" varStatus="s">
        ${i} ${s.index} ${s.count}<br>
    </c:forEach>
<hr>
    <%
        List list = new ArrayList();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        request.setAttribute("list",list);
    %>
    <%--  for(var str : list)  --%>
    <c:forEach items="${list}" var="str" varStatus="s">
        ${s.index} ${s.count} ${str}<br>
    </c:forEach>



</body>
</html>

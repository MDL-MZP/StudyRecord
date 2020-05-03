<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>服务器正忙。。。。</h1>
    <%
//     标注了 isErrorPage="true", 才能调用exception内置对象获取错误信息
        String message = exception.getMessage();
        out.print(message);
    %>
</body>
</html>

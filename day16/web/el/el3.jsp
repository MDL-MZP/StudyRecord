<%@ page import="domain.User" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el获取数据</title>
</head>
<body>

    <%
        User user = new User();
        user.setName("张三");
        user.setAge(23);
        user.setBirthday(new Date());
        request.setAttribute("u",user);

        List list = new ArrayList();
        list.add("aaa");
        list.add("bbb");
        list.add(user);
        request.setAttribute("list",list);

        Map map = new HashMap();
        map.put("name","李四");
        map.put("gender","男");
        map.put("user",user);
        request.setAttribute("map",map);
    %>
<h3>el获取对象中的值</h3>
    <%--  src下的目录  --%>
    ${requestScope.u}<br>
    <%--  通过对象的属性来获取 ：Setter和Getter去掉set、get,首字母小写的部分 --%>
    ${requestScope.u.name}<br>
    ${requestScope.u.age}<br>
    ${requestScope.u.birthday}<br>
    <%-- 想换格式？利用 属性 这个玩意, 没有birStr ? 自己建！！ --%>
    ${u.birStr}<br>

    <h3>el获取List值</h3>
    ${list}<br>
    ${list[0]}<br>
    ${list[1]}<br>
    ${list[10]}<br>
    ${"上面集合下标越界显示空字符串"}<br>
    ${list[2].name}

    <h3>el获取Map值</h3>
    ${map.gender}<br>
    ${map["gender"]}<br>
    ${map.user.name}<br>
</body>
</html>

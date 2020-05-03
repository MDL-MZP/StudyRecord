<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/5/2
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.net.URLEncoder" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%

        // 1. 获取所有Cookie
        Cookie[] cookies = request.getCookies();
        // 代表没有Cookie为lastTime
        boolean flag = false;
        // 2. 遍历cs数组
        if(cookies != null && cookies.length > 0){
            for (Cookie cookie : cookies) {
                // 3. 获取cookie名称
                String name = cookie.getName();
                // 4. 判断名称是否是lastTime
                if("lastTime".equals(name)){
                    // 有该Cookie，不是第一次访问
                    flag = true;

                    // 获取Cookie的value,即上次访问时间
                    String value = cookie.getValue();
                    value = URLDecoder.decode(value,"utf-8");

                    // 新的上次访问时间：获取当前时间字符串，重新设置该Cookie值，或者新建一个同名Cookie，重新发送Cookie
                        /*
                            新建，与 在原来的Cookie上设置值的区别：
                                下面会用到Cookie的存活时间，如果是设置，那么每一次重新访问都会将cookie的存活时间  重新更新
                                                            如果是新建，那么每一个lastTime存活时间一样。同名的Cookie值被覆盖，但本身还在（猜）
                        */
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    String str_date = sdf.format(date);

                    // URL编码
                    System.out.println("编码前："+ str_date);
                    str_date = URLEncoder.encode(str_date,"utf-8");
                    System.out.println("编码后："+ str_date);

                    // 设置Cookie的value
                    cookie.setValue(str_date);
                    // 获取Cookie的value,本次访问时间，作为下一次访问的上一次时间
//                    String value2 = cookie.getValue();

                    // 设置cookie存活时间
                    cookie.setMaxAge(60);
                    response.addCookie(cookie);

                    // URL解码
//                    System.out.println("解码前:"+value2);
//                    value2 = URLDecoder.decode(value2,"utf-8");
//                    System.out.println("解码后:"+value2);
                    %>
                    <%-- 截断下面这行 --%>
                    <%--out.write("<h1>欢迎回来，您上次访问时间为:"+ value + "</h1>");--%>
                    <h1>欢迎回来，您上次访问时间为:<%= value %></h1>"
            <%
                    break;
                }
            }
        }
        if(cookies == null || cookies.length == 0 || !flag){
            // 第一次访问
            // 设置Cookie的value
            // 获取当前时间字符串，重新设置Cookie值，重新发送cookie
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String str_date = sdf.format(date);

            // URL编码
            System.out.println("编码前："+ str_date);
            str_date = URLEncoder.encode(str_date,"utf-8");
            System.out.println("编码后："+ str_date);

            Cookie cookie = new Cookie("lastTime",str_date);
            // 设置cookie存活时间
            cookie.setMaxAge(60);
            response.addCookie(cookie);
            %>
             <%-- 截断下面这行 --%>
            <%--out.write("<h1>您好，欢迎您首次访问</h1>");--%>
            <h1>您好，欢迎您首次访问</h1>
     <%
        }
    %>
    <input type="text">
</body>
</html>

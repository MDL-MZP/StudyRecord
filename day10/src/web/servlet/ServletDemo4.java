package web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 注解配置中，urlpattern是String[]
 */
//@WebServlet({"/d4","/dd4","/ddd4"})
//@WebServlet("/user/demo4")
    // 1. *是“任意”通配符
//@WebServlet("/user/*")
    // 2. *的优先级最低，同名的情况下，先执行别的，找不到了才轮到*
//@WebServlet("/*")
    // 3. 自定义拓展名do，强制访问时加上后缀
@WebServlet("*.do")
public class ServletDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("demo4....");
    }
}

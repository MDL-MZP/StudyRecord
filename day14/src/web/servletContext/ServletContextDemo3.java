package web.servletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servletContextDemo3")
public class ServletContextDemo3 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
            ServletContext的功能:
            2. 域对象：共享数据
                1. setAttribute(String name,Object value)
                2. getAttribute(String name)
                3. removeAttribute(String name)
		    * ServletContext对象范围：所有用户所有请求的数据
        */
        // 2. 通过HTTPServlet获取
        ServletContext context = this.getServletContext();
        System.out.println("Demo3设置数据");
        // 3. 设置数据
        context.setAttribute("msg","haha");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}

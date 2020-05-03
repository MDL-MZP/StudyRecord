package web.servletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servletContextDemo1")
public class ServletContextDemo1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
            ServletContext的对象的获取:
            1. 通过request对象获取
                request.getServletContext();
            2. 通过HttpServlet获取
                this.getServletContext();
        */

        // 1. 通过request对象获取
        ServletContext context1 = req.getServletContext();
        // 2. 通过HttpServlet获取
        ServletContext context2 = this.getServletContext();
        // 同一个ServletContext
        System.out.println(context1);
        System.out.println(context2);
        System.out.println(context1 == context2);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}

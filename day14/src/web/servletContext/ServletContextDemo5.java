package web.servletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet("/servletContextDemo5")
public class ServletContextDemo5 extends HttpServlet {
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
        // 获取文件的服务器路径，资源文件位置：src下（a.txt）、web下（b.txt）、WEB-INF下（c.txt）
            // web目录下资源访问   “/”+文件
        String realPath = context.getRealPath("/b.txt");
        File file = new File(realPath);
        System.out.println(realPath);
//     E:\develop\theme\JavaWeb\StudyRecord\day8\out\artifacts\day14_war_exploded\b.txt

        // WEB-INF目录下资源访问   “/WEB-INF/”+文件
        String realPath1 = context.getRealPath("/WEB-INF/c.txt");
        System.out.println(realPath1);
//     E:\develop\theme\JavaWeb\StudyRecord\day8\out\artifacts\day14_war_exploded\WEB-INF\c.txt

        // src目录下资源访问   “/WEB_INF/classes/”+文件
        String realPath2 = context.getRealPath("/WEB_INF/classes/a.txt");
        System.out.println(realPath2);
//     E:\develop\theme\JavaWeb\StudyRecord\day8\out\artifacts\day14_war_exploded\WEB_INF\classes\a.txt
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}

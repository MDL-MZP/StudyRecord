package web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 *   重定向 ：状态码302
 */
@WebServlet("/responseDemo1")
public class ResponseDemo1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("responseDemo1被访问了。。。");

//        // 访问 responseDemo1，自动跳转到responseDemo2
//        // 1. 设置状态码302
//        response.setStatus(302);
//        // 2. 设置响应头location
//        response.setHeader("location","/day13/responseDemo2");

//        // 试图共享两次请求的 request域
//        request.setAttribute("msg","response");

//        // 简单的重定向方法, 一步顶两，这里重定位需要写到虚拟目录！！（虚拟目录有点死）
//        response.sendRedirect("/day13/responseDemo2");

        //不写死的虚拟目录
            /*    动态获取虚拟目录    */
        String contextPath = request.getContextPath();
        response.sendRedirect(contextPath + "/responseDemo2");

//        // 重定位可访问其他服务器的资源
//        response.sendRedirect("https://www.baidu.com");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}

package web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RequestDemo4")
public class RequestDemo4 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 演示获取请求头数据：referer
        String referer = request.getHeader("referer");
        System.out.println(referer);

        // 防盗链,来自正确的虚拟目录
        if(referer.contains("/day10")){
            //System.out.println("正常");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("正常来");
        }else{
            //System.out.println("你想干什么？");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("你想干什么？");
        }
    }
}

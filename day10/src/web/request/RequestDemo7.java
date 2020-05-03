package web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet("/RequestDemo7")
public class RequestDemo7 extends HttpServlet {
   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       /*
       1. 若用getHeader(String name) 则post不会出现问题
          用getParameter(String name) post会乱码
       */
       // 解决：
       request.setCharacterEncoding("utf-8");
        // 获取请求参数username
       String username = request.getParameter("username");
       System.out.println(username);
   }

    /**
     * 弱化了 post和get的区别
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}

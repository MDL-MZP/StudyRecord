package session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/SessionDemo4")
public class SessionDemo4 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 使用session共享数据,这里跟cookie差不多。Session的实现是依赖于Cookie的。

        // 1.获取session
        HttpSession session = request.getSession();
        System.out.println(session);

//        org.apache.catalina.session.StandardSessionFacade@3b81db83
//        org.apache.catalina.session.StandardSessionFacade@684ad8e4
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

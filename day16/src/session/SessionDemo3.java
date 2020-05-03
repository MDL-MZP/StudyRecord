package session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/SessionDemo3")
public class SessionDemo3 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 使用session共享数据,这里跟cookie差不多。Session的实现是依赖于Cookie的。

        // 1.获取session
        HttpSession session = request.getSession();
        System.out.println(session);
        // 期望客户端关闭后，sessoin是同一个
        Cookie c = new Cookie("JSESSIONID",session.getId());
        c.setMaxAge(60);
        response.addCookie(c);


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

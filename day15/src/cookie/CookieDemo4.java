package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  Cookie 快速入门
 */
@WebServlet("/cookieDemo4")
public class CookieDemo4 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 创建Cookie对象
        Cookie c1 = new Cookie("msg","setMaxAge");
        // 2. 设置cookie的存活时间,将cookie持久化到硬盘，30s后自动删除cookie文件
        c1.setMaxAge(30);
        // 负数：关闭浏览器则删除cookie
//        c1.setMaxAge(-1);
        // 0 ：立即删除cookie
//        c1.setMaxAge(0);

        // 3. 发送Cookie
        response.addCookie(c1);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

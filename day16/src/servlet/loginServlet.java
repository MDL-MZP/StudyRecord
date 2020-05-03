package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.设置request编码
        request.setCharacterEncoding("utf-8");
        // 2.获取参数（为简便本次不做数据库连接，所以本次程序写死，正常要获取 Map 集合参数）
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkCode = request.getParameter("checkCode");
        // 3.先获取生成的验证码
        HttpSession session = request.getSession();
        String checkCode_session = (String)session.getAttribute("checkCode_session");
        //删除session中存储的验证码
        session.removeAttribute("checkCode_session");
        // 4.判断验证码是否正确
        if(checkCode_session != null && checkCode_session.equalsIgnoreCase(checkCode)){
            // 忽略大小写比较,验证码正确
            // 判断用户名和密码是否一致, 正常要查询数据库
            if("zhangsan".equals(username) && "123".equals(password)){
                // 登录成功
                // 存储用户信息,正常是存整个user对象
                session.setAttribute("user",username);
                // 重定向
                response.sendRedirect(request.getContextPath() + "/success.jsp");
            }else{
                // 登录失败
                request.setAttribute("login_error","用户名或密码错误");
                // 转发到登录页面
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }
        }else{
            // 验证码不一致
            // 存储提示信息到request
            request.setAttribute("cc_error","验证码错误");
            // 转发到登录页面
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

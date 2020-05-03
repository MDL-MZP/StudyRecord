package web.request;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RequestDemo8")
public class RequestDemo8 extends HttpServlet {
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       System.out.println("demo8888被访问了");
       //转发到demo9资源
//       RequestDispatcher requestDispatcher = request.getRequestDispatcher("/RequestDemo9");
//       requestDispatcher.forward(request,response);
       // 存储数据到request域中
       request.setAttribute("msg","hello");
       request.getRequestDispatcher("/RequestDemo9").forward(request,response);
   }

    /**
     * 弱化了 post和get的区别
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 资源默认是get
        System.out.println("是get");
        this.doPost(request,response);
    }
}

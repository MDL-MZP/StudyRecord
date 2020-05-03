package web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/responseDemo4")
public class ResponseDemo4 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // 获取流对象前，流的默认编码：ISO-8859-1，设置为GBK，以便解析中文
//        response.setCharacterEncoding("GBK");

//        // 还是不合理，告诉浏览器，服务器发送的消息体数据的编码，建议浏览器使用该编码解码。这样最好
//        response.setHeader("content-type","text/html;charset=utf-8");

        // 简化：简单的形式设置编码
        response.setContentType("text/html;charset=utf-8");

        // 1. 获取字符输出流
        PrintWriter pw = response.getWriter();
        // 2. 输出数据
        pw.write("<h1>hello response</h1>");

        pw.write("你好啊！responseDemo4");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}

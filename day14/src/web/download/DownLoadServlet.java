package web.download;

import web.utils.DownLoadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/downLoadServlet")
public class DownLoadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 获取请求参数
        String filename = request.getParameter("filename");
        // 2. 使用字节输入流 加载 文件进内存
            // 2.1 找到文件服务器路径
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/img/" + filename);
            // 2.2 用字节流关联
        FileInputStream fis = new FileInputStream(realPath);
        // 3. 设置response的响应头
            //3.1 设置响应头类型：content-type
        String mimeType = servletContext.getMimeType(filename);
        response.setHeader("content-type",mimeType);
            //3.2 设置响应头打开方式：content-disposition，下载模式attachment
                //解决中文文件名问题
                    //1.获取user-agent请求头，得到浏览器的信息（不同浏览器会对中文编码不一样）
        String agent = request.getHeader("user-agent");
                    //2.使用工具类方法编码文件名
        filename = DownLoadUtils.getFileName(agent, filename);
        /*   filename是弹出下载框后，显示的资源名字   */
        response.setHeader("content-disposition","attachment;filename="+filename);
        // 4. 将输入流的数据写入输出流中，拷贝
        ServletOutputStream sos = response.getOutputStream();
        byte[] buff = new byte[1024 * 8];
        int len = 0;
        while((len = fis.read(buff)) != -1){
            sos.write(buff,0,len);
        }
        fis.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}

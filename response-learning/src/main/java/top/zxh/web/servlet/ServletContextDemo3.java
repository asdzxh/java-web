package top.zxh.web.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Date:2023/3/2
 * Author：zxh
 * Description: ServletContext功能：获取MIME类型
 */
@WebServlet("/servletContextDemo3")
public class ServletContextDemo3 extends HttpServlet {
    /*
         ServletContext功能：
           1. 获取MIME类型：
            MIME类型:在互联网通信过程中定义的一种文件数据类型
            格式： 大类型/小类型   text/html		image/jpeg
            获取：String getMimeType(String file)
          2. 域对象：共享数据
          3. 获取文件的真实(服务器)路径
        */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = this.getServletContext();

        String filename = "/img/vite.jpg";

        //获取MIME类型
        String mimeType = servletContext.getMimeType(filename);
        System.out.println(mimeType);

    }
}

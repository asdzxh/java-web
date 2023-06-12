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
 * Description: ServletContext功能：获取文件服务器路径
 */
@WebServlet("/servletContextDemo4")
public class ServletContextDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = this.getServletContext();
        //webapp 目录下资源的访问
        String b = servletContext.getRealPath("/b.txt");
        System.out.println(b);

        //WEB-INF目录下的资源访问
        String c = servletContext.getRealPath("/WEB-INF/c.txt");
        System.out.println(c);

        //src的resources目录下的资源访问
        String a = servletContext.getRealPath("/WEB-INF/class/a.txt");
        System.out.println(a);



    }
}

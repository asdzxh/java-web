package top.zxh.web.servlet.ServletContext2;

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
 * Description: ServletContext 对象的使用
 */
@WebServlet("/servletContextDemo2")
public class ServletContextDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //使用ServletContext 域对象共享数据：只要Servlet 不注销，都有效
        ServletContext servletContext = this.getServletContext();
        servletContext.setAttribute("msg","hello world");
        //重定向
        response.setStatus(302);
        response.setHeader("location","/rs/msg");
    }
}

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
 * Description: ServletContext 对象的获取
 */
@WebServlet("/servletContextDemo1")
public class ServletContextDemo1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
         ServletContext对象获取：
           1. 通过request对象获取 request.getServletContext();
           2. 通过HttpServlet获取 this.getServletContext();
         */

        //1. 通过request对象获取
        ServletContext context1 = request.getServletContext();
        //2. 通过HttpServlet获取
        ServletContext context2 = this.getServletContext();
        System.out.println(context1);
        System.out.println(context2);

        //true
        System.out.println(context1 == context2);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

package top.zxh.web.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/ResponseDemo1")
public class ResponseDemo1 extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //访问ResponseDemo1会跳转到ResponseDemo2
        //设置状态码为重定向
        response.setStatus(302);

        //重定向会丢失request中的数据
        request.setAttribute("msg","hello world");

        //设置响应头location
//        response.setHeader("location","/ResponseDemo2");


        //动态获取虚拟目录
        String contextPath = request.getContextPath();
        System.out.println(contextPath);

        //简单的重定向方法
//        response.sendRedirect(contextPath+"/ResponseDemo2");
        //重定向可以跨境访问
//        response.sendRedirect("https://www.baidu.com");


        request.getRequestDispatcher("/forward").forward(request,response);

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }




}

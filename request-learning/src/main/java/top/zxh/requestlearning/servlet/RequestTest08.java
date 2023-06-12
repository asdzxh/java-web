package top.zxh.requestlearning.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Date:2023/2/28
 * Author：zxh
 * Description:请求转发
 */
/*
     通过 request 对象获取请求转发器对象
    RequestDispatcher getRequestDispatcher(String path)

     使用 RequestDispatcher 对象来进行转发
     forward(ServletRequest request, ServletResponse response);
 */
@WebServlet("/request08")
public class RequestTest08 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("test08被访问了...");
        //存储数据到request域中
        request.setAttribute("msg", "hello");
        //转发到request07资源
        request.getRequestDispatcher("/request07").forward(request, response);
        // 无法跨域转发
        //request.getRequestDispatcher("http://www.baidu.com").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

}

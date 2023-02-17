package top.zxh.web.com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ResponseDemo1")
public class ResponseDemo1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.printf("访问 ResponseDemo1");
        response.setStatus(302);//设置状态码302，重定向
        request.setAttribute("msg","hellow world"); //重定向会丢失request域中的数据
        response.setHeader("location","/responseDemo2");//设置响应头
        String contextPath = request.getContextPath();  //动态获取虚拟目录
        System.out.printf(contextPath);
        response.sendRedirect(contextPath+"/responseDemo2");//客户端重定向

        //重定向可以跨域访问
        //response.sendRedirect("https://www.baidu.com");

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.doGet(req,resp);
    }
}

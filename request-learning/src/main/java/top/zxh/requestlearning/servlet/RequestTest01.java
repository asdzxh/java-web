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
 * Description: request各种方法
 */
@WebServlet("/request01")
public class RequestTest01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          /*
        1. 获取请求方式 ：GET
           String getMethod()
        2. 获取虚拟目录：/oa
            String getContextPath()
        3. 获取Servlet路径: /request
           String getServletPath()
        4. 获取get方式请求参数：name=zhangsan
           String getQueryString()
        5. 获取请求URI：/oa/request
           String getRequestURI():		/day02/requestDemo1
           StringBuffer getRequestURL()  :http://localhost:8080/day02/requestDemo1
        6. 获取协议及版本：HTTP/1.1
           String getProtocol()
        7. 获取客户机的IP地址：
           String getRemoteAddr()
         */
        //获取请求方式
        String method = request.getMethod();
        System.out.println("请求方式为： "+method);

        //获取虚拟目录
        String contextPath = request.getContextPath();
        System.out.println("虚拟目录为："+contextPath);

        //3. 获取Servlet路径:
        String servletPath = request.getServletPath();
        System.out.println(servletPath);

        //4. 获取get方式请求参数：比如客户端发送
        //http://localhost/test.do?a=b&c=d&e=f
        //通过request.getQueryString()得到的是
        //a=b&c=d&e=f
        String queryString = request.getQueryString();
        System.out.println(queryString);

        //5. 获取请求的资源路径
        String requestUri = request.getRequestURI();
        System.out.println(requestUri);

        //获取请求的同意资源定位符（绝对路径）
        StringBuffer requestUrl = request.getRequestURL();
        System.out.println(requestUrl);

        //6. 获取协议及版本：HTTP/1.1
        String protocol = request.getProtocol();
        System.out.println(protocol);

        //7. 获取客户机的IP地址：
        String remoteAddress = request.getRemoteAddr();
        System.out.println(remoteAddress);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}

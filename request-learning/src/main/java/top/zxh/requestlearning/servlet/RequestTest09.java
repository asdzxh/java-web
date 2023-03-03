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
 * Description:共享数据
 */

@WebServlet("/request09")
/*
    1. 共享数据
    ●  域对象：一个有作用范围的对象，可以在范围内共享数据
    ●  request域：代表一次请求的范围，一般用于请求转发的多个资源中共享数据
    2. 方法
    ●  void setAttribute(String name,Object obj) : 存储数据
    ●  Object getAttitude(String name) : 通过键获取值
    ●  void removeAttribute(String name) : 通过键移除键值对
 */
public class RequestTest09 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从request域中获取数据
        Object msg = request.getAttribute("msg");
        System.out.println(msg);
        System.out.println("test09被访问了。。。");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

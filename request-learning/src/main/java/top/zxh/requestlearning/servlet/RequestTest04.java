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
 * Description: referer请求头作用
 */

/*
        Referer请求头包含了当前请求页面的来源页面的地址，
        即表示当前页面是通过此来源页面里的链接进入的。
 */
@WebServlet("/request04")
public class RequestTest04 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //请求referer请求头数据
        String referer = request.getHeader("referer");
        System.out.println(referer);

        //防盗链
        if (referer!=null){
            //正常访问
            if (referer.contains("/request")){
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("来看电影");
            }
            //盗链
            else {
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("去看电视");
            }
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

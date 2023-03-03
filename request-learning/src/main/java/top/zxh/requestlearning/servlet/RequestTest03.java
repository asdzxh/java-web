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
 * Description: 根据请求头 user-agent数据判断是哪个浏览器
 */
@WebServlet("/request03")
public class RequestTest03 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求头数据:user-agent
        String agent = request.getHeader("user-agent");
        //判断agent的浏览器版本
        if (agent.contains("Chrome")) {
            System.out.println("谷歌浏览器...");
        } else if (agent.contains("Firefox")) {
            System.out.println("火狐浏览器...");
        }
    }


}

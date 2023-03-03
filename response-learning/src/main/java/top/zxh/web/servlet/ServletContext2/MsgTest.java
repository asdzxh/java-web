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
 * Description: ServletContextDemo2的测试
 */

@WebServlet("/rs/msg")
public class MsgTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = this.getServletContext();
        //可以取到数据
        String msg = String.valueOf(servletContext.getAttribute("msg"));
        System.out.println(msg);


    }
}

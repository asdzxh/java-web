package top.zxh.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Date:2023/2/28
 * Author：zxh
 * Description:
 */
@WebServlet("/s")
public class ServletTest extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("正在初始化");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("正在使用");
    }

    @Override
    public void destroy() {
        System.out.println("程序已销毁");
    }


}

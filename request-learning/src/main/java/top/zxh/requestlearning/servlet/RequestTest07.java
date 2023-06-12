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
 * Description: 设置请求的字符集
 */
/*
详情见RequestTest06
 */

@WebServlet("/request07")
public class RequestTest07 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
    }
}

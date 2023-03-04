package top.zxh.web.login.controller;

import top.zxh.web.login.entity.User;
import top.zxh.web.login.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Date:2023/3/4
 * Author：zxh
 * Description: 检测用户名是否可用
 */
@WebServlet("/check")
public class CheckServlet extends HttpServlet {
    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        boolean flag = userService.checkUser(username);
        response.getWriter().write(String.valueOf(flag));

    }
}

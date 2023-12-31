package top.zxh.web.login.controller;

import top.zxh.web.login.service.UserService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Date:2023/3/4
 * Author：zxh
 * Description: 注册
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserService userService = new UserService();
        int register = userService.Register(username, password);
        System.out.println(register);
        ServletContext servletContext = request.getServletContext();
        String contextPath = servletContext.getContextPath();
        response.sendRedirect(contextPath+"/login/success.html");

    }
}

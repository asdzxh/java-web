package top.zxh.web.login.controller;

import top.zxh.web.login.entity.User;
import top.zxh.web.login.service.UserService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Date:2023/3/3
 * Author：zxh
 * Description: 登录逻辑处理
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset:utf-8");
        // 1. 获得用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 2. 调用service登录
        User user = userService.login(username, password);
        System.out.println(user);

        // 3. 判断
        if (user !=null){
            //登录成功
            //将用户信息记在Session中
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            ServletContext servletContext = request.getServletContext();
            String contextPath = servletContext.getContextPath();
            Cookie cookie = new Cookie("username",username);
            Cookie cookie2 = new Cookie("password",password);
            response.addCookie(cookie);
            response.addCookie(cookie2);
            response.sendRedirect(contextPath+"/index.jsp");

        }else {
            //登录失败
            response.getWriter().write("<script>alert('用户名或密码错误');location='/login.html';</script>");
        }



    }
}

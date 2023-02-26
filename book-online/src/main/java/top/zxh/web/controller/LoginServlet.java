package top.zxh.web.controller;



import top.zxh.web.entity.User;
import top.zxh.web.service.UserService;
import top.zxh.web.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService=new UserServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String account = req.getParameter("account");
        String password = req.getParameter("password");
        User user = userService.signIn(account, password);
        if (user!=null){
            HttpSession session=req.getSession();
            session.setAttribute("user",user);
            resp.sendRedirect("/web4/index");
        }else {
            resp.setContentType("text/html;charset=utf-8");
            PrintWriter printWriter=resp.getWriter();
            printWriter.print("<script>alert('账号或密码错误');location.href='/web4/';</script>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}

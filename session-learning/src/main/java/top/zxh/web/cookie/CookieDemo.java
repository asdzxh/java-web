package top.zxh.web.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;


@WebServlet(value = "/getCookie")
public class CookieDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uuid = UUID.randomUUID().toString();
        //UUID.randomUUID().toString()产生一个32位的随机字符串
        Cookie cookie = new Cookie("token", uuid);
        Cookie cookie2 = new Cookie("username", "zxh");
        response.addCookie(cookie);
        response.addCookie(cookie2);
        response.getWriter().println(uuid);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

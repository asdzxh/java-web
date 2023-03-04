package top.zxh.web.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Date:2023/3/3
 * Author：zxh
 * Description: Cookie 的发送
 */
@WebServlet("/cookieDemo2")
public class CookieDemo2 extends HttpServlet {
    /*创建 Cookie 对象，并设置数据
    Cookie cookie = new Cookie("key","value");

    发送 Cookie 到客户端：使用 response 对象
    response.addCookie(cookie);

    设置 Cookie 存活时间(单位为秒)
     setMaxAge(int seconds)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.创建Cookie对象
        Cookie cookie = new Cookie("username", "zs");
        //设置存活时间：1周7天
        //易阅读，需程序计算
        cookie.setMaxAge(60*60*24*7);
        //不易阅读（可以使用注释来弥补），程序少进行一次计算
        //cookie.setMaxAge(604800)
        //2.通过response发送Cookie
        response.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

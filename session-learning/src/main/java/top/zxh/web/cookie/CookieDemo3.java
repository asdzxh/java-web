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
 * Description: 获取Cookie
 */
@WebServlet("/cookieDemo3")
public class CookieDemo3 extends HttpServlet {
    /*
    获取客户端携带的所有 Cookie，使用 request 对象
    Cookie[] cookies = request.getCookies();

    遍历数组，获取每一个 Cookie 对象
    使用 Cookie 对象方法获取数据
    cookie.getName();
    cookie.getValue();
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 获取Cookie数组
        Cookie[] cookies = request.getCookies();
        //2. 遍历数组
        for (Cookie cookie : cookies) {
            //3. 获取数据
            String name = cookie.getName();
            if ("username".equals(name)) {
                String value = cookie.getValue();
                System.out.println(name + ":" + value);
                break;
            }
    }


}}

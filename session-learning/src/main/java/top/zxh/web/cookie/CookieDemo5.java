package top.zxh.web.cookie;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

/**
 * Date:2023/3/3
 * Author：zxh
 * Description:
 */
@WebServlet(urlPatterns = "/cookieDemo5")
@Slf4j
public class CookieDemo5 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String value = (String) request.getAttribute("name");

        value = URLDecoder.decode(value, StandardCharsets.UTF_8);
        log.info(value);
        response.setContentType("text/plain;charset=utf-8");
        response.getWriter().write(value);
        response.getWriter().close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}

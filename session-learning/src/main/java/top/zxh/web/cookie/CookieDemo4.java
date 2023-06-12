package top.zxh.web.cookie;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * Date:2023/3/3
 * Author：zxh
 * Description: 对中文进行 URL 编码
 */
@WebServlet(urlPatterns = "/cookieDemo4")
@Slf4j
public class CookieDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String value = "你好";
        value = URLEncoder.encode(value, StandardCharsets.UTF_8);
        log.info(value);
        request.setAttribute("name", value);
        request.getRequestDispatcher("/cookieDemo5").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}

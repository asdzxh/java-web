package top.zxh.web.com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/responsedemo3")
public class ResponseDemo3 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setHeader("content-type","text/html;charset=utf-8");

        PrintWriter pw = response.getWriter();
        pw.write("<h1>Hellow reponse</h1>");
        pw.write("你好 response");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doPost(req,resp);
    }
}

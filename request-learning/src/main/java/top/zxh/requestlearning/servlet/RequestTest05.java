package top.zxh.requestlearning.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Date:2023/2/28
 * Author：zxh
 * Description:获取请求体数据
 */
@WebServlet("/request05")
public class RequestTest05 extends HttpServlet {
    /*
    1. 获取流对象
    ●  BufferedReader getReader()：获取字符输入流，只能操作字符数据
    ●  ServletInputStream getInputStream()：获取字节输入流，可以操作所有类型数据
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求消息体--请求参数
        //1.获取字符流
        BufferedReader br = request.getReader();
        //2.读取数据
        String line;
        while ((line = br.readLine()) !=  null) {
            System.out.println(line);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}

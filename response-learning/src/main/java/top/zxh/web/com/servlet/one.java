package top.zxh.web.com.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/imgdownload")
public class one extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        //通过路径将图片以流的形式得到
        //通过相对路径得到绝对路径
            String path=this.getServletContext().getRealPath("/img/one.jpg");
        //有了路径可以得到输入流（图片，要用字节输出流）
        FileInputStream fis = new FileInputStream(path); //使用绝对路径将图片用输入流变成一个流  fis（图片）
        //用response创建一个输出流
        ServletOutputStream outputStream = response.getOutputStream();
        /*我们要将图片下载下来 */
        //得到要下载的文件名
        String fileName = path.substring(path.lastIndexOf("\\")+1);
        System.out.println(fileName);
        //设置文件的编码
        fileName = URLEncoder.encode(fileName,"UTF-8");
        //告知客户端要下载文件
        response.setHeader("content-disposition", "attachment;filename="+fileName);
        response.setHeader("content-type", "image/jpeg");

        //执行fileOutputStream的输出操作
        int len = 1;
        byte[] b = new byte[1024];
        while((len=fis.read(b))!=-1){
            outputStream.write(b, 0, len);
        }
        outputStream.close();
        fis.close();}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}


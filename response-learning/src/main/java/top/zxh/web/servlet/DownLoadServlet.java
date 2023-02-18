package top.zxh.web.servlet;

import top.zxh.web.util.DownLoadUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet(value = "/download")
public class DownLoadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html; charset=utf-8");
//        request.setCharacterEncoding("UTF-8");

        String file = request.getParameter("file");
//        System.out.println(file);

        //使用字节流加载文件进内存
        //找到文件服务器路径
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/img/" + file);
//        System.out.println(realPath);
        //用字节流关联
        FileInputStream fis = new FileInputStream(realPath);

        //设置response的响应头
        //设置响应头类型：content-type
        //获取mime类型
        String mimeType = servletContext.getMimeType(file);
        response.setHeader("content-type",mimeType);

        //设置响应头打开方式：content-disposition
        //解决中文文件名问题
        //获取user-agent请求头
        String header = request.getHeader("user-agent");

        //使用工具方法编码文件名
        file = DownLoadUtil.getFileName(header,file);

        //附件
        response.setHeader("content-disposition","attachment;filename="+file);
        //将输入流的数据写到输出流中
        ServletOutputStream outputStream = response.getOutputStream();
        byte[] buff = new byte[1024*8];
        int len;
        while ((len = fis.read(buff))!=-1){
            outputStream.write(buff,0,len);
        }
        fis.close();
    }


}

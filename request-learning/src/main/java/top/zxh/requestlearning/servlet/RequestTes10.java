package top.zxh.requestlearning.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Date:2023/2/28
 * Author：zxh
 * Description: ServletContext
 */
/*
    ServletContext 全局应用程序共享对象
    是一个域对象 对于一个WEBAPP来说，ServletContext对象只有一个,一个web应用对应一个ServletContext实例，


 */
@WebServlet("/request10")
public class RequestTes10 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = request.getServletContext();
        System.out.println(servletContext);
        //使用servletContext读取全局配置参数数据

        /*getServletContext().getInitParameter(name);//根据指定的参数名获取参数值
         getServletContext().getInitParameterNames();//获取所有参数名称列表*/
/**打印所有参数
 *


        //1.先获取所有全局配置参数名称
        Enumeration<String> enumeration =  servletContext.getInitParameterNames();
        //2.遍历迭代器
        while(enumeration.hasMoreElements()){
            //获取每个元素的参数名字
            String parameName = enumeration.nextElement();
            //根据参数名字获取参数值
            String parameValue = getServletContext().getInitParameter(parameName);
            //打印
            System.out.println(parameName+"="+parameValue);

        }*/

        //打印根路径 /oa
        String contextPath = servletContext.getContextPath();
        System.out.println("根路径： "+contextPath);

        String realPath = servletContext.getRealPath(contextPath);
        System.out.println("绝对路径"+realPath);




    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

}

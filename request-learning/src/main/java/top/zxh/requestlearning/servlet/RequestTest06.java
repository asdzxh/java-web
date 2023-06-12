package top.zxh.requestlearning.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

/**
 * Date:2023/2/28
 * Author：zxh
 * Description:获取请求参数
 */
@WebServlet("/request06")
/*
    - String getParameter(String name):根据参数名称获取参数值 username=zs&password=123

    - String[] getParameterValues(String name):根据参数名称获取参数值的数组

        hobby=xx&hobby=game

    - Enumeration<String> getParameterNames():获取所有请求的参数名称

    - Map<String,String[]> getParameterMap():获取所有参数的map集合
 */
public class RequestTest06 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //post 获取请求参数
        //根据参数名称获取参数值
        System.out.println("根据参数名称获取参数值");
        String username = request.getParameter("username");
        System.out.println(username);
        //根据参数名称获取参数值的数组
        String[] hobbies = request.getParameterValues("hobby");
        for (String hobby : hobbies) {
            System.out.println(hobby);
        }

        //获取所有请求的参数名称
        System.out.println("***********************");
        System.out.println("获取所有请求的参数名称");
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            System.out.println(name);
            String value = request.getParameter(name);
            System.out.println(value);
            System.out.println("----------------");
        }

        // 获取所有参数的map集合
        System.out.println("***********************");
        System.out.println("获取所有参数的map集合");
        Map<String, String[]> parameterMap = request.getParameterMap();
        //遍历
        Set<String> keySet = parameterMap.keySet();
        for (String name : keySet) {
            //获取键获取值
            String[] values = parameterMap.get(name);
            System.out.println(name);
            for (String value : values) {
                System.out.println(value);
            }
            System.out.println("-----------------");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get 获取请求参数
        //根据参数名称获取参数值
        String username = request.getParameter("username");
        System.out.println(username);
        this.doPost(request, response);
    }


}

package top.zxh.requestlearning.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Date:2023/2/28
 * Author：zxh
 * Description:获取所有请求头
 */
@WebServlet("/request02")
public class RequestTest02 extends HttpServlet {
    /*
     String getHeader(String name):通过请求头的名称获取请求头的值

    - Enumeration<String> getHeaderNames():获取所有的请求头名称

        Enumeration（枚举）接口的作用和Iterator类似，
        只提供了遍历Vector和HashTable类型集合元素的功能，不支持元素的移除操作。

         通过Enumeration的源码分析可得，Enumeration有两个方法：
            （1）boolean hasMoreElements();//是否还有元素，
            如果有返回true，否则表示至少含有一个元素
            （2）E nextElement();//如果Enumeration枚举对象还有元素，
            返回对象只能的下一个元素，
            否则抛出NoSuchElementException异常。

     */

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Enumeration<String> headerName = request.getHeaderNames();
        while (headerName.hasMoreElements()){
            String name = headerName.nextElement();
            //根据名称获取请求头的值
            String value = request.getHeader(name);
            System.out.println(name + "---" + value);
        }
    }
    //输出结果
//    host---localhost:9091
//    connection---keep-alive
//    sec-ch-ua---"Google Chrome";v="107", "Chromium";v="107", "Not=A?Brand";v="24"
//    sec-ch-ua-mobile---?0
//    sec-ch-ua-platform---"Windows"
//    upgrade-insecure-requests---1
//    user-agent---Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36
//    accept---text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9
//      sec-fetch-site---none
//      sec-fetch-mode---navigate
//      sec-fetch-user---?1
//      sec-fetch-dest---document
//      accept-encoding---gzip, deflate, br
//      accept-language---zh-CN,zh;q=0.9
//      cookie---JSESSIONID=EF53FAEAB19991C7856022F88B41EBC3; Idea-57bd4b65=c2353756-2cf7-4406-9341-9aedbb3b9773; JSESSIONID=9D3CA4039A38093BF85B1ACE301EFBE4
}

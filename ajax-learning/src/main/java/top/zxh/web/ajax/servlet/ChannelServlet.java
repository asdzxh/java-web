package top.zxh.web.ajax.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import top.zxh.web.ajax.entity.Channel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Date:2023/2/26
 * Author：zxh
 * Description:
 */

@WebServlet("/channel")
public class ChannelServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String level = request.getParameter("level");
        String parent = request.getParameter("parent");
        List<Channel> channelList = new ArrayList<>();
        if ("1".equals(level)){
            channelList.add(new Channel("ai","人工智能"));
            channelList.add(new Channel("web","前端开发"));


        }else if("2".equals(level)){
            if ("ai".equals(parent)) {
                channelList.add(new Channel("dl", "深度学习"));
                channelList.add(new Channel("cv", "计算机视觉"));
                channelList.add(new Channel("nlp", "自然语言处理"));
            }
            else if ("web".equals(parent)) {
                channelList.add(new Channel("html","超文本标记语言"));
                channelList.add(new Channel("css","级联样式表"));
                channelList.add(new Channel("js","JavaScript脚本语言"));
            }
        }
        //序列化对象
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(channelList);
        response.setContentType("application/json;charset = UTF-8");
        PrintWriter writer = response.getWriter();
        writer.println(json);
        writer.flush();
        writer.close();


    }
}

package top.zxh.web.servlet;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/b")
public class AA extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String level = req.getParameter("level");
        String parent = req.getParameter("parent");
        ArrayList<Channel> channelist = new ArrayList<>();
        if ("1".equals(level)){
            channelist.add(new Channel("ai","人工智能"));
            channelist.add(new Channel("web","前端开发"));
        }else if ("2".equals(level)){
            channelist.add(new Channel("dl","深度学习"));
            channelist.add(new Channel("cv","计算机视觉"));
            channelist.add(new Channel("nlp","自然语言处理"));
        }else if ("web".equals(parent)){
            channelist.add(new Channel("html","超文本标记语言"));
            channelist.add(new Channel("css","级联样式表"));
            channelist.add(new Channel("js","JavaScript脚本语言"));
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(channelist);

        System.out.println(json);
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.write(json);


    }
}

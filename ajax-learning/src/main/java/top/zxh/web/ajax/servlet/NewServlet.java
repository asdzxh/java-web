package top.zxh.web.ajax.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import top.zxh.web.ajax.entity.News;

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
 * Description:TODO
 */

@WebServlet("/news")
public class NewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        String type = request.getParameter("t");
        System.out.println(type);
        List<News> list = new ArrayList<>();

        if ("TIOPE".equals(type)) {
            list.add(new News(1, "TIOBE:2023年编程排行榜", "2023-1-1", "TIOBE", "..."));
            list.add(new News(2, "TIOBE:2023年编程排行榜", "2023-1-1", "TIOBE", "..."));
            list.add(new News(3, "TIOBE:2023年编程排行榜", "2023-1-1", "TIOBE", "..."));
            list.add(new News(4, "TIOBE:2023年编程排行榜", "2023-1-1", "TIOBE", "..."));

        } else if ("PYPL".equals(type)) {
            list.add(new News(5, "PYPL:2023年编程排行榜", "2023-1-1", "PYPL", "..."));
            list.add(new News(6, "PYPL:2023年编程排行榜", "2023-1-1", "PYPL", "..."));
            list.add(new News(7, "PYPL:2023年编程排行榜", "2023-1-1", "PYPL", "..."));
            list.add(new News(8, "PYPL:2023年编程排行榜", "2023-1-1", "PYPL", "..."));

        }
        //使用Jackson
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(list);
        response.setContentType("application/json;charset = UTF-8");
        PrintWriter writer = response.getWriter();
        writer.println(json);
        writer.flush();
        writer.close();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       this.doGet(req,resp);
    }
}

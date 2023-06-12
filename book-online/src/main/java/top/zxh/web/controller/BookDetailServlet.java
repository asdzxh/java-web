package top.zxh.web.controller;



import top.zxh.web.entity.Book;
import top.zxh.web.service.BookService;
import top.zxh.web.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/detail/*")
public class BookDetailServlet extends HttpServlet {
    private BookService bookService;

    @Override
    public void init() throws ServletException {
        bookService=new BookServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String requestPath = req.getRequestURI().trim();
        int position = requestPath.lastIndexOf("/");
        String id = requestPath.substring(position + 1);
        Book book=bookService.getBookId(Integer.parseInt(id));
        req.getRequestDispatcher("/book_detail.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

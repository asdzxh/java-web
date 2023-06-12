package top.zxh.web.service.impl;



import top.zxh.web.dao.BookDao;
import top.zxh.web.dao.impl.BookDaoImpl;
import top.zxh.web.entity.Book;
import top.zxh.web.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    private final BookDao bookDao =new BookDaoImpl();
    @Override
    public List<Book> getBooks() {
        return bookDao.selectAll();
    }

    @Override
    public Book getBookId(int id) {
        return bookDao.getBookId(id);
    }
}

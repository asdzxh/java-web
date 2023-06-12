package top.zxh.web.dao;



import top.zxh.web.entity.Book;

import java.util.List;

public interface BookDao {
    List<Book> selectAll();
    Book getBookId(int id);
}

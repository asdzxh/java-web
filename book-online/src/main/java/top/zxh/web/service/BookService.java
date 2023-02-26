package top.zxh.web.service;



import top.zxh.web.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getBooks();
    Book getBookId(int id);
}

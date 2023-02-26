package top.zxh.web.dao.impl;


import top.zxh.web.dao.BookDao;
import top.zxh.web.entity.Book;
import top.zxh.web.util.jdbcUtil;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class BookDaoImpl implements BookDao {
    private  final JdbcTemplate template=new JdbcTemplate(jdbcUtil.getDataSource());
    @Override
    public List<Book> selectAll() {
        try{
            String sql="select * from t_book order by id desc";
            return template.query(sql,new BeanPropertyRowMapper<>(Book.class));
        }catch (DataAccessException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Book getBookId(int id) {
        try{
            String sql="select * from t_book where id=?";
            return template.queryForObject(sql,new BeanPropertyRowMapper<>(Book.class),id);
        }catch (DataAccessException e){
            e.printStackTrace();;
            return  null;
        }
    }
}

package top.zxh.web.dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import top.zxh.web.dao.UserDao;
import top.zxh.web.entity.User;
import top.zxh.web.util.jdbcUtil;

/**
 * 用户Dao实现类
 */
public class UserDaoImpl  implements UserDao {
    private final JdbcTemplate template = new JdbcTemplate(jdbcUtil.getDataSource());


    @Override
    public int addUser(User user) {
        var sql = "INSERT INTO  t_user(account,password,nickname,avatar) VALUES(?,?,?,?)";
        return  template.update(sql,user.getAccount(),user.getPassword(),user.getNickname(),user.getAvatar());



    }

    @Override
    public User findUser(User userDto) {
        String sql = "SELECT * FROM t_user WHERE account = ? AND password =?";
        return  template.queryForObject(sql,new BeanPropertyRowMapper<>(User.class),userDto.getAccount(),userDto.getPassword());

    }
}

//package top.zxh.web.com.dao.impl;
//
//import com.dao.UserDao;
//import com.entity.User;
//import com.util.JdbcUtil;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//public class UserDaoImpl implements UserDao {
//    private final JdbcTemplate template=new JdbcTemplate(JdbcUtil.getDataSource());
//    public int addUser(User user) {
//        String sql="insert into t_user (account,password,nickname,avatar) values(?,?,?,?)";
//        return template.update(sql,user.getAccount(),user.getPassword(),user.getNickname(),user.getNickname());
//
//    }
//
//    public User findUser(User useDto) {
//        String sql="select * from t_user Where account =? and password=?";
//       return   template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class),useDto.getAccount(),useDto.getPassword());
////        template.queryForObject();
//    }
//}

package top.zxh.web.login.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import top.zxh.web.login.entity.User;

/**
 * Date:2023/3/3
 * Author：zxh
 * Description: 对数据进行持久化操作
 */
public interface UserMapper {
    /**
     * 根据用户名和密码查询用户对象
     *
     * @param username 用户名
     * @param password 密码
     * @return user
     */
    @Select("SELECT * FROM ex_user WHERE  username = #{username} AND password = #{password}")
    User findUser(@Param("username") String username, @Param("password") String password);

    /**
     * 根据用户名查询用户对象
     *
     * @param username 用户名
     * @return user
     */
    @Select("SELECT * FROM ex_user WHERE username = #{username}")
    User selectByUsername(String username);

    @Insert({"INSERT INTO ex_user(username,password) VALUES (#{username},#{password})"})
    int insertIntoUser(@Param("username") String username,@Param("password")String password);

}

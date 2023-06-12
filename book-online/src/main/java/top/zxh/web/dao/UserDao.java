package top.zxh.web.dao;

import top.zxh.web.entity.User;

/**
 * 用户表 数据访问对象
 */
public interface UserDao {

    /**
     *
     * @param user '入参用户'
     * @return 受影响的记录行数
     */
    int addUser(User user);

    /**
     * 根据查询对象查询用户是否存在
     * @param userDto 查询对象
     * @return 查询结果
     */
    User findUser(User userDto);


}

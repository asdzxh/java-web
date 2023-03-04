package top.zxh.web.login.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import top.zxh.web.login.entity.User;
import top.zxh.web.login.mapper.UserMapper;
import top.zxh.web.login.util.SqlSessionFactoryUtil;

/**
 * Date:2023/3/3
 * Author：zxh
 * Description: 用户服务类
 */
public class UserService {
    /**
     * 1、获取SqlSessionFactory对象
     */
    SqlSessionFactory factory = SqlSessionFactoryUtil.getSqlSessionFactory();

    /**
     * 用户登录
     * @param username
     * @param password
     * @return User
     */
    public User login(String username,String password){
        //获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //获取UserMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 4. 调用方法
        User user = mapper.findUser(username, password);
        // 5. 释放资源
        sqlSession.close();
        return user;

    }

    /**
     * 用户注册
     * @param username
     * @param password
     * @return int 成功返回1，失败报错
     */
    public int Register(String username,String password){
        SqlSession sqlSession = factory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int user = mapper.insertIntoUser(username, password);
        sqlSession.close();
        return user;
    }

    public boolean checkUser(String username){
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectByUsername(username);
        if (user != null){
            return true;
        }else{
            return false;
        }

    }
}

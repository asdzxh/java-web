package top.zxh.web.service.impl;


import top.zxh.web.dao.UserDao;
import top.zxh.web.dao.impl.UserDaoImpl;
import top.zxh.web.entity.User;
import top.zxh.web.service.UserService;

public class UserServiceImpl implements UserService {
    private final UserDao userDao=new UserDaoImpl();
    @Override
    public User signIn(String account, String password) {
        User user=User.builder().account(account).password(password).build();
        return userDao.findUser(user);
    }
}

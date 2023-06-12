package top.zxh.web.dao;

import org.junit.jupiter.api.Test;
import top.zxh.web.dao.impl.UserDaoImpl;
import top.zxh.web.entity.User;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {
    private UserDao userDao = new UserDaoImpl();

    @Test
    void addUser() {
        User userDto = User.builder()
                .account("test@qq.com")
                .password("123")
                .nickname("新用户")
                .build();
        int rows = userDao.addUser(userDto);
        assertEquals(1,rows);

    }

    @Test
    void findUser() {
        User userDto = User.builder()
                .account("mqxu@qq.com")
                .password("123")
                .build();
        User user = userDao.findUser(userDto);
        System.out.println(user);

    }
}
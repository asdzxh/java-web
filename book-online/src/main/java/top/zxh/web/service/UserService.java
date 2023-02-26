package top.zxh.web.service;


import top.zxh.web.entity.User;

public interface UserService {
    User signIn(String account, String password);
}

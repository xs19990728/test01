package cn.xu.service;

import cn.xu.entity.User;

public interface UserService {
    User queryUserByName(String username);
    void addUser(User user);
}

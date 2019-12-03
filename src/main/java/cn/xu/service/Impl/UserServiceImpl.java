package cn.xu.service.Impl;

import cn.xu.Dao.UserDao;
import cn.xu.entity.User;
import cn.xu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public User queryUserByName(String username) {
        return userDao.queryUserByName(username);
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }
}

package book.service.impl;

import book.dao.UserDao;
import book.pojo.User;
import book.service.UserService;

/**
 * @author Agiroy
 * @date 2022/5/23 13:27
 * @effect
 */

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Override
    public User login(String uname, String pwd) {
        return userDao.getUser(uname,pwd);
    }

    @Override
    public void regist(User user) {
        userDao.addUser(user);
    }

    @Override
    public User getUser(String uname) {
        return userDao.getUser(uname);
    }
}

package book.dao;

import book.pojo.User;

/**
 * @author Agiroy
 * @date 2022/5/23 13:18
 * @effect
 */

public interface UserDao {
    User getUser(String uname,String pwd);
    void addUser(User user);
    User getUser(String name);
}

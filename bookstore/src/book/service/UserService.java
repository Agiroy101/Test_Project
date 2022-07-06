package book.service;

import book.pojo.User;

/**
 * @author Agiroy
 * @date 2022/5/23 13:25
 * @effect
 */

public interface UserService {

    User login(String uname,String pwd);

    void regist(User user);

    User getUser(String uname);
}

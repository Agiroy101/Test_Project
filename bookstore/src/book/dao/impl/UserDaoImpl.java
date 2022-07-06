package book.dao.impl;

import book.dao.UserDao;
import book.pojo.User;
import myssm.basedao.BaseDAO;

/**
 * @author Agiroy
 * @date 2022/5/23 13:18
 * @effect
 */

public class UserDaoImpl extends BaseDAO<User> implements UserDao {

    @Override
    public User getUser(String uname, String pwd) {
        return super.load("select * from t_user where uname = ? and pwd = ?",uname,pwd);
    }

    @Override
    public void addUser(User user) {
        executeUpdate("insert into t_user values(0,?,?,?,0)",user.getUname(),user.getPwd(),user.getEmail());
    }

    @Override
    public User getUser(String uname) {
        return load("select * from t_user where uname = ?",uname);
    }
}

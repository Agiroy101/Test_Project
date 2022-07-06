package spring5.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

/**
 * @author Agiroy
 * @date 2022/5/26 19:41
 * @effect
 */

@Repository()
public class UserDaoImpl implements UserDao {

    @Value("aaa")
    private String name;

    @Override
    public void add() {
        System.out.println("add.."+name);
    }
}

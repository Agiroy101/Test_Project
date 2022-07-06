package spring5.service;

import org.springframework.stereotype.Service;
import spring5.dao.UserDao;

import javax.annotation.Resource;

/**
 * @author Agiroy
 * @date 2022/5/26 19:42
 * @effect
 */
@Service
public class UserServiceImpl implements UserService {

//    @Autowired
//    @Qualifier(value="userDaoImpl")
//    @Resource()
    @Resource(name="userDaoImpl")
    private UserDao userDao;

    @Override
    public void add() {
        userDao.add();
    }
}

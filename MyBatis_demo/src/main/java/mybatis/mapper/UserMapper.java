package mybatis.mapper;

import mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author Agiroy
 * @date 2022/5/31 15:48
 * @effect
 */

public interface UserMapper {

    //添加用户信息
    int insertUser();

    //修改用户信息
    void updateUser();

    //删除用户信息
    void deleteUser();

    //根据id查询用户信息
    User getUserById();

    //查询所有的用户的信息
    List<User> getAllUser();

    //根据用户名查询用户信息
    User getUserByUsername(String username);

    //验证登录
    User checkLogin(String username,String password);

    //验证登录（参数为map）
    User checkLoginByMap(Map<String,Object> map);

    //添加用户信息
    int insertUserByUser(User user);

    //验证登录（使用@Param注解）
    User checkLoginByParam(@Param("username")String username,@Param("password") String password);

//    List<Map<String,Object>> getAllUserToMap();
    @MapKey("id")/*以id为键，值为返回的值，类似于map*/
    Map<String,Object> getAllUserToMap();

    void insertUserReturnId(User user);

}

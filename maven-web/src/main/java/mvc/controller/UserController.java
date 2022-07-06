package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Agiroy
 * @date 2022/5/29 20:45
 * @effect
 */
@Controller
public class UserController {

    /**
     * 使用Restful模拟用户资源的增删改查
     * /user    GET    查询所有用户信息
     * /user/1   GET    根据用户id查询用户信息
     * /user    POST    添加用户信息
     * /user/1    DELETE     根据id删除用户信息
     * /user    PUT     修改用户信息
     */

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String getAllUser(){
        System.out.println("查询所有用户信息");
        return "target";

    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public String getUserById(@PathVariable Integer id){
        System.out.println(id);
        System.out.println("根据id查询用户信息");

        return "target";
    }

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String insertUser(String username,String password){

        System.out.println("添加用户信息"+username+","+password);

        return "target";
    }

    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public String updateUser(String username,String password){
        System.out.println("修改用户信息"+username+","+password);

        return "target";
    }


    @RequestMapping("/**/testInterceptor")
    public String testInterceptor(){
        return "target";
    }

    @RequestMapping("/testExceptionHandler")
    public String testExceptionHandler(){
        System.out.println(1/0);
        return "target";
    }







}

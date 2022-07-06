package mvc.controller;

import mvc.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Map;

/**
 * @author Agiroy
 * @date 2022/5/28 19:31
 * @effect
 */

@Controller
public class HelloController {

//    @RequestMapping(value = "/")
//    public String index(){
//
//        return "index";
//    }

    @RequestMapping("/target")
    public String toTarget(){
        return "target";
    }


    @RequestMapping("/testPath/{id}/{username}")
    public String testPath(@PathVariable("id")Integer id, @PathVariable("username")String username, HttpServletRequest request){
        request.getSession();
        System.out.println(id);
        System.out.println(username);
        return "target";
    }

    @RequestMapping("/testParam")
    public String testParam(@RequestParam(value = "user_name",required = false,defaultValue = "user") String username,
                            String password, String[] hobby,
                            @RequestHeader(value = "Host",required = false,defaultValue = "saa") String Header,
                            @CookieValue(value = "JSESSIONID",required = false,defaultValue = "qwe")String session){
        //@RequestParam当前端的name和后端的形参不匹配，可以用这个注解来匹配
        //required = false属性表示当前传输过来的值不一定要带属性名为user_name的值，例如form表单没有user_name这个输入框
        //如果required = ture传值的时候没有属性名为user_name的值，则会报400，如果设置了defaultValue，则不会报错


        //若请求参数中出现多个同名额请求参数，可以再控制器方法的形参位置设置字符串类型或者字符串数组接受此值
        //若使用字符串类型的形参，最终结果为请求参数的每一个值之间使用逗号进行拼接
        System.out.println("username = \t" + username+"password:\t" + password + "hobby:\t" + Arrays.toString(hobby));
        if (password == null){
            System.out.println("密码为null");
        }else if (password.equals("")) {
            System.out.println("密码为空");
        }else {
            System.out.println("其他");
        }
        if (username == null){
            //当前端穿过来的值的属性名和形参不匹配时，就会变成null
            System.out.println("用户名为null");
        }else if (username.equals("")) {
            //前端传过来为空
            System.out.println("用户名为空");
        }else {
            System.out.println("其他");
        }

        System.out.println("Header"+Header);
        System.out.println("session = " + session);
        return "target";
    }

    @RequestMapping("/testPojo")
    public String testPojo(User user){
        System.out.println(user);

        return "target";
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        ModelAndView mav = new ModelAndView();
        //处理模型数据，即想请求域request共享数据
        mav.addObject("testRequestScope","hello,ModelAndView");
        //设置视图名称
        mav.setViewName("target");

        return mav;

    }

    @RequestMapping("/testModel")
    public String testModel(Model model){
        model.addAttribute("testRequestScope","hello,Model");
        return "target";
    }


    @RequestMapping("/testMap")
    public String testMap(Map<String,Object> map){
        map.put("testRequestScope","hello,map");
        return "target";
    }

    @RequestMapping("/testModelMap")
    public String testModelMap(ModelMap modelMap){
        modelMap.addAttribute("testRequestScope","hello,ModelMap");
        return "target";
    }


}

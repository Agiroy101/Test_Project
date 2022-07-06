package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Agiroy
 * @date 2022/5/31 9:46
 * @effect
 */

@Controller
public class TestController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }


}

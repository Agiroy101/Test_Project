package spring5;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author Agiroy
 * @date 2022/5/27 15:12
 * @effect
 */
@Component
@Aspect
@Order(3)
public class PersonProxy {


    //前置通知
    @Before(value = "execution(* spring5.pojo.User.add(..))")
    public void before(){
        System.out.println("PersonProxy:before....");
    }
}

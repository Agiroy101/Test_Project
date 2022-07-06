package spring5;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author Agiroy
 * @date 2022/5/27 14:22
 * @effect
 */

//@Configuration
//@ComponentScan(basePackages = {"spring5.pojo"})
//@EnableAspectJAutoProxy(proxyTargetClass = true)
@Component
@Aspect
@Order(5)
public class UserProxy {

    //相同切入点提取
    @Pointcut(value = "execution(* spring5.pojo.User.add(..))")
    public void pointdemo(){

    }

    //前置通知
    @Before(value = "pointdemo()")
    public void before(){
        System.out.println("before....");
    }

//    环绕通知
    @Around(value = "execution(* spring5.pojo.User.add(..))")
    public void Around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕通知");
        proceedingJoinPoint.proceed();
        System.out.println("环绕通知");
    }

    @After(value = "execution(* spring5.pojo.User.add(..))")
    public void after(){
        System.out.println("最后通知");
    }



    @AfterThrowing(value = "execution(* spring5.pojo.User.add(..))")
    public void AfterThrowing(){
        System.out.println("异常通知");
    }

    @AfterReturning(value = "execution(* spring5.pojo.User.add(..))")
    public void afterReturing(){
        System.out.println("最终通知");
    }




}



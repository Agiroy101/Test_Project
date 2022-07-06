package spring5.testDemo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring5.config.SpringConfig;
import spring5.config.TxConfig;
import spring5.pojo.Book;
import spring5.pojo.User;
import spring5.service.BookService;
import spring5.service.UserServiceImpl;

/**
 * @author Agiroy
 * @date 2022/5/26 14:06
 * @effect
 */

public class testSpring {

    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

//        Orders orders = context.getBean("orders", Orders.class);
//        System.out.println(orders);
        Book book = context.getBean("book", Book.class);
        System.out.println(book);
    }
    @Test
    public void test1(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);


        UserServiceImpl userService = context.getBean("userServiceImpl", UserServiceImpl.class);
        System.out.println(userService);
    }
    @Test
    public void test2(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);


        User user = context.getBean("user", User.class);
        user.add();
    }
    @Test
    public void test3(){
        ApplicationContext context = new AnnotationConfigApplicationContext(TxConfig.class);


        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.countPrice();
    }
}


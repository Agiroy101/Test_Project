package spring5.testDemo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring5.config.TxConfig;
import spring5.pojo.Book;
import spring5.service.BookService;

/**
 * @author Agiroy
 * @date 2022/5/27 19:23
 * @effect
 */

public class testBook {

    @Test
    public void TestJdbc(){
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

        ApplicationContext context = new AnnotationConfigApplicationContext(TxConfig.class);

        BookService bookService = context.getBean("bookService", BookService.class);

        Book book = new Book();
        book.setUserId("12312");
        book.setUsername("zs");
        book.setUstatus("1");

//        bookService.addBook(book);

//        int count = bookService.findCount();
//        System.out.println(count);

//        Book one = bookService.findOne(1);

//        List<Book> all = bookService.findAll();
//        for (Book book1 : all) {
//            System.out.println(book1);
//        }

//        Object[] o1 = {"3123211","java","32"};
//        Object[] o2 = {"wqe","c++","eqw"};
//        Object[] o3 = {"ewq","ewq","eqw"};
//        Object[] o4 = {"123aqw","asdjh","ewq"};
//        List<Object[]> objs = new ArrayList<>();
//        objs.add(o1);
//        objs.add(o2);
//        objs.add(o3);
//        objs.add(o4);
//
//        bookService.batchAdd(objs);

        bookService.countPrice();

    }
}

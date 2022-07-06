package spring5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring5.dao.BookDao;
import spring5.pojo.Book;

import java.util.List;

/**
 * @author Agiroy
 * @date 2022/5/27 19:08
 * @effect
 */

@Service
@Transactional
public class BookService {

    @Autowired
    private BookDao bookDao;

    public void addBook(Book book){
        bookDao.add(book);
    }

    //查询表记录数
    public int findCount(){
       return bookDao.selectCount();
    }

    //查询返回对象
    public Book findOne(int id){
        return bookDao.findBookInfo(id);
    }

    //查询返回集合
    public List<Book> findAll(){
        return bookDao.finAllBook();
    }

    //批量添加
    public void batchAdd(List<Object[]> batchArgs){
        bookDao.batchAdd(batchArgs);
    }


    public void countPrice(){
        Book book = new Book();
        book.setUserId("1");
        book.setPrice(100);
        Book book1 = new Book();
        book1.setUserId("2");
        book1.setPrice(100);
        bookDao.delprice(book);
        int i = 10/0;

        bookDao.addprice(book1);
    }
}

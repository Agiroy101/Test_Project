package book.service.impl;

import book.dao.BookDao;
import book.pojo.Book;
import book.service.BookService;

import java.util.List;

/**
 * @author Agiroy
 * @date 2022/5/23 13:58
 * @effect
 */

public class BookServiceImpl implements BookService {

    private BookDao bookDao;

    @Override
    public List<Book> getBookList() {
        List<Book> bookList = bookDao.getBookList();
        return bookList;
    }

    @Override
    public Book getBook(Integer id) {
        return bookDao.getBook(id);
    }
}

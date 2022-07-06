package book.dao;


import book.pojo.Book;

import java.util.List;

/**
 * @author Agiroy
 * @date 2022/5/23 13:52
 * @effect
 */

public interface BookDao {
    List<Book> getBookList();

    Book getBook(Integer id);
}

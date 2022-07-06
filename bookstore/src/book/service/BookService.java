package book.service;

import book.pojo.Book;

import java.util.List;

/**
 * @author Agiroy
 * @date 2022/5/23 13:57
 * @effect
 */

public interface BookService {
    List<Book> getBookList();

    Book getBook(Integer id);
}

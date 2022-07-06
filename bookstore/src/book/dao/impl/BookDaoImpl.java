package book.dao.impl;

import book.dao.BookDao;
import book.pojo.Book;
import myssm.basedao.BaseDAO;

import java.util.List;

/**
 * @author Agiroy
 * @date 2022/5/23 13:53
 * @effect
 */

public class BookDaoImpl extends BaseDAO<Book> implements BookDao {
    @Override
    public List<book.pojo.Book> getBookList() {
        return executeQuery("select * from t_book where bookStatus=0");
    }

    @Override
    public Book getBook(Integer id) {
        return load("select * from t_book where id = ?",id);
    }
}

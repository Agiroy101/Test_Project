package spring5.dao;

import spring5.pojo.Book;

import java.util.List;

/**
 * @author Agiroy
 * @date 2022/5/27 19:09
 * @effect
 */

public interface BookDao {
    public void add(Book book);

    public int  selectCount();

    public Book findBookInfo(int id);

    public List<Book> finAllBook();

    void batchAdd(List<Object[]> batchArgs);

    public void addprice(Book book);

    public void delprice(Book book);
}

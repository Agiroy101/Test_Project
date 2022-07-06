package spring5.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import spring5.pojo.Book;

import java.util.Arrays;
import java.util.List;

/**
 * @author Agiroy
 * @date 2022/5/27 19:09
 * @effect
 */

@Repository
public class BookDaoImpl implements BookDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void add(Book book) {
        jdbcTemplate.update("insert into t_book values(?,?,?)", book.getUserId(), book.getUsername(), book.getUstatus());
    }

    @Override
    public int selectCount() {
        return jdbcTemplate.queryForObject("select count(*) from t_book", Integer.class);
    }

    @Override
    public Book findBookInfo(int id) {
        return jdbcTemplate.queryForObject("select * from t_book where userId = ?",new BeanPropertyRowMapper<>(Book.class),id);
    }

    @Override
    public List<Book> finAllBook() {
        return jdbcTemplate.query("select * from t_book",new BeanPropertyRowMapper<>(Book.class));
    }

    @Override
    public void batchAdd(List<Object[]> objects) {
        int[] ints = jdbcTemplate.batchUpdate("insert into t_book values(?,?,?)", objects);
        String s = Arrays.toString(ints);
        System.out.println(s);
    }

    @Override
    public void addprice(Book book) {
        jdbcTemplate.update("update t_book set price = (price + ?) where userId = ? ",book.getPrice(), book.getUserId());

    }

    @Override
    public void delprice(Book book) {
        jdbcTemplate.update("update t_book set price = (price - ?) where userId = ? ",book.getPrice(), book.getUserId());

    }
}

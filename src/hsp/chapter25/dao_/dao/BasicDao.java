package hsp.chapter25.dao_.dao;


import hsp.chapter25.dao_.utils.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Agiroy
 * @date 2022/5/10 19:11
 * @effect 开发BasicDao，是其他DAO的父类
 */

public class BasicDao<T> {

    private QueryRunner qr = new QueryRunner();

    //发开通用的dml方法，针对任意的表
    public int DML(String sql, Object... params) {

        Connection connection = null;

        try {
            connection = JDBCUtilsByDruid.getConnection();
            int update = qr.update(connection, sql, params);
            return update;
        } catch (SQLException e) {
            throw new RuntimeException(e);//将编译异常->运行异常
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }

    }

    //返回多个对象(即查询的结果是多行)，针对任意的表

    /**
     * @param sql    sql语句，可以有?
     * @param clazz  传入一个类的class对象，比如String.class
     * @param params 传入?对应的具体的值，可以使多个
     * @return 根据clazz传入的class类型，返回对应的ArrayList集合
     */
    public List<T> queryMultiply(String sql, Class<T> clazz, Object... params) {
        Connection connection = null;

        try {
            connection = JDBCUtilsByDruid.getConnection();
            List<T> query = qr.query(connection, sql, new BeanListHandler<T>(clazz), params);
            return query;
        } catch (SQLException e) {
            throw new RuntimeException(e);//将编译异常->运行异常
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }

    //查询单行结果的通过方法
    public T quertSingle(String sql, Class<T> clazz, Object... params) {
        Connection connection = null;

        try {
            connection = JDBCUtilsByDruid.getConnection();
            return qr.query(connection, sql, new BeanHandler<T>(clazz), params);
        } catch (SQLException e) {
            throw new RuntimeException(e);//将编译异常->运行异常
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }

    //查询单行单列的方法，即返回单值的方法
    public Object queryScalar(String sql, Object... params) {
        Connection connection = null;

        try {
            connection = JDBCUtilsByDruid.getConnection();
            return qr.query(connection, sql, new ScalarHandler(), params);
        } catch (SQLException e) {
            throw new RuntimeException(e);//将编译异常->运行异常
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }
}

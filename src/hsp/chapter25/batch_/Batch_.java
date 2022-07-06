package hsp.chapter25.batch_;

import hsp.chapter25.utils.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Agiroy
 * @date 2022/5/10 14:37
 * @effect 演示java的批处理
 */

public class Batch_ {

    @Test
    public void noBatch() throws SQLException {

        Connection connection = JDBCUtils.getConnection();
        String sql = "insert into t1(id,name) values(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        long start = System.currentTimeMillis();
        for (int i = 1; i < 5000; i++) {
            preparedStatement.setInt(1,i);
            preparedStatement.setString(2,"zs"+i);
            preparedStatement.executeUpdate();

        }
        long end = System.currentTimeMillis();
        System.out.println("传统方式耗时:" + (end - start));
        JDBCUtils.close(null,preparedStatement,connection);

    }

    //使用批量方式添加数据
    @Test
    public void useBatch_() throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        String sql = "insert into t1(id,name) values(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        long start = System.currentTimeMillis();
        for (int i = 1; i < 5001; i++) {
            preparedStatement.setInt(1,i);
            preparedStatement.setString(2,"zs"+i);
            preparedStatement.addBatch();
            //当有1000条记录时，再批量执行
            if ((i%1000 == 0)){
                preparedStatement.executeBatch();
                //清空
                preparedStatement.clearBatch();
            }


        }
        long end = System.currentTimeMillis();
        System.out.println("批量处理方式耗时:" + (end - start));
        JDBCUtils.close(null,preparedStatement,connection);
    }

}

package hsp.chapter25.utils;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Agiroy
 * @date 2022/5/10 13:52
 * @effect 该类演示如何使用JDBCUtils工具类，完成dml和select
 */

public class JDBCUtils_Use {
    public static void main(String[] args) {
        testDML();

    }

    @Test
    public void testSelect() {

        //1.得到连接
        Connection connection = null;

        //2.编写sql语句
        String sql = "select * from t1";

        //3.创建PreparedStatement对象
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println(id + " " + name);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(resultSet, preparedStatement, connection);
        }

    }


    @Test
    public static void testDML() {

        //1.得到连接
        Connection connection = null;

        //2.编写sql语句
        String sql = "insert into t1(id,name) values(?,?)";

        //3.创建PreparedStatement对象

        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 2);
            preparedStatement.setString(2, "ww");
            int i = preparedStatement.executeUpdate();
            System.out.println(i > 0 ? "成功" : "失败");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null, preparedStatement, connection);
        }


    }
}

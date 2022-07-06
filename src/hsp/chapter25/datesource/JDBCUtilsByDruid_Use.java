package hsp.chapter25.datesource;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Agiroy
 * @date 2022/5/10 13:52
 * @effect 该类演示如何使用JDBCUtils工具类，完成dml和select
 */

public class JDBCUtilsByDruid_Use {
    public static void main(String[] args) {

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
            connection = JDBCUtilsByDruid.getConnection();
            System.out.println(connection.getClass());
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
            JDBCUtilsByDruid.close(resultSet, preparedStatement, connection);
        }

    }

    //使用土方法来解决ResultSet =封装=>ArrayList
    @Test
    public void testSelectToArrayLsit() {

        //1.得到连接
        Connection connection = null;

        //2.编写sql语句
        String sql = "select * from t1";

        //3.创建PreparedStatement对象
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        ArrayList<t1> arrayList = new ArrayList();//创建ArrayList对象，存放t1对象
        try {
            connection = JDBCUtilsByDruid.getConnection();
            System.out.println(connection.getClass());
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String pwd = resultSet.getString("pwd");
                String sex = resultSet.getString("sex");
                Double sal = resultSet.getDouble("sal");
                //把得到的resultset的记录封装到t1对象，放入到list集合
                arrayList.add(new t1(id, name, sex, sal, pwd));
            }
            Iterator<t1> iterator = arrayList.iterator();
            while (iterator.hasNext()) {
                t1 next =  iterator.next();
                System.out.println(next);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtilsByDruid.close(resultSet, preparedStatement, connection);
        }

    }


}

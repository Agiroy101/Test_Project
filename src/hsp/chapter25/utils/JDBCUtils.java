package hsp.chapter25.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @author Agiroy
 * @date 2022/5/9 17:01
 * @effect 这是一个工具类，完成mysql的连接和关闭资源
 */

public class JDBCUtils {

    //定义相关的属性(4个),因为只需要一份，因此，我们做成static
    private static String user;//用户名
    private static String password;//密码
    private static String driver;//驱动名
    private static String url;//url

    //在static代码块去初始化
    static {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("src\\hsp\\chapter25\\jdbc\\mysql.properties"));
            //读取相关的属性
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            url = properties.getProperty("url");
            driver = properties.getProperty("driver");
        } catch (IOException e) {
            //在实际开发中,可以这样处理
            //1.将编译异常转成运行异常
            //2.这时调用者，可以选择捕获该异常，也可以选择默认处理该异常，比较方便
            throw new RuntimeException(e);
//            e.printStackTrace();
        }
    }

    //连接数据库，返回Connection
    public static Connection getConnection() {


        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    //关闭资源
    /*
     * 1.ResultSet结果集
     * 2.Statement或者PreparedStatement
     * 3.Connection
     * 4.如果需要关闭资源，就传入对象，否则传入null
     * */
    public static void close(ResultSet resultSet, Statement statement, Connection connection) {

        //判断是否为null
        try {
            if (resultSet != null){
                resultSet.close();
            }
            if (statement != null){
                statement.close();
            }
            if (connection != null){
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

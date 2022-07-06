package hsp.chapter25.datesource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Agiroy
 * @date 2022/5/10 15:22
 * @effect 演示C3P0的使用
 */

public class C3P0_ {

    //方式1：相关参数，在程序中指定user，url，password
    @Test
    public void testC3P0_01() throws Exception {

        //1.创建一个数据源对象
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        //2.通过配置文件mysql.properties获取相关连接的信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\hsp\\chapter25\\jdbc\\mysql.properties"));
        //读取相关的属性
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");

        //给数据源 comboPooledDataSource设置相关的参数
        comboPooledDataSource.setDriverClass(driver);
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);
        comboPooledDataSource.setJdbcUrl(url);

        //设置初始化连接数
        comboPooledDataSource.setInitialPoolSize(10);
        //最大连接数
        comboPooledDataSource.setMaxPoolSize(50);
        //测试连接池的效率，测试对mysql 5000次操作
        long start = System.currentTimeMillis();
        for (int i = 1; i < 5001; i++) {
            Connection connection = comboPooledDataSource.getConnection();//这个方法就是从 DataSource接口实现的
//            System.out.println("连接成功");
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("C3P0方式效率：" + (end - start));

    }

    //第二种方式 使用配置文件模板来完成

    //1.将C3P0体统的c3p0-config.xml拷贝到src目录下
    //2.该文件指定了连接数据库和连接池的相关参数
    @Test
    public void C3P0_() throws SQLException {

        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource("Agiroy");

        //测试连接池的效率，测试对mysql 5000次操作
        long start = System.currentTimeMillis();
        for (int i = 1; i < 50001; i++) {
            Connection connection = comboPooledDataSource.getConnection();//这个方法就是从 DataSource接口实现的
//            System.out.println("连接成功");
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("C3P0的第二种方式效率：" + (end - start));
//        Connection connection = comboPooledDataSource.getConnection();
//        System.out.println("连接OK");
//        connection.close();

    }
}

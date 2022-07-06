package hsp.chapter25.jdbc;

import com.mysql.cj.jdbc.Driver;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author Agiroy
 * @date 2022/5/9 13:35
 * @effect 分析java连接mysql的5种方式
 */

public class JdbcConn {

    @Test
    public void connect01() throws SQLException {
        Driver driver = new Driver();
        String url = "jdbc:mysql://localhost:3306/own?serverTimezone=UTC";
        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","123456");
        Connection connect = driver.connect(url, properties);
        System.out.println(connect);
    }

    //方式2
    @Test
    public void connect02() throws Exception {

        //使用反射加载Driver类,动态加兹安，更加的灵活，减少依赖型
        Class<?> cls = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver) cls.newInstance();

        String url = "jdbc:mysql://localhost:3306/own?serverTimezone=UTC";
        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","123456");
        Connection connect = driver.connect(url, properties);
        System.out.println("方式2："+connect);


    }

    //方式3 使用DirverManager替代Deriver进行统一管理
    @Test
    public void connect03() throws Exception{

        Class<?> cls = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver)cls.newInstance();

        String url =  "jdbc:mysql://localhost:3306/own?serverTimezone=UTC";
        String user = "root";
        String password = "123456";

        DriverManager.registerDriver(driver);

        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println("第三种连接："+ connection);
    }

    //方式4 使用Class.forName自动完成注册驱动，简化代码
    @Test
    public void connect04() throws Exception{

        //使用反射加载了Driver类
        //在加载Driver类是，完成注册
        Class.forName("com.mysql.cj.jdbc.Driver");//这条语句注释了也能运行
        //因为mysql驱动5.1.6以后可以无需Class.forName("com.mysql.cj.jdbc.Driver");
        //从jdk1.5以后使用了jdbc4,不再需要显式调用Class.forName("com.mysql.cj.jdbc.Driver");注册驱动，而是自动调用jar包下
        //META-INF\Services\java.sql.Driver文本中的类名称去注册

        /*
        static {
            try {
                DriverManager.registerDriver(new Driver());
            } catch (SQLException var1) {
                throw new RuntimeException("Can't register driver!");
        }
    }*/

        String url =  "jdbc:mysql://localhost:3306/own?serverTimezone=UTC";
        String user = "root";
        String password = "123456";

        Connection connection = DriverManager.getConnection(url, user, password);

        System.out.println("第四种方式" + connection);

    }

    //方式5，在方式4的基础上改进，增加配置文件，让连接mysql更加灵活
    @Test
    public void connect05() throws Exception{

        //通过Properties对象获取配置文件的信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\hsp\\chapter25\\jdbc\\mysql.properties"));
        //获取相关的值
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");

        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);

        String sql = "insert into t1 values (1,'zs','man',1200)";
        String sql2 = "update t1 set name = 'ls' where id = 1";
        String sql3 ="delete from t1";
        Statement statement = connection.createStatement();
        int i = statement.executeUpdate(sql3);
        System.out.println(i>0?"成功":"失败");

        System.out.println("第五种方法：" + connection);


        statement.close();
        connection.close();

    }

}

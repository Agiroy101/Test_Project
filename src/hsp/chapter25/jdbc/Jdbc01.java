package hsp.chapter25.jdbc;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author Agiroy
 * @date 2022/5/8 18:55
 * @effect
 */

public class Jdbc01 {
    public static void main(String[] args) throws SQLException {

        //前置工作：在项目下创建一个文件夹比如libs
        //将mysql.jar拷贝到该目录下，点击add to project加入到项目
        //1.注册驱动
        Driver driver = new Driver();

        //2.得到连接
        String url = "jdbc:mysql://localhost:3306/own?serverTimezone=UTC";
        //将用户名和密码放入到Properties对象中
        Properties properties = new Properties();
        //user和password是规定好的，后面的值根据实际情况写
        properties.setProperty("user","root");
        properties.setProperty("password","123456");

        Connection connect = driver.connect(url, properties);

        //3.执行sql
//        String sql = "insert into t1 values (1,'zs','man',1200)";
//        String sql = "update t1 set id = 2 where name = 'zs'";
        String sql = "delete from t1";
        //statement用于执行静态sql语句并返回其生成的结果的对象
        Statement statement = connect.createStatement();
        int i = statement.executeUpdate(sql);
        System.out.println(i>0?"成功":"失败");

        //关闭连接
        statement.close();
        connect.close();

    }
}

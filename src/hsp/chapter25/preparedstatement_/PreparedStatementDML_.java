package hsp.chapter25.preparedstatement_;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.util.Scanner;

/**
 * @author Agiroy
 * @date 2022/5/9 15:52
 * @effect 演示Preparedstatement使用
 */

public class PreparedStatementDML_ {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        //SQL注入
        System.out.println("请输入管理员的名字和密码");
        //注入的账号:1' or   密码（万能密码）:or '1' = '1
        String admin_name = scanner.nextLine();//这里如果用的是next()，就会出现当接受到空格或者是'就是表示结束
        String admin_pwd = scanner.nextLine();

        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\hsp\\chapter25\\jdbc\\mysql.properties"));
        //获取相关的值
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");

        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);

        //sql语句的?相当于占位符
        String sql = "insert into t1(id,name,pwd) values(?,?,?)";
        String sql1 = "update t1 set pwd = ? where name = ? ";
        String sql2 = "delete from t1 where name = ?";

        //得到Statement
        PreparedStatement preparedStatement = connection.prepareStatement(sql2);
//        preparedStatement.setInt(1,2);
        preparedStatement.setString(1, admin_name);
//        preparedStatement.setString(2, admin_pwd);


        //执行select语句使用executeUpdate
        int i = preparedStatement.executeUpdate();
        System.out.println(i > 0 ? "成功" : "失败");


        //关闭连接
        preparedStatement.close();
        connection.close();

    }
}

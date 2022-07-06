package hsp.chapter25.preparedstatement_;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

/**
 * @author Agiroy
 * @date 2022/5/9 15:52
 * @effect 演示Preparedstatement使用
 */

public class PreparedStatement_ {
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
        String sql = "select * from t1 where name=? and pwd=?";

        //得到Statement
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, admin_name);
        preparedStatement.setString(2, admin_pwd);


        //执行select语句使用executeQuery
        //如果执行的是dml(update,insert,delete) 使用executeUpdate()
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            System.out.println("登陆成功");
        } else {
            System.out.println("登录失败");

//        //使用while取出数据
//        while (resultSet.next()){//让光标向后移动，如果没有更多航，则返回false
//            int id = resultSet.getInt(1);//获取该行的第一列数据
//            String name = resultSet.getString(2);//获取该行的第二列数据
//            String job = resultSet.getString(3);//获取该行的第三列数据
//            Date date = resultSet.getDate(5);
//            System.out.println(id+"\t"+name+"\t"+job+"\t"+date);
//
//        }


            //关闭连接
            resultSet.close();
            preparedStatement.close();
            connection.close();

        }
    }
}

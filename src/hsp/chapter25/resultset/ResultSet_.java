package hsp.chapter25.resultset;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

/**
 * @author Agiroy
 * @date 2022/5/9 14:32
 * @effect 演示select语句返回ResultSet，并取出结果
 */

public class ResultSet_ {
    public static void main(String[] args) throws Exception{

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

        //得到Statement
        Statement statement = connection.createStatement();

//        //组织sql于语句
//        String sql = "select * from emp";
//
//        //执行给定的sql语句，该语句返回单个ResultSet对象
//        ResultSet resultSet = statement.executeQuery(sql);
//
//        //使用while取出数据
//        while (resultSet.next()){//让光标向后移动，如果没有更多航，则返回false
//            int id = resultSet.getInt(1);//获取该行的第一列数据
//            String name = resultSet.getString(2);//获取该行的第二列数据
//            String job = resultSet.getString(3);//获取该行的第三列数据
//            Date date = resultSet.getDate(5);
//            System.out.println(id+"\t"+name+"\t"+job+"\t"+date);
//
//        }

        String sql = "select * from t1 where name='"+admin_name+"' and pwd='"+admin_pwd+"'";

        ResultSet resultSet = statement.executeQuery(sql);
        if (resultSet.next()){
            System.out.println("登陆成功");
        }else {
            System.out.println("登录失败");
        }


        //关闭连接
        resultSet.close();
        statement.close();
        connection.close();

    }
}

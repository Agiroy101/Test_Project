package hsp.chapter25.datesource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Agiroy
 * @date 2022/5/10 13:52
 * @effect
 */

public class DBUtils_Use {

    //使用 apache-DBUtils工具类 + druid 完成对表的crud操作
    @Test
    public void testQueryMany() throws SQLException {//返回结果是多行的情况
        //1.得到连接(druid)
        Connection connection = JDBCUtilsByDruid.getConnection();

        //2.使用DBUtils类和接口，先引入DBUtils相关的jar,加入到项目中
        //3.创建QueryRunner
        QueryRunner queryRunner = new QueryRunner();
        //4.就可以执行相关方法，返回ArrayList结果集
//        String sql = "select * from t1 where id > ?";
        //sql语句也可以查询部分列
        String sql = "select id,name from t1";
        //(1)query方法就是执行sql语句，得到resultset  封装到 ArrayList
        //(2)返回集合
        //(3)connection：连接
        //(4)sql:执行的sql语句
        //(5)new BeanListHandler<>(t1.class):在将resulttest -> t1对象 ->封装到ArrayList
        //底层使用反射机制去获取t1类的属性，然后进行封装
        //(6)参数1 就是给sql语句中的?赋值，可以有多个值，因为是可变参数Object...params
        //(7)底层得到的resultset，会在query关闭,关闭PreparedStatement
        List<t1> query = queryRunner.query(connection, sql, new BeanListHandler<>(t1.class));

        for (t1 t : query) {
            System.out.println(t);
        }

        //释放资源
        JDBCUtilsByDruid.close(null, null, connection);

    }

    //演示 apache-DBUtils + druid 完成返回的结果是单行记录（单个对象）
    @Test
    public void testQuerySingle() throws SQLException {
        Connection connection = JDBCUtilsByDruid.getConnection();

        QueryRunner queryRunner = new QueryRunner();
        String sql = "select * from t1 where id = ?";
        //因为我们返回的是单行记录-->单个对象，使用的Hander是BeanHandler
        t1 query = queryRunner.query(connection, sql, new BeanHandler<>(t1.class), 1);

        System.out.println(query);

        JDBCUtilsByDruid.close(null, null, connection);
    }

    //演示apache-DBUtils + druid 完成返回的结果是单行单列的情况，返回的就是object
    @Test
    public void TestScalar() throws Exception {
        Connection connection = JDBCUtilsByDruid.getConnection();

        QueryRunner queryRunner = new QueryRunner();
        String sql = "select name from t1 where id = ?";
        //因为我们返回的是单行记录-->单个对象，使用的Hander是BeanHandler
        Object query = queryRunner.query(connection, sql, new ScalarHandler(), 1);
        System.out.println(query);

        JDBCUtilsByDruid.close(null, null, connection);
    }

    //演示apache-DBUtils + druid 完成dml(update,insert,delete)
    @Test
    public void testDML() throws Exception{
        Connection connection = JDBCUtilsByDruid.getConnection();

        QueryRunner queryRunner = new QueryRunner();
//        String sql = "update t1 set name = ? where id = ?";
        String sql = "insert into t1(id,name) values (?,?)";

        int affectedRow = queryRunner.update(connection, sql, 3, "ls");
        System.out.println(affectedRow>0?"执行成功":"执行没有影响到表");

        JDBCUtilsByDruid.close(null, null, connection);
    }


}

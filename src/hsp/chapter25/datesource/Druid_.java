package hsp.chapter25.datesource;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author Agiroy
 * @date 2022/5/10 15:56
 * @effect 测试druid的使用
 */

public class Druid_ {
    @Test
    public void testDurid() throws Exception {
        //1.加入Druid.jar
        //2.加入配置文件druid.properties,将该文件拷贝项目的src目录
        //3.创建properties对象，读取配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        long start = System.currentTimeMillis();
        for (int i = 1; i < 50001; i++) {
            //4.创建一个指定参数的数据库连接池,Druid连接池

            Connection connection = dataSource.getConnection();
//            System.out.println("连接成功");
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("德鲁伊方式效率：" + (end - start));

    }
}

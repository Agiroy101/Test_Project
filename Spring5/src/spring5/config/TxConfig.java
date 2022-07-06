package spring5.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author Agiroy
 * @date 2022/5/27 21:24
 * @effect
 */
@Configuration
@ComponentScan(basePackages = "spring5.*")//组件扫描
@EnableTransactionManagement//开启事务
public class TxConfig {

    //创建一个数据库的连接池
    @Bean
    public DruidDataSource getDruidDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/userdb?serverTimezone=UTC");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("123456");


        return druidDataSource;
    }

    //创建JdbcTemplate
    //@Bean 注解的方法 ,其参数将会被自动视为被 @Autowired ,所修饰 ,注入规则为按类型注入 ,如果有多个同类型把参数当 BeanId 按名称注入
    @Bean
    public JdbcTemplate getJdbcTemplate(DataSource dataSource){
        //到ioc容器中根据类型找到dataSource
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        //注入dataSource
//        jdbcTemplate.setDataSource(getDruidDataSource());
        jdbcTemplate.setDataSource(dataSource);

        return jdbcTemplate;
    }

    //创建事务管理器的对象
    @Bean
    public DataSourceTransactionManager getDataSourceTransactionManager(DataSource dataSource){
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);

        return dataSourceTransactionManager;
    }
}

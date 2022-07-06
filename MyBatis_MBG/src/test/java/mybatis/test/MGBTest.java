package mybatis.test;

import mybatis.mapper.EmpMapper;
import mybatis.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Agiroy
 * @date 2022/6/2 20:00
 * @effect
 */

public class MGBTest {
    @Test
    public void testMGB(){
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
//            List<Emp> empList = mapper.selectByExample(null);
//            empList.forEach(emp -> System.out.println(emp));
            //根据条件来查询
//            EmpExample empExample = new EmpExample();
//            empExample.createCriteria().andEmpNameEqualTo("zs").andAgeGreaterThan(10);
//            empExample.or().andDidIsNotNull();
//            List<Emp> empList1 = mapper.selectByExample(empExample);
//            empList1.forEach(emp -> System.out.println(emp));

            //updateByPrimaryKeySelective方法：如果值中有null，则不会再sql语句中出现null的值
            mapper.updateByPrimaryKeySelective(new Emp(1,"admin",22,null,"123@qq.com",3));
            //updateByPrimaryKey方法：如果值中有null，则会把数据库对应的值也设置为null
            mapper.updateByPrimaryKey(new Emp(1,"admin",22,null,"123@qq.com",3));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package mybatis.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import mybatis.mapper.EmpMapper;
import mybatis.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author Agiroy
 * @date 2022/6/2 20:19
 * @effect
 */

public class PageHelpTest {

    //使用mybatis的分页插件实现分页功能
    //1.需要在查询功能之前开启分页
    //PageHelper.startPage(int pageNum,int pages);
    @Test
    public void testPageHelper(){
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
//            Page<Object> page = PageHelper.startPage(2, 4);
            PageHelper.startPage(2, 4);
            List<Emp> emps = mapper.selectByExample(null);
            PageInfo<Emp> page = new PageInfo<>(emps,3);
//            emps.forEach(emp -> System.out.println(emp));
            System.out.println(page);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

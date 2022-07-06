package mybatis.test;

import mybatis.mapper.DynamicSQLMapper;
import mybatis.pojo.Emp;
import mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author Agiroy
 * @date 2022/6/2 13:19
 * @effect
 */

public class DynamicSqlMapperTest {

    @Test
    public void getDeptAndEmpByStepOne(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> emp = mapper.getEmpByCondition(new Emp(null, "ww", 23, "男", "123@qq.com"));
        System.out.println("emp = " + emp);


    }

    @Test
    public void getEmpByChoose(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> emp = mapper.getEmpByChoose(new Emp(null, "ww", 23, "男", "123@qq.com"));
        System.out.println("emp = " + emp);

    }


    @Test
    public void deleteMoreByArray(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        int result = mapper.deleteMoreByArray(new Integer[]{16,17});
        System.out.println("result = " + result);

    }

    @Test
    public void insertMoreByList(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp1 = new Emp(null,"a",12,"男","123@qq.com");
        Emp emp2 = new Emp(null,"a",13,"男","123@qq.com");
        Emp emp3 = new Emp(null,"a",14,"男","123@qq.com");
        Emp emp4 = new Emp(null,"a",15,"男","123@qq.com");
        List<Emp> empList =Arrays.asList(emp1,emp2,emp3,emp4);
        int result = mapper.insertMoreByList(empList);
        System.out.println("result = " + result);

    }



}

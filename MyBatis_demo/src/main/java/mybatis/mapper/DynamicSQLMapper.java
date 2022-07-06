package mybatis.mapper;

import mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Agiroy
 * @date 2022/6/2 13:08
 * @effect
 */

public interface DynamicSQLMapper {

    List<Emp> getEmpByCondition(Emp emp);

    //测试choose，when，otherwise
    List<Emp> getEmpByChoose(Emp emp);

    //通过数组实现批量删除
    int deleteMoreByArray(@Param("eids") Integer[] eids);

    //通过list集合实现批量添加
    int insertMoreByList(@Param("emps") List<Emp> emps);

}

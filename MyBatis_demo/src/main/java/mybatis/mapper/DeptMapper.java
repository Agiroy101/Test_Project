package mybatis.mapper;

import mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

/**
 * @author Agiroy
 * @date 2022/6/1 19:15
 * @effect
 */
public interface DeptMapper {

    //分布查询第二步：通过did查询员工所对应的部门
    Dept getEmpAndDeptByStepTwo(@Param("did")Integer did);

    //获取部门以及部门中所有的员工信息
    Dept getDeptAndEmp(@Param("did") Integer did);

    //通过分布查询查询部门以及部门中所有的员工的信息
    //分布查询第一步：查询部门信息
    Dept getDeptAndEmpByStepOne(@Param("did") Integer did);

}

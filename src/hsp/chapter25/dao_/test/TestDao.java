package hsp.chapter25.dao_.test;

import hsp.chapter25.dao_.dao.T1Dao;
import hsp.chapter25.dao_.domain.T1;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author Agiroy
 * @date 2022/5/10 19:35
 * @effect
 */

public class TestDao {
    @Test
    //测试T1Dao对t1表crud操作
    public void testT1Dao(){
        T1Dao t1Dao = new T1Dao();
        //1.查询
        List<T1> list = t1Dao.queryMultiply("select * from t1", T1.class, null);
        System.out.println("查询结果");
        for (T1 t : list){
            System.out.println(t);
        }


        //查询单行记录
        T1 t1 = t1Dao.quertSingle("select * from t1 where id = ?", T1.class, 1);
        System.out.println("查询单行结果");
        System.out.println(t1);

        //查询单行单列
        Object o = t1Dao.queryScalar("select name from t1 where id = ?",  1);
        System.out.println("查询单行单列结果");
        System.out.println(o);

        //dml操作,insert,update,detele
        int affectRow = t1Dao.DML("insert into t1(id,name) values(?,?)",  4, "xm");
        System.out.println(affectRow>0?"执行成功":"执行没有影响表");

    }
}

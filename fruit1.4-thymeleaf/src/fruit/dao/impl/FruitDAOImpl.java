package fruit.dao.impl;


import fruit.dao.FruitDAO;
import fruit.pojo.Fruit;
import myssm.basedao.BaseDAO;
import org.junit.Test;

import java.util.List;

public class FruitDAOImpl extends BaseDAO<Fruit> implements FruitDAO {
    @Override
    public List<Fruit> getFruitList(String keyword , Integer pageNo) {
        return super.executeQuery("select * from t_fruit where fname like ? or remark like ? limit ? , 5" ,"%"+keyword+"%","%"+keyword+"%", (pageNo-1)*5);
    }

    @Override
    public Fruit getFruitById(Integer fid) {
        return super.load("select * from t_fruit where fid = ?",fid);
    }


    @Override
    public int updateFruitById(Integer fid, String fname, Integer price, Integer fcount, String remark) {
        return super.executeUpdate("update t_fruit set fname = ?, price = ?, fcount = ?, remark = ? where fid = ?",fname,price,fcount,remark,fid);
    }

    @Override
    public int delFruitById(Integer fid) {
        return super.executeUpdate("delete from t_fruit where fid = ?",fid);
    }

    @Override
    public int addFruit(Fruit fruit) {
        return super.executeUpdate("insert into t_fruit(fname,price,fcount,remark) values(?,?,?,?) ",fruit.getFname(),fruit.getPrice(),fruit.getFcount(),fruit.getRemark());
    }

    @Test
    @Override
    public int getFruitCount(String keyword) {
        return (((Long) super.executeComplexQuery("select count(*) from t_fruit where fname like ? or remark like ?","%"+keyword+"%","%"+keyword+"%")[0]).intValue());
    }

    public int updateFruitById(Fruit fruit) {
        return super.executeUpdate("update t_fruit set fname = ?, price = ?, fcount = ?, remark = ? where fid = ?",fruit.getFname(),fruit.getPrice(),fruit.getFcount(),fruit.getRemark(),fruit.getFid());
    }
}

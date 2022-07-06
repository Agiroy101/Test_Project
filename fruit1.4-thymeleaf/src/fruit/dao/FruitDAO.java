package fruit.dao;


import fruit.pojo.Fruit;

import java.util.List;

public interface FruitDAO {
    //获取所有的库存列表信息
    List<Fruit> getFruitList(String keyword,Integer pageNo);

    Fruit getFruitById(Integer fid);

    int updateFruitById(Integer id,String fname,Integer price, Integer fcount, String remark);
//    int updateFruitById(Fruit fruit);

    int delFruitById(Integer fid);

    int addFruit(Fruit fruit);

    //查询库存总记录条数
    int getFruitCount(String keyword);
}

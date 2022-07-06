package hsp.chapter14.map_;

import java.util.HashMap;
import java.util.Map;

public class MapMethod {
    public static void main(String[] args) {

        Map map = new HashMap();
        map.put("邓超",new Book("java",100));
        map.put("邓超","孙俪");
        map.put("王宝强","马蓉");
        map.put("宋吉","马蓉");
        map.put("ww",null);
        map.put(null,"刘亦菲");
        map.put("zs","ls");

        System.out.println(map);

        //根据映射来删除
        map.remove("宋吉");
        System.out.println(map);

        //根据键来获取值
        System.out.println(map.get("zs"));

        //获取元素个数
        System.out.println(map.size());

        //判断个数是否为0
        System.out.println(map.size());

        //清楚键值对
        map.clear();        System.out.println(map);

        //查找键是否存在
        System.out.println(map.containsKey("zs"));
        //查找值是否存在
        System.out.println(map.containsValue("null"));



    }
}

class Book{
    private String name;
    private int num;

    public Book(String name, int num) {
        this.name = name;
        this.num = num;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", num=" + num +
                '}';
    }
}

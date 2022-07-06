package hsp.chapter14.collection;

import java.util.ArrayList;
import java.util.List;

public class CollectionMethod {
    public static void main(String[] args) {
        List list = new ArrayList();

        list.add("asd");
        list.add(12);
        list.add(true);

        System.out.println(list);

        list.remove((Integer)12);
        System.out.println(list);

        //查找元素是否存在
        System.out.println(list.contains("asd"));

        //获取元素的个数
        System.out.println(list.size());

        //判断是否为空
        System.out.println(list.isEmpty());

        //清空
        list.clear();
        System.out.println(list);

        //添加多个榆树
        ArrayList arrayList = new ArrayList();
        arrayList.add("qwe");
        arrayList.add("zxc");
        list.addAll(arrayList);
        System.out.println(list);

        //查找多个元素是否都存在
        System.out.println(list.containsAll(arrayList));

        //删除多个元素
        list.add("iop");
        list.removeAll(arrayList);
        System.out.println(list);



    }
}

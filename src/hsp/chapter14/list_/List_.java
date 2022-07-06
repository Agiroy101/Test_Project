package hsp.chapter14.list_;

import java.util.ArrayList;
import java.util.List;

public class List_ {
    public static void main(String[] args) {

        List list = new ArrayList();
        list.add("zs");
        list.add("ww");

        //在指定位置插入元素
        list.add("zl");
        System.out.println(list);

        //从指定位置开始将所有元素都加进来
        List list2 = new ArrayList();
        list2.add("xm");
        list2.add("xh");
        list.addAll(1,list2);
        System.out.println(list);

        //获取指定位置上的元素
        System.out.println(list.get(2));

        //获取obj在集合中首次出现的位置
        System.out.println(list.indexOf("zl"));

        //获取obj在集合中最后出现的位置
        list.add("zs");
        System.out.println(list.lastIndexOf("zs"));

        //移除指定index位置的元素，并返回该元素
        System.out.println(list.remove(5));

        //设置指定index位置的元素为ele，相当于是替换
        list.set(1,"ls");
        //list.set(10,"aa");//会越界，该索引一定要存在
        System.out.println(list);

        //返回从fromIndex到toIndex位置的子集合，前闭后开
        List list1 = list.subList(0, 3);
        System.out.println(list1);


    }
}

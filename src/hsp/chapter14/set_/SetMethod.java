package hsp.chapter14.set_;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetMethod {
    public static void main(String[] args) {
        //set对象不能存放重复的元素，可以添加一个null
        //set接口对象存放数据是无序的
        Set set = new HashSet();
        set.add("zs");
        set.add("ls");
        set.add("ww");
        set.add("zl");
        set.add(null);

        System.out.println(set);

        //遍历方式1：使用迭代器
        System.out.println("========");
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object obj =  iterator.next();
            System.out.println(obj);
        }

        System.out.println("==========");
        //遍历方法2:使用增强for
        for (Object o : set) {
            System.out.println(o);
        }


    }
}

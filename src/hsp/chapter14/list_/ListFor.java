package hsp.chapter14.list_;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class ListFor {
    public static void main(String[] args) {
        //三种任选一个都可以
//        List list = new ArrayList();
//        List list = new LinkedList();
        List list = new Vector();
        list.add("zs");
        list.add("ls");
        list.add("ww");
        list.add("zl");

        //1.迭代器
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println(obj);
        }//1.6 2


        //2.增强for
        System.out.println("===增强for===");
        for (Object obj : list) {
            System.out.println(obj);
        }

        //3.普通for
        System.out.println("===普通for===");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }


    }
}

package hsp.chapter14.list_;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListExercise {
    public static void main(String[] args) {
        List list = new ArrayList();
        for (int i = 0; i < 11; i++) {
            list.add("hello" + i);
        }



        list.add(2,"韩顺平");
        System.out.println(list.get(5));
        list.remove(6);
        list.set(7,"nihao");
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }



    }
}

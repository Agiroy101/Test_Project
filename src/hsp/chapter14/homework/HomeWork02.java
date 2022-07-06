package hsp.chapter14.homework;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HomeWork02 {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put("jack", 650);
        hashMap.put("tom", 1200);
        hashMap.put("smith", 2900);
        System.out.println(hashMap);

        hashMap.replace("jack", 2600);
//        hashMap.put("jack",2600);
        System.out.println(hashMap);

        Set set = hashMap.keySet();
        for (Object o : set) {
            hashMap.put(o, (int) hashMap.get(o) + 100);
        }
//        System.out.println(hashMap);

        Set set1 = hashMap.entrySet();
        Iterator iterator = set1.iterator();
        while (iterator.hasNext()) {
            Map.Entry next = (Map.Entry) iterator.next();
            System.out.println(next.getKey() + "-" + next.getValue());
        }


    }
}

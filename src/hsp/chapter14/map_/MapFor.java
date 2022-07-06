package hsp.chapter14.map_;

import java.util.*;

public class MapFor {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("邓超", "孙俪");
        map.put("王宝强", "马蓉");
        map.put("宋吉", "马蓉");
        map.put("ww", null);
        map.put(null, "刘亦菲");
        map.put("zs", "ls");

        //第一组：先取出所有的Key，通过Key取出对应的Value
        Set set = map.keySet();
        //1.增强For
        for (Object obj : set) {
            System.out.println(obj + "-" + map.get(obj));
        }

        System.out.println("====================");
        //2.迭代器
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object obj =  iterator.next();
            System.out.println(obj + "-" + map.get(obj));
        }


        //第二组：把所有的Values取出
        System.out.println("====取出所有的值========");
        Collection values = map.values();
        //1.增强for
        for (Object obj : values){
            System.out.println(obj);
        }

        //2.迭代器
        System.out.println("=====================");
        Iterator iterator1 = values.iterator();
        while (iterator1.hasNext()) {
            Object obj1 =  iterator1.next();
            System.out.println(obj1);

        }

        //第三组：通过EntrySet
        System.out.println("==============通过EntrySet的增强for=========");
        Set set1 = map.entrySet();//EnrtySet<Map.Entry<K,V>>
        //1.增强for
        for(Object obj : set1){
            //将entry转成Map.Entry
            Map.Entry s = (Map.Entry) obj;
            System.out.println(s.getKey() + "-" + s.getValue());
        }

        //2.迭代器
        System.out.println("========通过EntrySet的迭代器========");
        Iterator iterator2 = set1.iterator();
        while (iterator2.hasNext()) {
            Object obj =  iterator2.next();
            System.out.println(obj.getClass());//HashMap$Node 实现->Map.Entry（getKey,getValue）
            //向下转型Map.Entry
            Map.Entry m = (Map.Entry) obj;
            System.out.println(m.getKey() + "-" + m.getValue());
//            System.out.println(obj);



        }




    }
}

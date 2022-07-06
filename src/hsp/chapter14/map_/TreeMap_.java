package hsp.chapter14.map_;

import java.util.TreeMap;

public class TreeMap_ {
    public static void main(String[] args) {
        TreeMap treeMap = new TreeMap();
//        TreeMap treeMap = new TreeMap(new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//
////                return ((String)o1).length()-((String) o2).length();
////                (o1.g);
////                (String)o2
//
//                return ((String)o1).length()-((String) o2).length();
//
//            }
//        });


        treeMap.put("jack","杰克");
        treeMap.put("tom","汤姆");
        treeMap.put("tww","汤姆222");
        treeMap.put("kristina","克瑞斯提诺");
        treeMap.put("smith","史密斯");
        treeMap.put("jack","杰克222");
        treeMap.put("hsp","hsp222");

        System.out.println(treeMap);

    }
}

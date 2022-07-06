package hsp.chapter14.set_;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSet_ {
    public static void main(String[] args) {
//        TreeSet treeSet = new TreeSet();
        TreeSet treeSet = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
//                return ((String)o1).compareTo((String) o2);//按照字母顺序来排序
                return ((String)o1).length()-((String) o2).length();//按照字符串长度顺序来排序

            }
        });
        treeSet.add("john");
        treeSet.add("tom");
        treeSet.add("luck");
        treeSet.add("milk");//按照字符串长度进行排序时不会加入到treeSet中，因为长度相同
        treeSet.add("sp");
        treeSet.add("a");
        treeSet.add("1");
        treeSet.add("12134");


        System.out.println(treeSet);

    }
}

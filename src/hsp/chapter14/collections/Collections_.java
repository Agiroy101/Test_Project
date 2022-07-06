package hsp.chapter14.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Collections_ {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("tom");
        list.add("tom");
        list.add("hsp");
        list.add("smith");
        list.add("king");
        list.add("lucy");
        System.out.println(list);

        //翻转list中的元素的顺序
        Collections.reverse(list);
        System.out.println(list);

        //对list中元素进行随机排序
        Collections.shuffle(list);
        System.out.println(list);

        //根据元素的自然顺序（字母顺序）对指定list集合元素按升序排序
        Collections.sort(list);
        System.out.println(list);

        //自定义排序
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String) o1).length() - ((String) o2).length();
            }
        });
        System.out.println(list);

        //将指定list集合中的下标i元素和下标j元素进行交换
        Collections.swap(list,0, 1);
        System.out.println(list);


        //根据元素的自然顺序，返回给定集合汇总的最大元素
        System.out.println(Collections.max(list));

        //根据Comparator指定的顺序，返回给定结合中最大的元素
        //比如，返回长度最大的元素
        System.out.println(Collections.max(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String) o1).length() - ((String) o2).length();
            }
        }));
        //最小同理

        //返回制定集合中指定元素的出现的次数
        int sum = Collections.frequency(list, "tom");
        System.out.println(sum);

        //void copy()List dest,List src)将src中的内容复制到dest中

        ArrayList dest = new ArrayList();
        //为了完成一个完整的拷贝，我们需要先给dest赋值，大小和list.size()一样
        for (int i = 0; i < list.size(); i++) {
            dest.add("");
        }
        Collections.copy(dest,list);
        System.out.println(dest);

        //使用新值替换List对象的所有旧值
        Collections.replaceAll(list,"tom", "汤姆");
        System.out.println(list);


    }
}

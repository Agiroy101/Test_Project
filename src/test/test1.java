package test;

public class test1 {
    public static void main(String[] args) {

        int a1 = 3;
        int a2 = 3;

        Integer integer1 = new Integer(3);
        Integer integer2 = new Integer(3);
        Integer integer3 = 3;

        System.out.println("integer3 == 3为  " + (integer3 == 3)+"\n3是常量");
        System.out.println("integer3 == a1为  " + (integer3 == a1)+"\n把integer3的值和3进行比较，因为a1是int ，int是基本数据类型");
        System.out.println("integer3 == integer2为  "+(integer3 == integer2));
        System.out.println("都是Integer变量，区别是非new生成的Integer变量 integer3 指向的是Java常量池中的对象，new生成的Integer变量指向堆中新建的对象，两者在内存中地址不同，所以结果为false。");
        System.out.println("a1 == a2为  " + (a1 == a2)+"\n因为int是基本数据类型");
        System.out.println("integer1.hsp.chapter08.equals(a1)为  " + (integer1.equals(a1)));
        System.out.println("integer1 == integer2为  " + (integer1 == integer2));
        System.out.println("integer1和integer2是两个Integer变量，Integer变量实际上是对Integer对象的引用，而new生成的是两个对象，内存地址不同，所以a和b不相等，结果为false");
        System.out.println("integer1 == 3为  " + (integer1 == 3));
        System.out.println("integer1.hsp.chapter08.equals(integer2)为  " + (integer1.equals(integer2)));

//        String s1 = "asd";
//        String s2 = s1;
//
//        System.out.println(s1 == s2);
//        System.out.println(s1.hashCode());
//        System.out.println(s2.hashCode());
//
//            boolean flag = true;
//        System.out.println(flag);

    }


}

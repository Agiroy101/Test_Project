package hsp.chapter13.wrapper;

public class Exercise01 {
    public static void main(String[] args) {
        //示例1
        Integer i1 = new Integer(127);//只要new一个对象地址肯定不相同
        Integer i2 = new Integer(127);
        System.out.println(i1 == i2);

        //示例2
        Integer i3 = new Integer(128);
        Integer i4 = new Integer(128);
        System.out.println(i3 == i4);

        //示例3
        Integer i5 = 127;//底层是Integer.valueOf(127)
        Integer i6 = 127;//-128~127
        System.out.println(i5 == i6);

        //示例4
        Integer i7 = 128;
        Integer i8 = 128;
        System.out.println(i7 == i8);

        //示例5
        Integer i9 = 127;
        Integer i10 = new Integer(127);
        System.out.println(i9 == i10);

        //示例6
        Integer i11 = 127;
        int i12 = 127;
        System.out.println(i11 == i12);
        //只要有基本数据类型，判断的是值是否相等

        //示例7
        Integer i13 = 128;
        int i14 = 128;
        System.out.println(i13 == i14);

    }
}

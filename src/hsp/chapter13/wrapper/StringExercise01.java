package hsp.chapter13.wrapper;

public class StringExercise01 {
    public static void main(String[] args) {
        String a = "hsp";
        System.out.println(a.hashCode());
        String b = new String("hsp");
        System.out.println(a.equals(b));
        System.out.println(a == b);
        System.out.println(a == b.intern());
        System.out.println(b == b.intern());

        String s11 = "asd";
        System.out.println(s11.hashCode());

        s11 = "bcd";
        System.out.println(s11.hashCode());

        String s22 = a+s11;
        String s33 = "hspbcd";
        System.out.println(s22 == s33);//虽然两个值是一样，但是s22指向的是堆中的一个对象，对象的值指向的是常量池中的"hspbcd"
        //底层是StringBuilder sb = new StringBuilder();sb.append(a);sb.append(b); sb是在堆中,并且append是在原来字符串上的基础追加的
        System.out.println(s22.intern() == s33);
        System.out.println(s22.hashCode());

        String s44 = "hsp" + "bcd";
        System.out.println(s44 == s33);

    }
}

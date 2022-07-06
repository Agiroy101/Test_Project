package hsp.chapter13.wrapper;

public class StringExercise02 {
    String str = new String("hsp");
    final char[] ch = {'j', 'a', 'v', 'a'};

    public void change(String str, char ch[]) {
        str = "java";//这里指向了常量池中java的地址，外部的str的值并没有改变
        ch[0] = 'h';

    }

    public static void main(String[] args) {
        StringExercise02 ex = new StringExercise02();
        ex.change(ex.str, ex.ch);
        System.out.println(ex.str + " and");
        System.out.println(ex.ch);
//        final char[] s = {'a','b'};
//        s[0] = 'c';
//        final char c = 'a';
//        c = 'q';

        String aa = "asd";
        String bb = "asd";
        System.out.println(aa.compareTo(bb));

    }


}

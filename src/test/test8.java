package test;

public class test8 {
    public static void main(String[] args) {
        new a12().calc();
    }
}

class a12 {
    public void calc() {
        long start = System.currentTimeMillis();
        long num = 0;
        for (int i = 0; i < 800000; i++) {
            num += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("执行时间" + (end - start));


    }
}

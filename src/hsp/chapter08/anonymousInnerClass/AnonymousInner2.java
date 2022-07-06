package hsp.chapter08.anonymousInnerClass;

public class AnonymousInner2 {
    public static void main(String[] args) {
        f1(new IA() {
            @Override
            public void test() {
                System.out.println("run.fasst");
            }
        });
    }

    public static void f1(IA ia){
        ia.test();
    }
}
interface IA{
    void test();
}

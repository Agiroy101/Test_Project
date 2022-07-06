package hsp.chapter08.anonymousInnerClass;

public class AnonymousInner {
    public static void main(String[] args) {
        B b = new B();
        b.method();
    }

}

interface A{
    void run();
}

class B {
    public void method(){
        A a = new A() {
            @Override
            public void run() {
                System.out.println("run fast....");
            }
        };
        a.run();
        System.out.println(a.getClass());

    }
}
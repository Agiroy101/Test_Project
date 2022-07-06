package hsp.chapter08.anonymousInnerClass;

public class AnonymousInner1 {
    public static void main(String[] args) {
        Son s = new Son();
        s.method();
        System.out.println(s.hashCode());

    }
}


class Father{
    public void test(){

    }
    public void run(){
        System.out.println("父类的run");
    }

}

abstract class AA{
    abstract void eat();
}

class Son{
    public void test(){
        System.out.println("Son的run。。。");
    }
    public void method(){
        Father f = new Father(){
            @Override
            public void test() {
                System.out.println("重写了父类的test");
            }
        };
        AA a = new AA(){

            @Override
            void eat() {
                System.out.println("eat...");
            }
        };
        a.eat();
        f.run();
        f.test();
        Son.this.test();
        System.out.println(f.getClass());
        System.out.println(Son.this);
    }
}
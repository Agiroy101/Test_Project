package test;

public class test9 {
    public static void main(String[] args) {
        A123 a = new B123();
        System.out.println(a.i);
        System.out.println(a.i);
        //a.play();//会报错
        a.say();
        B123 b = (B123) a;
        System.out.println(b.i);
        b.say();
        b.run();

//        B123 q = new C123();

    }
}

class A123{
    int i  = 9;
    public void run(){
        System.out.println("run");
    }
    public void say(){
        System.out.println("a.say");
    }
}

class B123 extends A123{
    int i = 10;
    public void play(){
        System.out.println("b.run");
    }
    public void say(){
        System.out.println("b.say");
    }
}

class C123 extends B123{
    int i = 11;
    public void say(){
        System.out.println("C.say");
    }
}

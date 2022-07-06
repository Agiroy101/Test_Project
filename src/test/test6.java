package test;

public class test6 {
    public static void main(String[] args) {
        CC a = new CC();

    }
}

class B{
    private int a1 = getA();
    {
        System.out.println("父类普通代码块");
    }
    private static int a2 = getA2();
    static {
        System.out.println("父类静态代码块");
    }
    public int getA(){
        System.out.println("父类普通方法");
        return 100;
    }

    public static int getA2(){
        System.out.println("父类静态方法");
        return 1000;
    }

    public B(){
        System.out.println("父类无参构造器");
    }
    public static void pr(){
        System.out.println("静态方法1111111");
    }
}

class CC extends B{
    private int b = getb();
    {
        System.out.println("子类普通代码块");
    }
    private static int b2 = getb2();
    static {
        System.out.println("子类静态代码块");
    }
    public int getb(){
        System.out.println("子类普通方法");
        return 100;
    }

    public static int getb2(){
        System.out.println("子类静态方法");
        return 1000;
    }

    public CC(){
        System.out.println("子类无参构造器");
    }

}
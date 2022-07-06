package hsp.chapter10.interface_;

public class test1 {
    public static void main(String[] args) {
        B b = new B();
        System.out.println(A.i);
        System.out.println(b.i);
        System.out.println(B.i);
    }
}

interface A{
    int i = 10;

}

class B implements A {

}

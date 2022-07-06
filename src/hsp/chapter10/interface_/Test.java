package hsp.chapter10.interface_;

public class Test{

    public static void main(String[] args) {

    }

}

interface a{
    default void say(){
        System.out.println("a.say");
    }
}

interface b{
    default void say(){
        System.out.println("b.say");
    }
}

class c implements a,b{

    @Override
    public void say() {
        a.super.say();
    }
}

interface d extends a{}

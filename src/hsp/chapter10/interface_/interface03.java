package hsp.chapter10.interface_;

public class interface03 {
    public static void main(String[] args) {
        new CC().PX();
    }
}

interface AA{
    int x = 0;
}

class BB{
    int x = 1;
}

class CC extends BB implements AA{
    public void PX(){
        System.out.println(super.x);
        System.out.println(AA.x);

    }
}
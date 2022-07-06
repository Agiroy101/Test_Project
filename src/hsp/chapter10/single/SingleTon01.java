package hsp.chapter10.single;

public class SingleTon01 {
    public static void main(String[] args) {
        //饿汉式
        GF gf = GF.getGf();
        System.out.println(gf);
    }

}
class GF{
    private String name;

    private static GF gf = new GF("xh");


    private GF(String name) {
        this.name = name;
    }

    public static GF getGf(){
        return gf;
    }

    @Override
    public String toString() {
        return "GF{" +
                "name='" + name + '\'' +
                '}';
    }
}

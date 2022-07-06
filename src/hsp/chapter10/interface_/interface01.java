package hsp.chapter10.interface_;

public interface interface01 {
    public int i = 1;
    public default void play(){
        System.out.println("play");
    }

    public static void say(){
        System.out.println("say");
    }
}

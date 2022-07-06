package hsp.chapter19.standard;

public class InputAndOutput {
    public static void main(String[] args) {

        //System类的 public final static InputStream in = null;
        //System.in 编译类型 InputStream
        //System.in 运行类型 BufferedInputStream
        System.out.println(System.in.getClass());

        //public final static PrintStream out = null;
        //System.out的编译类型 PrintStream
        //System.out的运行类型 PrintStream
        System.out.println(System.out.getClass());



    }
}

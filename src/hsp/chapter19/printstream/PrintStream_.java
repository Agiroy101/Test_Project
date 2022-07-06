package hsp.chapter19.printstream;

import java.io.IOException;
import java.io.PrintStream;

/**
 * @author Agiroy
 * @date 2022/4/20 18:22
 * @effect 演示使用PrintStream（字节打印流/输出流）
 */

public class PrintStream_ {
    public static void main(String[] args) throws IOException {

        PrintStream out = System.out;
        //在默认情况下，PrintStream输出数据的位置是标准输出，即显示器
        /*
        public void print(String s) {
        if (s == null) {
            s = "null";
        }
        write(s);
        }
        */
        out.println("john,hello");
        //因为print底层使用的是write，所以我们可以直接调用wirte进行打印/输出
        out.write("hello,Agiroy".getBytes());

        out.close();


        //我们可以去修改打印流输出的位置/设备
        //1.输出修改到"d:\\b.txt"
        //2."hello,Agiroy22"就会输出到

        System.setOut(new PrintStream("d:\\b.txt"));
        System.out.println("hello,Agiroy22");

    }
}

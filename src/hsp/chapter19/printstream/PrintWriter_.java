package hsp.chapter19.printstream;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Agiroy
 * @date 2022/4/20 18:32
 * @effect
 */

public class PrintWriter_ {
    public static void main(String[] args) throws IOException {
//        PrintWriter printWriter = new PrintWriter(System.out);
        PrintWriter printWriter = new PrintWriter(new FileWriter("d:\\b.txt"));
        printWriter.println("hello,wadsa");
        printWriter.close();
    }
}

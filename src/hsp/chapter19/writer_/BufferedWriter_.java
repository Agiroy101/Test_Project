package hsp.chapter19.writer_;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class BufferedWriter_ {
    public static void main(String[] args) throws Exception{

        String filePath = "d:\\a.txt";

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));
        bufferedWriter.write("hello,Agiroy\n");
        bufferedWriter.write("hello,Agiroy");
        bufferedWriter.newLine();//插入一个和系统相关的换行
        bufferedWriter.write("hello,Agiroy");

        bufferedWriter.close();


    }
}

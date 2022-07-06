package hsp.chapter19.transformation;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * @author Agiroy
 * @date 2022/4/20 18:00
 * @effect 演示OutputStreamWriter使用
 * 把FileOutputStream字节流转成字符流OutputStreamWriter
 * 指定处理的编码 gbk/utf-8/utf8
 */

public class OutputStreamWriter_ {
    public static void main(String[] args) throws Exception{

        String filePath = "d:\\b.txt";
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(filePath),"utf8");
        osw.write("hello,阿萨德千瓦时");
        osw.close();


    }
}

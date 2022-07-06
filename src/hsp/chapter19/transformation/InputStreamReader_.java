package hsp.chapter19.transformation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @author Agiroy
 * @date 2022/4/20 17:49
 * 演示使用InputStreamReader转换流解决中文乱码问题
 * 将字节流转FileInputStream 成字符流InputStreamReader，指定编码UTF-8
 */

public class InputStreamReader_ {
    public static void main(String[] args) throws Exception{

        String filePath = "d:\\a.txt";

        //1.把FileInputStream转成InputStreamReader
        //2.指定编码utf-8(这里的编码指的是filePath地址指定的文件的编码)
        InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath),"gbk");
        //3.把InputStreamReader传入BufferedReader
        BufferedReader br = new BufferedReader(isr);

        //把 2和 3合在一起
//        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath),"gbk"));


        String s = br.readLine();
        System.out.println(s);
        br.close();


    }

}

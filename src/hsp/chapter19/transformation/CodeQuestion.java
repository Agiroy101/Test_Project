package hsp.chapter19.transformation;

import java.io.BufferedReader;
import java.io.FileReader;

public class CodeQuestion {
    public static void main(String[] args) throws Exception{

        //创建字符输入流BufferedReader[字符处理流]
        //使用BufferedReader对象读取a.txt
        //默认情况下，读取文件是按照utf-8编码

        String filePath = "d:\\a.txt";
        BufferedReader br = new BufferedReader(new FileReader(filePath));

        String s = br.readLine();
        System.out.println("读取到的内容为：" + s);
        br.close();



    }
}

package hsp.chapter19.inputStream_;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStream01 {
    public static void main(String[] args) {
        //演示FileInputStream的使用（字节输入流 文件->程序）

    }

    //演示读取文件
    //单个字符的读取，效率比较低
    @Test
    public void readFile01(){
        String filePath = "d:\\hello.txt";
        FileInputStream fileInputStream = null;//扩大作用域
        int readDate = 0;

        try {
            //创建了FileInputStream对象，用于读取文件
            fileInputStream = new FileInputStream(filePath);
            //从该输入流读取一个字节的数据，如果没有输入可用，此方法将阻止
            //如果返回-1，表示读取完毕
            while ((readDate = fileInputStream.read()) != -1){
                System.out.print((char)readDate);//转成char显示
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //使用read(byte[] b)读取文件，提高效率
    @Test
    public void readFile02(){
        String filePath = "d:\\hello.txt";
        FileInputStream fileInputStream = null;//扩大作用域
        int readLen = 0;
        byte[] buf = new byte[9];//一次读取9个字节，一个中文字符占三个字节，正好可以读取三个中文字符
        try {
            //创建了FileInputStream对象，用于读取文件
            fileInputStream = new FileInputStream(filePath);
            //从该输入流读取最多b.length字节的数据到字节数组。此方法将阻塞，直到某些输入可用
            //如果返回-1，表示读取完毕
            //如果读取正常，返回实际读取的字节数
            while ((readLen = fileInputStream.read(buf)) != -1){
                System.out.println(new String(buf, 0 ,readLen));//转成char显示
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

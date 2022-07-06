package hsp.chapter19.outputstream_;

import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStream_ {
    public static void main(String[] args) {

    }

    //演示使用FileOutputStream 将数据写到文件中
    //如果改文件不存在，则创建该文件
    @Test
    public void writeFile(){

        //创建FileOutputStream对象
        String filePath = "d:\\a.txt";
        FileOutputStream fileOutputStream = null;

        try {
            //得到FileOutputStream对象
            //1.new FileOutputStream(filePath)创建方式，当写入内容时，会覆盖原来的内容
            //1.new FileOutputStream(filePath， true)创建方式，当写入内容时，会追加到原来的内容的后面
            fileOutputStream = new FileOutputStream(filePath,true);
            //写入一个字节
//            fileOutputStream.write('H');
            //写入字符串
            String str = "Hello,world!";
            //str.getBytes()可以把字符串转成字符数组
//            fileOutputStream.write(str.getBytes());
            //指定写入字符串指定的下标到另一个指定的下标
            fileOutputStream.write(str.getBytes(),0,str.length());


        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

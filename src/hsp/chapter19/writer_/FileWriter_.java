package hsp.chapter19.writer_;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriter_ {
    public static void main(String[] args) {

        String filePath = "d:\\test.txt";
        //创建FileWriter对象
        FileWriter fileWriter = null;
        char[] chars = {'a', 'b', 'c'};

        try {
            fileWriter = new FileWriter(filePath);
            //write(int)：写入的单个字符
            fileWriter.write("H");

            //write(char[])：写入指定数组
            fileWriter.write(chars);

            //write(char[],off,len)：写入指定数组的指定部分
            fileWriter.write("Agiroy".toCharArray(), 0, 3);

            //write(String)：写入整个字符串
            fileWriter.write("你好世界！");

            //write(String,off,len)：写入字符串的指定部分
            fileWriter.write("上海天津", 0, 2);

            //在数据量打的情况下，可以使用循环操作



        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            //对于FileWriter，一定要关闭流，或者flush才能真正的把刷剧写入到文件
            if (fileWriter != null) {
                try {
                    fileWriter.flush();
                    //关闭文件流，等价flush()+关闭
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("程序结束");

    }
}

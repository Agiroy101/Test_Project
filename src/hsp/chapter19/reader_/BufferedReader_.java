package hsp.chapter19.reader_;

import java.io.BufferedReader;
import java.io.FileReader;

public class BufferedReader_ {
    public static void main(String[] args) throws Exception{

        String filePath = "d:\\hello.txt";
        //创建bufferedReader
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        //读取
        String line;//按行读取，效率高
        //1.bufferedReader.readLine()是按行读取文件
        //2.当返回null时u，表示文件读取完毕
        while ((line = bufferedReader.readLine())!= null){
            System.out.println(line);
        }

        //关闭流，这里注意，只需要关闭BufferedReader，因为底层会自动关闭节点流
        bufferedReader.close();

    }
}

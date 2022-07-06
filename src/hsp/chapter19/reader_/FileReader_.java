package hsp.chapter19.reader_;

import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;

public class FileReader_ {
    public static void main(String[] args) {

    }

    //单个字符读取
    @Test
    public void readFile01() {
        String filePath = "d:\\hello.txt";
        FileReader fileReader = null;
        int data = 0;
        //1.创建FileReader对象
        try {
            fileReader = new FileReader(filePath);
            //循环读取 使用read,单个字符读取
            while ((data = fileReader.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //使用字符数组读取
    @Test
    public void readFile02() {
        String filePath = "d:\\hello.txt";
        FileReader fileReader = null;
        int readLen = 0;
        char[] buf = new char[9];
        //1.创建FileReader对象
        try {
            fileReader = new FileReader(filePath);
            //循环读取 使用read(buf),返回的是实际读取到的字符数
            //如果返回-1，说明文件到结尾
            while ((readLen = fileReader.read(buf)) != -1) {
                System.out.print(new String(buf, 0, readLen));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}


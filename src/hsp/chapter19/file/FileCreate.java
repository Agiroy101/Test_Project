package hsp.chapter19.file;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class FileCreate {
    public static void main(String[] args) {

    }

    //方式1 new File(String pathname)
    @Test
    public void create01(){
        String filepath = "d:\\news1.txt";
        File file = new File(filepath);
        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件创建失败");
        }
    }

    //方式2 new File(File parent, String child)//根据父目录文件+子路径构建(绝对路径+相对路径)
    @Test
    public void create02(){
        File parentFile = new File("d:\\");
        String fileName = "news2.txt";
        //这里的file对象，在java程序中，只是一个对象
        //只有执行了createNewFile()方法，才会真正的，在磁盘创建该文件
        File file = new File(parentFile, fileName);

        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //方式3 new File(String parent, String child)//根据父目录+子路径构建，这个和第二种方法的区别是第二种方法父目录是文件类型，第三种是字符串类型
    public void create03(){
        String parentPath = "e:\\";
//        String parentPath = "e:/";//也可以这么写
        String fileName = "news3.txt";
        File file = new File(parentPath, fileName);

        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

package hsp.chapter19.file;

import org.junit.jupiter.api.Test;

import java.io.File;

public class FileInformation {
    public static void main(String[] args) {

    }

    //获取文件的信息
    @Test
    public void info() {
        //先创建文件对象
//        File file = new File("d://news1.txt");
        File file = new File("d://5e");

        //调用相应的方法，得到对应信息
        System.out.println("文件名字=" + file.getName());

        //获取绝对路径
        System.out.println("文件绝对路径=" + file.getAbsolutePath());

        //获得文件父级目录
        System.out.println("文件父级目录=" + file.getParent());

        //获得文件大小（字节）
        System.out.println("文件大小（字节）=" + file.length());

        //文件是否存在
        System.out.println("文件是否存在=" + file.exists());

        //是不是一个文件
        System.out.println("是不是一个文件= " + file.isFile());

        //是不是一个目录
        System.out.println("是不是一个目录=" + file.isDirectory());

    }


}

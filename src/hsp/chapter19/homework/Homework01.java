package hsp.chapter19.homework;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * @author Agiroy
 * @date 2022/4/21 14:06
 * @effect
 */

public class Homework01 {
    public static void main(String[] args) throws Exception{

        String directionPath = "d:\\mytemp";
        File file = new File(directionPath);
        if(!file.exists()){
            if(file.mkdir()){
                System.out.println("创建目录成功");
            }else {
                System.out.println("创建目录失败");
            }
        }else {
            System.out.println("目录已经存在");
        }
        String filePath = directionPath + "\\hello.txt";
        file = new File(filePath);
        if (!file.exists()){
            if(file.createNewFile()){
                System.out.println("文件创建成功");
                BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
                bw.write("hello world1!");

                bw.close();
            }else {
                System.out.println("文件创建失败");
            }
        }else {
            System.out.println("文件已经存在");
        }


    }
}

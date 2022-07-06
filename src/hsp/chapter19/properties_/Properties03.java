package hsp.chapter19.properties_;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Agiroy
 * @date 2022/4/20 18:49
 * @effect
 */

public class Properties03 {
    public static void main(String[] args) throws IOException {
        //使用Properties类来创建配置文件或者修改配置文件

        Properties properties = new Properties();
        //创建
        //如果该文件没有key，就是创建
        //如果该文件有key，就是修改
        properties.setProperty("charset","utf8");
        properties.setProperty("user","汤姆");
        properties.setProperty("pwd","avxc");

        //将k-v存储到文件中
        properties.store(new FileOutputStream("D:\\Test_Project\\src\\hsp\\chapter19\\mysql2.properties"),"hello world");//第二个参数会在生成该文件时生成注释

        System.out.println("保存配置文件成功");


    }
}

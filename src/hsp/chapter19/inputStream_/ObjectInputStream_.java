package hsp.chapter19.inputStream_;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ObjectInputStream_ {
    public static void main(String[] args) throws Exception{

        //指定反序列化的文件
        String filePath = "d:\\data.txt";

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));

        //读取
        //读取（反序列化）的顺序需要和你保存数据（序列化）的顺序一致
        //否则会出现异常

        System.out.println(ois.readInt());
        System.out.println(ois.readBoolean());
        System.out.println(ois.readChar());
        System.out.println(ois.readDouble());
        System.out.println(ois.readUTF());
        Object o = ois.readObject();
        System.out.println("运行类型为：" + o.getClass());
        System.out.println("Dog的信息为：" + o);

        //关闭流，关闭外层刘
        ois.close();


    }
}



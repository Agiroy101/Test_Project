package hsp.chapter19.outputstream_;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectOutStream_ {
    public static void main(String[] args) throws Exception{
        //序列化后，保存的文件格式，不是纯文本，而是按照他的格式来,无论文件后缀是什么
        String filePath = "d:\\data.txt";

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));

        //序列化数据到d:\\data.tx
        oos.writeInt(100);//int -> Integer(实现了Serializable)
        oos.writeBoolean(true);//boolean -> Boolean(实现了Serializable)
        oos.writeChar('s');//char -> Character(实现了Serializable)
        oos.writeDouble(9.5);//double -> Double(实现了Serializable)
        oos.writeUTF("Agiroy");//String (实现了Serializable)
        //保存一个Dog对象
        oos.writeObject(new Dog("旺财",2));

        oos.close();
        System.out.println("数据保存完毕");


    }
}

//如果需要序列化某个类的对象，实现Serializable接口
class Dog implements Serializable {
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

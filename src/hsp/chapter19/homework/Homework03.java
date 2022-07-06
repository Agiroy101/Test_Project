package hsp.chapter19.homework;

import java.io.*;
import java.util.Properties;

/**
 * @author Agiroy
 * @date 2022/4/21 14:37
 * @effect
 */

public class Homework03 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Properties properties = new Properties();
        properties.load(new FileReader("D:\\Test_Project\\src\\hsp\\chapter19\\homework\\dog.properties"));
        properties.list(System.out);
        Dog dog = new Dog(properties.getProperty("name"), Integer.parseInt(properties.getProperty("age")), properties.getProperty("color"));
        String filePath="d:\\a.txt";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));
        oos.writeObject(dog);

        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));
        System.out.println(ois.readObject());
        ois.close();



    }
}

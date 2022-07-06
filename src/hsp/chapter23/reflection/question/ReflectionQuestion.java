package hsp.chapter23.reflection.question;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author Agiroy
 * @date 2022/4/29 14:22
 * @effect 反射问题的引入
 */

public class ReflectionQuestion {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        //根据配置文件re.properties指定信息，创建Cat对象并调用方法hi

        //传统方式 new对象->调用方法
//        Cat cat = new Cat();
//        cat.hi();

        //1.使用properties类，可以读写配置文件
        Properties properties = new Properties();


//        properties.load(new FileInputStream("src:\\hsp\\chapter23\\re.properties"));
        properties.load(new FileInputStream("D:\\Test_Project\\src\\hsp\\chapter23\\re.properties"));
        String classfullpath = properties.get("classfullpath").toString();
        String method = properties.get("method").toString();
        System.out.println("classfullpath: " + classfullpath + "  method: "+ method);

        //2.创建对象，传统的方法，行不通 -> 反射机制
        //new classfullpath();

        //3.使用反射机制解决
        //（1）加载类,返回Class类型的对象
        Class aClass = Class.forName(classfullpath);

        //(2)通过aclass得到你加载的类hsp.chapter23.Cat的对象实例
        Object o = aClass.newInstance();
        System.out.println(o.getClass());

        //（3）通过aClass得到你加载的类 hsp.chapter23.Cat 的method的方法对象
        // 即：在反射中。可以把方法视为对象
        Method method1 = aClass.getMethod(method);

        //（4）通过method1调用方法，即通过方法对象来实现调用方法
        method1.invoke(o);//传统方法 对象.方法(),反射机制 方法.invoke(对象)

    }

}

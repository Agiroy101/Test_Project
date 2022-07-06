package hsp.chapter23.reflection;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author Agiroy
 * @date 2022/4/29 16:02
 * @effect
 */

public class Reflection01 {

    public static void main(String[] args) throws Exception {

        Properties properties = new Properties();
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

        //得到name字段
        //getFiled不能得到私有的属性
        Field nameField = aClass.getField("age");
        System.out.println(nameField.get(o));//传统写法 对象.成员变量    反射：成员变量对象.get(对象)

        //java.lang.reflect.Constructor:代表类的构造方法，Constructor对象表示构造器
        Constructor constructor = aClass.getConstructor();//getConstructor()中可以指定勾走爱情参数类型，现在默认返回无参构造器
        System.out.println(constructor);//Cat()

        Constructor constructor2 = aClass.getConstructor(String.class);//这里传入的String.class 就是String类的Class对象
        System.out.println(constructor2);//Cat(String name)


    }
}

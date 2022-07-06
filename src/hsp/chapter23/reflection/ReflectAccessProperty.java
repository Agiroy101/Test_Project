package hsp.chapter23.reflection;

import java.lang.reflect.Field;

/**
 * @author Agiroy
 * @date 2022/5/2 18:41
 * @effect 演示反射操作属性
 */

public class ReflectAccessProperty {
    public static void main(String[] args) throws Exception {

        //1.得到Student类对应的Class对象
        Class<?> cls = Class.forName("hsp.chapter23.reflection.Student");

        //2.创建对象
        Object o = cls.newInstance();
        System.out.println(o.getClass());

        //3.使用反射得到age属性对象
        Field age = cls.getField("age");
        age.set(o,88);//通过反射来操作属性
        System.out.println(o);
        System.out.println(age.get(o));//返回age属性的值

        //4.使用反射操作name属性
        Field name = cls.getDeclaredField("name");
        //对name进行爆破
        name.setAccessible(true);
        name.set(null,"Agiroy");//以为name是static属性，因此o也可以写成null
        System.out.println(o);
        System.out.println(name.get(o));//获取属性值
        System.out.println(name.get(null));//获取属性值，要求name是static

    }
}

class Student{
    public int age;
    private static String name;

    public Student(){

    }

    @Override
    public String toString() {
        return "Student{" + "name = " + name +
                " age = " + age +
                '}';
    }
}

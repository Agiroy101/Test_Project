package hsp.chapter23.reflection;

import java.lang.reflect.Constructor;

/**
 * @author Agiroy
 * @date 2022/5/2 18:29
 * @effect 演示通过反射机制创建实例
 */

public class ReflectCreateInstance {

    public static void main(String[] args) throws Exception {

        //1.先获取到User类的Class对象
        Class<?> cls = Class.forName("hsp.chapter23.reflection.User");

        //2.通过public的无参构造器创建实例
        Object o = cls.newInstance();
        System.out.println(o);

        //3.通过public的有参构造器创建实例
        /*
        * constructor对象就是
            public User(String name){
                this.name = name;
            }
        *这个构造器
        * */
        Constructor<?> constructor = cls.getConstructor(String.class);
        Object hsp = constructor.newInstance("hsp");//这里传的值就是构造器中的形参
        System.out.println(hsp);

        //4.通过非public的有参构造器创建实例
        Constructor<?> constructor1 = cls.getDeclaredConstructor(int.class, String.class);
        constructor1.setAccessible(true);//爆破（暴力破解），使用反射可以访问private构造器
        Object agiroy = constructor1.newInstance(100, "Agiroy");
        System.out.println(agiroy);

    }

}

class User {
    private int age = 10;

    private String name = "Agiroy";

    public User() {
    }

    public User(String name){
        this.name = name;
    }

    private User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

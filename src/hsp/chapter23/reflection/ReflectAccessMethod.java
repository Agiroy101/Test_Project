package hsp.chapter23.reflection;

import java.lang.reflect.Method;

/**
 * @author Agiroy
 * @date 2022/5/2 18:53
 * @effect 演示通过反射调用方法
 */

public class ReflectAccessMethod {

    public static void main(String[] args) throws Exception {

        //1.得到Boss类对应Class对象
        Class<?> cls = Class.forName("hsp.chapter23.reflection.Boss");

        //2.创建对象
        Object o = cls.newInstance();

        //3.调用public的hi方法
        Method hi = cls.getMethod("hi",String.class);//如果调用的方法是有参的，那么第二个参数是方法的形参

        //调用方法
        hi.invoke(o,"Agiroy");

        //调用private static方法
        //得到say方法对象
        Method say = cls.getDeclaredMethod("say", int.class,String.class, char.class);
        say.setAccessible(true);
        System.out.println(say.invoke(o,3,"Agiroy",'H'));
        //因为say方法是static的，还可以这样调用
        System.out.println(say.invoke(null,4,"Agiroy",'5'));

        //5.在反射中，如果方法有返回值，统一返回Object,但是运行类型和方法定义的返回类型一致
        Object reVal = say.invoke(null, 123, "Agiroy", '1');
        System.out.println("reVal 的运行类型 = " + reVal.getClass());


    }

}

class Boss{
    public int age;
    private static String name;

    public Boss(){

    }

    private static  String say(int n, String s, char c){
        return n + " " + s + " " + c;
    }

    public void hi(String s){
        System.out.println("hi " + s);
    }
}
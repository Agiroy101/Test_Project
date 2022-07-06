package hsp.chapter23.reflection.homework;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author Agiroy
 * @date 2022/5/2 19:07
 * @effect
 */

public class Homework01 {
    public static void main(String[] args) throws Exception {
        Class<?> cls = Class.forName("hsp.chapter23.reflection.homework.PrivateTest");
        Object o = cls.newInstance();
        Field name = cls.getDeclaredField("name");
        name.setAccessible(true);
        name.set(o,"hello");
        Method getName = cls.getMethod("getName");
        System.out.println(getName.invoke(o));

    }
}

class PrivateTest{
    private String name = "hellokitty";
    public String getName(){
        return name;
    }
}

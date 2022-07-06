package hsp.chapter23.reflection.homework;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author Agiroy
 * @date 2022/5/2 19:15
 * @effect
 */

public class Homework02 {
    public static void main(String[] args) throws Exception {
        Class<?> cls = Class.forName("java.io.File");
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }

        Constructor<?> declaredConstructor = cls.getDeclaredConstructor(String.class);
        Object o = declaredConstructor.newInstance("d:\\aa.txt");
        Method createNewFile = cls.getMethod("createNewFile");
        createNewFile.invoke(o);
    }
}

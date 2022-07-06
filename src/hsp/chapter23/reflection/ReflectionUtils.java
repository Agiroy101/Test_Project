package hsp.chapter23.reflection;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author Agiroy
 * @date 2022/5/2 16:29
 * @effect 演示如何通过反射获取类的结构信息
 */

public class ReflectionUtils {
    public static void main(String[] args) {

    }

    //第一组方法API
    @Test
    public void api_01() throws Exception {

        //得到Class对象
        Class<?> personCls = Class.forName("hsp.chapter23.reflection.Person");

        //getName获取全类名
        System.out.println(personCls.getName());//hsp.chapter23.reflection.Person

        //getSimpleName:获取简单类名
        System.out.println(personCls.getSimpleName());//Person

        //getFields:获取所有public修饰的属性，包含本类以及父类
        Field[] fields = personCls.getFields();
        for (Field field : fields) {
            System.out.println("本类以及父类的属性 = " + field.getName());
        }

        //getDeclareFields:获取本类中所有属性
        Field[] declaredFields = personCls.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("本类中所有属性" + declaredField.getName());
        }

        //getMethods:获取所有public修饰的方法，包含本类以及父类的
        Method[] methods = personCls.getMethods();
        for (Method method : methods) {
            System.out.println("本类以及父类的方法 = " + method.getName());
        }

        //getDeclaredMethods:获取本类中所有方法
        Method[] declaredMethods = personCls.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("本类中所有方法 = " + declaredMethod.getName());
        }

        //getConstructors:获取所有public修饰的构造器，包含本类
        Constructor<?>[] constructors = personCls.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println("本类的构造器 = " + constructor.getName());
        }

        //getDeclaredConstructors:获取本类中所有构造器
        Constructor<?>[] declaredConstructors = personCls.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println("本类中所有构造器" + declaredConstructor.getName());
        }

        //getPackage:以Package形式返回包的信息
        System.out.println(personCls.getPackage());//hsp.chapter23.reflection

        //getSuperClass:以Class形式返回父类信息
        System.out.println(personCls.getSuperclass());//hsp.chapter23.reflection.A

        //getInterfaces:以Class[]形式返回接口信息
        Class<?>[] interfaces = personCls.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println("接口信息 = " + anInterface);
        }

        //getAnnotations:以Annotation[]形式返回注解信息
        Annotation[] annotations = personCls.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("注解信息 = " + annotation);
        }


    }

    @Test
    public void api_02() throws Exception {
        //得到Class对象
        Class<?> personCls = Class.forName("hsp.chapter23.reflection.Person");
        //getDeclareFields:获取本类中所有属性
        //规定 默认修饰符是0， public 是 1，private 是 2, protected 是 4，static 是 8，final 是 16 (public(1) + static(8) = 9)
        Field[] declaredFields = personCls.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("本类中所有属性" + declaredField.getName()
                    + " 该属性的修饰符值 = " + declaredField.getModifiers()
                    + " 该属性的类型 = " + declaredField.getType()
            );
        }

        //getDeclaredMethods:获取本类中所有方法
        Method[] declaredMethods = personCls.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("本类中所有方法 = " + declaredMethod.getName()
                + " 该方法的访问修饰符值 = " + declaredMethod.getModifiers()
                + " 该方法的返回类型 = " + declaredMethod.getReturnType()
            );
            Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println("该方法的形参类型 = " + parameterType);
            }
        }

        //getDeclaredConstructors:获取本类中所有构造器
        Constructor<?>[] declaredConstructors = personCls.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println("本类中所有构造器" + declaredConstructor.getName());

            Class<?>[] parameterTypes = declaredConstructor.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println("该构造器的形参类型 = " + parameterType);
            }

        }

    }


}

interface IA {
}

interface IB {
}

class A {
    public String hobby;

    public A() {
    }
}

@Deprecated
class Person extends A implements IA, IB {

    //属性
    public String name;
    protected int age;
    String job;
    private double sal;

    public Person() {
    }

    public Person(String name) {
    }

    private Person(String name, int age) {
    }

    //方法
    public void m1(String name, int age, double sal) {

    }

    protected void m2() {

    }

    void m3() {

    }

    private void m4() {

    }
}

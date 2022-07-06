package hsp.chapter23.reflection;

import hsp.chapter23.Cat;

import java.lang.reflect.Method;

/**
 * @author Agiroy
 * @date 2022/4/29 16:02
 * @effect 测试反射调用的性能和优化方案
 */

public class Reflection02 {

    public static void main(String[] args) throws Exception {

        m1();
        m2();
        m3();

    }

    //传统方法来调用hi

    public static void m1() {
        Cat cat = new Cat();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 900000000; i++) {
            cat.hi();
        }
        long end = System.currentTimeMillis();
        System.out.println("传统方法来调用hi用时：" + (end - start));


    }

    //反射机制调用方法hi
    public static void m2() throws Exception {
        Class<?> aClass = Class.forName("hsp.chapter23.Cat");
        Object o = aClass.newInstance();
        Method hi = aClass.getMethod("hi");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 900000000; i++) {
            hi.invoke(o);//反射调用方法
        }
        long end = System.currentTimeMillis();
        System.out.println("反射机制来调用hi用时：" + (end - start));

    }

    //反射调用优化 + 关闭访问检查
    public static void m3() throws Exception {
        Class<?> aClass = Class.forName("hsp.chapter23.Cat");
        Object o = aClass.newInstance();
        Method hi = aClass.getMethod("hi");
        hi.setAccessible(true);//在反射调用方法时，取消访问检查
        long start = System.currentTimeMillis();
        for (int i = 0; i < 900000000; i++) {
            hi.invoke(o);//反射调用方法
        }
        long end = System.currentTimeMillis();
        System.out.println("反射机制来调用hi用时：" + (end - start));

    }
}

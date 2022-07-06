package hsp.chapter23.reflection.class_;

/**
 * @author Agiroy
 * @date 2022/4/29 20:44
 * @effect 对Class类特点的梳理
 */

public class Class01 {
    public static void main(String[] args) throws Exception {

        //1.Class也是类，因此也继承Object类
        //2.Class类对象不是new出来的，而是系统创建的
        //(1)传统new对象
        /*ClassLoader类
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                return loadClass(name, false);
            }
        */
//        Cat cat = new Cat();

        //(2)反射方式  (只会加载一次Class类对象，所以传统方式new Cat对象在的情况下，反射方式追到不到下面的源码，即第三点)

        /*ClassLoader类，仍然是通过ClassLoader类加载Cat类的Class对象
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                return loadClass(name, false);
            }
        */
        Class aClass = Class.forName("hsp.chapter23.Cat");

        //(3)对于某个类的Class类对象，在内存中只有一份，因为只加载一次
        Class aClass2 = Class.forName("hsp.chapter23.Cat");
        System.out.println(aClass.hashCode());
        System.out.println(aClass2.hashCode());

    }
}

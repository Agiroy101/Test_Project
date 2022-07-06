package hsp.chapter23.reflection.class_;

import hsp.chapter23.Car;

/**
 * @author Agiroy
 * @date 2022/5/2 14:11
 * @effect 演示得到Class对象的各种方式(6种)
 */

public class GetClass_ {
    public static void main(String[] args) throws Exception {

        //1.Class.forName
        String classAllpath = "hsp.chapter23.Car";//一般通过读取配置文件获取
        Class<?> cls1 = Class.forName(classAllpath);
        System.out.println(cls1);

        //2.类名.class，应用场景：用于参数传递
        Class<Car> cls2 = Car.class;
        System.out.println(cls2);

        //3.对象,getClass()，应用场景：有对象实例
        Car car = new Car();
        Class<? extends Car> cls3 = car.getClass();
        System.out.println(cls3);

        //4.通过类加载器【4种】来获取到类的Class对象
        //(1)先得到类加载器car
        ClassLoader classLoader = car.getClass().getClassLoader();
        //(2)通过类加载器得到Class对象
        Class<?> cls4 = classLoader.loadClass(classAllpath);
        System.out.println(cls4);

        //cls1,cls2,cls3,cls4其实是同一个对象
        System.out.println(cls1.hashCode());
        System.out.println(cls2.hashCode());
        System.out.println(cls3.hashCode());
        System.out.println(cls4.hashCode());

        //5.基本数据类型(int,char,boolean,float,double,byte,long,short)按如下方式得到Class类对象
        Class<Integer> integerClass = int.class;
        Class<Character> characterClass = char.class;
        Class<Boolean> booleanClass = boolean.class;
        System.out.println(integerClass);//int

        //6.基本数据类型对应的包装类，可以通过.TYPE得到Class类对象
        Class<Integer> type1 = Integer.TYPE;
        Class<Character> type2 = Character.TYPE;
        System.out.println(type1);

        System.out.println(integerClass.hashCode());
        System.out.println(type1.hashCode());

    }
}
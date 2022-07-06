package hsp.chapter23.reflection.class_;

import hsp.chapter23.Car;

import java.lang.reflect.Field;

/**
 * @author Agiroy
 * @date 2022/4/29 23:57
 * @effect 演示Class类的常用方法
 */

public class Class02 {
    public static void main(String[] args) throws Exception {

        String classAllPath = "hsp.chapter23.Car";
        //获取到Car类对应的Class对象
        //<?>表示不确定的Java类型
        Class<?> cls = Class.forName(classAllPath);
        //输出cls
        System.out.println(cls);//显示cls对象，是哪个类的Class对象
        System.out.println(cls.getClass());//输出cls运行类型 java.lang.Class
        //得到包名
        System.out.println(cls.getPackage().getName());
        //得到类的名称(全类名)
        System.out.println(cls.getName());
        //通过cls创建对象实例
        Car car = (Car) cls.newInstance();
        System.out.println(car);//car.toString()
        //通过反射获取属性brand
        Field brand = cls.getField("brand");
        System.out.println(brand.get(car));
        //通过反射给属性赋值
        brand.set(car,"奔驰");
        System.out.println(brand.get(car));
        //得到所有的属性
        System.out.println("=======所有字段的属性========");
        Field[] fields = cls.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

    }

}

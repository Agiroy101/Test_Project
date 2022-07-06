package hsp.chapter15.generic;

import java.util.ArrayList;
import java.util.List;

public class GenericExtends {
    public static void main(String[] args) {

        Object o = new String("xx");

        //泛类没有继承性
//        List<Object> list = new ArrayList<String>();

        ArrayList<Object> list = new ArrayList<>();
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<A> list2 = new ArrayList<>();
        ArrayList<B> list3 = new ArrayList<>();
        ArrayList<C> list4 = new ArrayList<>();

        //如果是List<?> c，可以接受任意的泛型类型
        printCollection1(list);
        printCollection1(list1);
        printCollection1(list2);
        printCollection1(list3);
        printCollection1(list4);

        //<? extends A>表示上限，可以接受A或者A的子类
//        printCollection2(list);//×
//        printCollection2(list1);//×
        printCollection2(list2);
        printCollection2(list3);
        printCollection2(list4);

        //<? super A>表示下限，可以接受A类或者A类的父类，不限于直接父类（可以接受基类或超类）
        printCollection3(list);
//        printCollection3(list1);//×
        printCollection3(list2);
//        printCollection3(list3);//×
//        printCollection3(list4);//×


    }

    //<?>表示支持任意泛型类型
    public static void printCollection1(List<?> c){
        for (Object o : c) {
            System.out.println(o.getClass());
        }

    }

    //<? extends A>表示上限，可以接受A或者A的子类
    public static void printCollection2(List<? extends A> c){
        for (Object o : c) {
            System.out.println(o);
        }
    }

    //<? super A>表示下限，可以接受A类或者A类的父类，不限于直接父类（可以接受基类或超类）
    public static void printCollection3(List<? super A> c){
        for (Object o : c) {
            System.out.println(o);
        }
    }

}

class A{}

class B extends A{}

class C extends B{}
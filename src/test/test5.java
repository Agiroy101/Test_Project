package test;

public class test5 {
    public static void main(String[] args) {
//        System.out.println(Person.getSum());
//        Person person = new Person();
//        System.out.println(Person.getSum());

        m();
    }

    public static void m(){
        String[] a = new String[2];
        a[0] = "213";

        main(a);
    }

}
class Person{
    private static int sum = 0;
    public static int getSum(){
        return sum;
    }
    public  Person(){
        sum++;
    }
    public void Person(){           //static关键不能在这里使用，会报错
        sum++;
    }
}



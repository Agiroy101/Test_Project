package hsp.chapter12.exception;

import hsp.homework.homework1.Person;

public class Exception01 {
    public static void main(String[] args)  throws Exception {
        int i = 10;
        int i1 = 0;
        try {
            Person person = new Person("asd", 'c', 123);
            person = null;
            System.out.println(person.getName());
            int res = i / i1;
        }catch (ArithmeticException e) {
            System.out.println("算数异常：" + e.getMessage());
        }catch (NullPointerException e){
            System.out.println("空指针异常：" + e.getMessage());
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println("出现异常的原因：" + e.getMessage());
        }
        System.out.println("程序继续");
    }
}

package test;

public class test2 {
    static class Person {//父类
        int i = 10;
        public void run() {
            System.out.println("personrun");
        }
        public void eat() {
            System.out.println("personeat");
        }
        public int getI() {
            return i;
        }
    }

    static class Student extends Person {
        int i = 20;
        public void run() {
            System.out.println("studentrun");
        }
        public void study() {
            System.out.println("stduentstudy..");
        }

        public int getI() {
            return i;
        }
    }

    public static void main(String[] args) {
        Person p = new Student();
        p.run();
        p.eat();
        System.out.println(p.getI());
        System.out.println(p.i);


        Student s = (Student)p;
        s.run();
        s.study();
        s.eat();
        System.out.println(p.getI());
        System.out.println(p.i);
    }


}

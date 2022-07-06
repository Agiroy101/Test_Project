package hsp.chapter15.generic;

import java.util.*;

public class GenericExercise {
    public static void main(String[] args) {

        HashSet<Student> set = new HashSet<>();
        set.add(new Student("Agiroy", 21));
//        set.add(11);//报错
        Iterator<Student> iterator = set.iterator();
        while (iterator.hasNext()) {
            Student next = iterator.next();
            System.out.println(next);
        }



        HashMap<String, Student> map = new HashMap<>();
        map.put("zs",new Student("Agiroy",21));
        map.put("ls",new Student("john",21));
        map.put("ww",new Student("apex",21));
        map.put("zl",new Student("simple",21));
        Set<String> strings = map.keySet();
        Iterator<String> iterator1 = strings.iterator();
        while (iterator1.hasNext()) {
            String next = iterator1.next();
            System.out.println(next + "-" + map.get(next));
        }

        Set<Map.Entry<String, Student>> entries = map.entrySet();
        Iterator<Map.Entry<String, Student>> iterator2 = entries.iterator();
        while (iterator2.hasNext()) {
            Map.Entry<String, Student> next = iterator2.next();
            System.out.println(next.getKey() + "-" + next.getValue());
        }


    }
}

class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

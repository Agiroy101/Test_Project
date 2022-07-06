package hsp.chapter08.equals;

import java.util.Objects;

public class Test {
    public static void main(String[] args) {
        Person person = new Person("zs", 21, '男');

        Person person1 = new Person("zs", 21, '男');


//        System.out.println(person.hsp.chapter08.equals(person1));
//        System.out.println(person.getClass());
        System.out.println(person);
        System.out.println(person.hashCode());
        System.out.println(person.toString());
        person = null;
        person1 = null;
        System.gc();

    }


}

class Person{

    private String name;
    private int age;
    private char gender;

    public Person(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && gender == person.gender && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, gender);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }

    @Override
    protected void finalize() throws Throwable {

        System.out.println("释放资源");

    }
}

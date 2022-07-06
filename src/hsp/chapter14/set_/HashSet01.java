package hsp.chapter14.set_;

import java.util.HashSet;
import java.util.Objects;

public class HashSet01 {
    public static void main(String[] args) {
        HashSet set = new HashSet();
        set.add(new Employee("zs",12,1234,new MyDate(2022,2,2)));
        set.add(new Employee("zs",21,1234,new MyDate(2022,2,22)));
        set.add(new Employee("zs",12,1234,new MyDate(2022,2,2)));
        System.out.println(set);
    }
}
class Employee{
    private String name;
    private int age;
    private double sal;
    private MyDate birthday;

    public Employee(String name, int age, double sal, MyDate birthday) {
        this.name = name;
        this.age = age;
        this.sal = sal;
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && Objects.equals(birthday, employee.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthday);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sal=" + sal +
                ", birthday=" + birthday +
                '}';
    }
}

class MyDate{
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyDate myDate = (MyDate) o;
        return year == myDate.year && month == myDate.month && day == myDate.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }
}
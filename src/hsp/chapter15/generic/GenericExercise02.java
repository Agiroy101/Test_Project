package hsp.chapter15.generic;

import java.util.ArrayList;
import java.util.Comparator;

public class GenericExercise02 {
    public static void main(String[] args) {
        ArrayList<Employee> list = new ArrayList<>();
        list.add(new Employee("zs", 2000, new Mydate(2022, 2, 2)));
        list.add(new Employee("ls", 4000, new Mydate(2022, 2, 24)));
        list.add(new Employee("ww", 1000, new Mydate(2020, 2, 22)));
        list.add(new Employee("zs", 5000, new Mydate(2022, 2, 12)));
        list.add(new Employee("zs", 3000, new Mydate(2022, 1, 2)));
        list.add(new Employee("xh", 2000, new Mydate(2021, 2, 2)));


        list.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (o1.getName().equals(o2.getName())) {
                    if (o1.getBirthday().getYear() != o2.getBirthday().getYear()) {
                        return o1.getBirthday().getYear() - o2.getBirthday().getYear();
                    } else if (o1.getBirthday().getMonth() != o2.getBirthday().getMonth()) {
                        return o1.getBirthday().getMonth() - o2.getBirthday().getMonth();
                    } else
                        return o1.getBirthday().getDay() - o2.getBirthday().getDay();
                } else {
                    return o1.getName().compareTo(o2.getName());
                }
            }
        });

        for (Employee employee : list) {
            System.out.println(employee);
        }
    }
}


class Employee {
    private String name;
    private double sal;
    private Mydate birthday;

    public Employee(String name, double sal, Mydate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public Mydate getBirthday() {
        return birthday;
    }

    public void setBirthday(Mydate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday=" + birthday;
    }
}

class Mydate {
    private int month;
    private int day;
    private int year;

    public Mydate(int year, int month, int day) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return year + "-" + month + "-" + day;
    }
}
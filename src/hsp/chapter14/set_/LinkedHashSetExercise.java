package hsp.chapter14.set_;

import java.util.LinkedHashSet;
import java.util.Objects;

public class LinkedHashSetExercise {
    public static void main(String[] args) {
        LinkedHashSet set = new LinkedHashSet();
        set.add(new car("bmw",12));
        set.add(new car("ad",12));
        set.add(new car("bmw",12));

        System.out.println(set);
    }
}
class car{
    private String name;
    private double price;

    public car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        car car = (car) o;
        return Double.compare(car.price, price) == 0 && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return "car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

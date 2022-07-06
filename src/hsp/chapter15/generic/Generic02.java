package hsp.chapter15.generic;

public class Generic02 {
    public static void main(String[] args) {
        Person<String> person = new Person<>("Agiroy");
        System.out.println(person.s.getClass());
    }
}

class Person<E> {
    E s;

    public Person(E s) {
        this.s = s;
    }

    public E f(){
        return s;
    }
}

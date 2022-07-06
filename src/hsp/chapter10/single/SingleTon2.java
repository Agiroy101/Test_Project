package hsp.chapter10.single;

public class SingleTon2 {
    //懒汉式
    public static void main(String[] args) {
        System.out.println(Dog.i);
        System.out.println(Dog.getDog());

    }
}

class Dog{

    public static int i = 100;

    private String name;
    private static Dog dog;

    private Dog(String name) {
        System.out.println("有参构造器");
        this.name = name;
    }

    public static Dog getDog(){
        if(dog == null){
            dog = new Dog("闪电");
        }
        return dog;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}

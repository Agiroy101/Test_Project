package hsp.chapter15.homework;

import org.junit.jupiter.api.Test;

import java.util.*;

public class Homework {
    public static void main(String[] args) {
        Dao<User> dao = new Dao<>();
        dao.save("1",new User(1,21,"zs"));
        dao.save("2",new User(2,12,"ls"));
        dao.save("3",new User(3,23,"ww"));
        dao.save("4",new User(4,41,"zl"));

        dao.printm();

        System.out.println(dao.get("2"));

        dao.update("2",new User(2,22,"qz"));
        dao.printm();

        dao.delete("4");
        System.out.println(dao.list());


    }
}

class Dao<T>{
    HashMap<String,T> map = new HashMap<>();

    public void save(String id,T entity){
        map.put(id,entity);
    }

    public T get(String id){
        return map.get(id);
    }

    public void  update(String id,T entity){
        map.replace(id,entity);
    }

    public List<T> list(){
        //方法一
//        List<T> list = new ArrayList<>();
//        Collection<T> values = map.values();
//        list.addAll(values);

        //方法二
//        List<T> list = new ArrayList<>();
//        Set<String> strings = map.keySet();
//        for (String s : strings) {
//            list.add(get(s));
//        }

        //方法三
        List<T> list = new ArrayList<>();
        Collection<T> values = map.values();
        for (T t : values) {
            list.add(t);
        }

        //方法四
//        List<T> list = new ArrayList<>(map.values());
        return list;
    }

    public void delete(String id){
        map.remove(id);
    }

    @Test
    public void printm(){
        Set set = map.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry next =  (Map.Entry)iterator.next();
            System.out.println(next.getKey() + "-" + next.getValue());

        }


    }

}

class User{
    private int id;
    private int age;
    private String name;

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
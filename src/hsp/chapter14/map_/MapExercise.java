package hsp.chapter14.map_;

import java.util.*;

public class MapExercise {
    public static void main(String[] args) {

        Worker worker = new Worker("zs", 12000, 1);
        Worker worker1 = new Worker("ls", 129000, 2);
        Worker worker2 = new Worker("ww", 121000, 3);
        Worker worker3 = new Worker("zl", 11000, 4);
        Worker worker4 = new Worker("xm", 122000, 5);
        Worker worker5 = new Worker("xh", 123000, 6);


        HashMap map = new HashMap();
        map.put(worker.getId(),worker);
        map.put(worker1.getId(),worker1);
        map.put(worker2.getId(),worker2);
        map.put(worker3.getId(),worker3);
        map.put(worker4.getId(),worker4);
        map.put(worker5.getId(),worker5);

        System.out.println("======EntrySet的遍历方式======");
        Set set = map.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object obj =  iterator.next();
            Map.Entry m = (Map.Entry) obj;
            Worker w =(Worker)m.getValue();
            if (w.getSal() >= 18000){
                System.out.println(m.getValue());
            }

        }


        System.out.println("======增强for的遍历方式=====");
        Collection values = map.values();
        for(Object obj : values){
            Worker work = (Worker) obj;
            if(work.getSal() >= 18000){
                System.out.println(work);
            }
        }

    }
}

class Worker{
    private String name;
    private double sal;;
    private int id;

    public Worker(String name, double sal, int id) {
        this.name = name;
        this.sal = sal;
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", id=" + id +
                '}';
    }
}
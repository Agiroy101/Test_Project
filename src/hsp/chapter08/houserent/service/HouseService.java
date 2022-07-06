package hsp.chapter08.houserent.service;

import hsp.chapter08.houserent.domian.House;

public class HouseService {
    private  House[] houses = null;
    private int sum = 1;
    private int rank = 1;


    public HouseService(int size) {
        houses = new House[size];
        houses[0] =new House(1,"zs","123","asd",1200,"未出租");
    }

    public House[] list(){
        return houses;
    }

    public boolean add(House house){
        if(sum == houses.length){
            System.out.println("数组已满");
            return false;
        }
        houses[sum++] = house;
        house.setId(++rank);//这里用的形参house 是点睛之笔 因为是引用类型，所以改了house之后houses也会跟着更改
        return true;
    }

    public House search(int id){
        if(id > sum){
            System.out.println("输入有误，请重新输入");
        }
        for (int i = 0; i < sum; i++) {
            if(houses[i].getId() == id){
                return houses[i];
            }
        }
        return null;
    }

    public boolean delete(int i){
        if(i > sum){
            return false;
        }
        int index = -1;
        for (int j = 0; j < sum; j++) {
            if(houses[j].getId() == i){
                index = j;
            }
        }
        if(index == -1){
            return false;
        }

        for (int j = index; j < sum - 1; j++) {
            houses[j] = houses[j + 1];
        }
        houses[--sum] = null;
        --rank;
        return true;


    }

}

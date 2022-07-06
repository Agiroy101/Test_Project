package hsp.homework.homework2;

import java.util.Scanner;

public class HouseService {
    private String i = "";
    Scanner scanner;
    private boolean flag = true;
    House house[] = new House[6];
    private int sum = 0;


    public void add() {
        System.out.println("--------------添加房屋---------------");

        System.out.print("姓名：");
        scanner = new Scanner(System.in);
        String name = scanner.next();
//        i = scanner.next();
//        house[sum].setName(i);

        System.out.print("电话：");
        scanner = new Scanner(System.in);
        String phone = scanner.next();
//        i = scanner.next();
//        house[sum].setPhone(i);


        System.out.print("地址：");
        scanner = new Scanner(System.in);
        String address = scanner.next();
//        i = scanner.next();
//        house[sum].setAddress(i);

        System.out.print("月租：");
        scanner = new Scanner(System.in);
        String rent = scanner.next();
//        i = scanner.next();
//        house[sum].setRent(i);

        System.out.print("状态：");
        scanner = new Scanner(System.in);
        String statue = scanner.next();
//        i = scanner.next();
//        house[sum].setStatus(i);
        house[sum] = new House(name, phone, address, rent, statue);

        sum++;
        System.out.println("--------------添加完成---------------");

    }

    public void search() {
        System.out.println("--------------查找房屋---------------");
        System.out.println("请输入你要查找的id:");
        scanner = new Scanner(System.in);
        int asd = scanner.nextInt();
        System.out.println(house[asd]);

    }

    public void detele() {
        scanner = new Scanner(System.in);
        int asd = scanner.nextInt();
        house[asd] = null;
    }

    public void list() {
        for (int j = 0; j < house.length; j++) {
            if (house[j] != null) {
                System.out.println(house[j]);
            }
        }
    }

    public void update() {

    }

    public void exit() {

        while (true) {
            scanner = new Scanner(System.in);
            i = scanner.next();
            if (i.equals("y") || i.equals("n")) {
                flag = false;
                break;
            }
        }

    }


}

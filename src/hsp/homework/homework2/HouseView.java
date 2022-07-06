package hsp.homework.homework2;

import java.util.Scanner;

public class HouseView {
    House house[] = new House[6];
    private boolean flag = true;
    private String i;
    Scanner scanner;
    HouseService houseService = new HouseService();

    public void pt() {
        do {
            System.out.println("--------------房屋出租系统---------------");
            System.out.println("\t\t1 新 增 房 源");
            System.out.println("\t\t2 查 找 房 屋");
            System.out.println("\t\t3 删 除 房 屋");
            System.out.println("\t\t4 修 改 房 屋 信 息");
            System.out.println("\t\t5 房 屋 列 表");
            scanner = new Scanner(System.in);
            i = scanner.next();

            switch (i) {
                case "1":
                    houseService.add();
                    break;
                case "2":
                    houseService.search();
                    break;
                case "3":
                    houseService.detele();
                    break;
                case "4":
                    houseService.update();
                    break;
                case "5":
                    houseService.list();
                    break;
                case "6":
                    houseService.exit();
                    break;
            }
        } while (flag);

    }
}


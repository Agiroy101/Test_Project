package hsp.chapter12.exception;

import java.util.Scanner;

public class Exception02 {
    public static void main(String[] args) {
        int i = 0;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                i = Integer.parseInt(scanner.next());
//                i = scanner.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("输入的不是一个数字");
            }
        }

        System.out.println("你输入的数是：" + i);
    }
}

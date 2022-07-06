package hsp.chapter08.smallchange;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallChangeSys {
    public static void main(String[] args) {


        double money = 0;
        double balance = 0;
        Date date = null;
        String detail = "--------------零钱通明细--------------";
        String note = "";
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");


        do {
            System.out.println("========零钱通菜单=========");
            System.out.println("\t1 零钱通明细");
            System.out.println("\t2 收益入账");
            System.out.println("\t3 消费");
            System.out.println("\t4 退 出");
            System.out.println("请选择（1-4）：");

            int i = scanner.nextInt();
//            if(i == 4)
//                flag = false;
            switch (i){
                case 1: System.out.println(detail);
                    break;
                case 2:
                    System.out.print("收益入账金额：");
                    money = scanner.nextDouble();
                    balance += money;
                    date = new Date();

                    detail +="\n收益入账\t+" + money + "\t" + simpleDateFormat.format(date) + "\t余额：" + balance;
                    break;
                case 3:
                    System.out.print("消费金额：");
                    money = scanner.nextDouble();
                    System.out.print("消费说明：");
                    note = scanner.next();
                    balance -= money;
                    date = new Date();

                    detail +="\n" + note + "\t-" + money + "\t" + simpleDateFormat.format(date) + "\t余额：" + balance;
                    break;
                case 4:
                    String next = "";
//                    do {
//                        next = scanner.next();
//                    }while(!((next.hsp.chapter08.equals("y") && !(next.hsp.chapter08.equals("n")))) || !((!next.hsp.chapter08.equals("y") && next.hsp.chapter08.equals("n"))) );
                    while(true){
                        System.out.println("你确定要退出吗？y/n");
                        next = scanner.next();
                        if (next.equals("y") || next.equals("n")){
                            break;
                        }
                    }
                    if(next.equals("y")) {
                        flag = false;
                    }
                    break;

                default:
                    System.out.println("输入有误！");
                    break;

            }


        }while (flag);

    }
}

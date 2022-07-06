package hsp.chapter08.smallchange.oop;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallChangeSysOOP {

    double money = 0;
    double balance = 0;
    Date date = null;
    String detail = "--------------零钱通明细--------------";
    String note = "";
    boolean flag = true;
    Scanner scanner = new Scanner(System.in);
    int i;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    public boolean use(){
        MainMenu();
        switch (i){
            case 1:
                detail();
                break;
            case 2:
                add();
                break;
            case 3:
                pay();
                break;
            case 4:
                exit();

        }
        return flag;
    }

    public void MainMenu(){
        System.out.println("========零钱通菜单=========");
        System.out.println("\t1 零钱通明细");
        System.out.println("\t2 收益入账");
        System.out.println("\t3 消费");
        System.out.println("\t4 退 出");
        System.out.println("请选择（1-4）：");

        i = scanner.nextInt();
    }

    public void detail(){
        System.out.println(detail);
    }

    public void add(){
        System.out.print("收益入账金额：");
        money = scanner.nextDouble();
        balance += money;
        date = new Date();

        detail +="\n\t收益入账\t+" + money + "\t" + simpleDateFormat.format(date) + "\t余额：" + balance;
    }

    public void pay(){
        System.out.print("消费金额：");
        money = scanner.nextDouble();
        System.out.print("消费说明：");
        note = scanner.next();
        balance -= money;
        date = new Date();

        detail +="\n\t" + note + "\t-" + money + "\t" + simpleDateFormat.format(date) + "\t余额：" + balance;

    }

    public void exit(){
        String next = "";
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

    }


}

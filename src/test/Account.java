package test;
import java.util.Scanner;

public class Account {

    public int id;
    public String name;
    public int password;
    public int money;

    //方法Account()，创建账户的账号、密码、姓名和余额
    public Account(int id, String name, int password, int money) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.money = money;
    }

    //方法Display()，显示账户的账号、姓名和余额信息
    public void Display(){
        System.out.println("账户：" + id);
        System.out.println("姓名：" + name);
        System.out.println("余额：" + money);
    }

    /*取款方法 takeMoney()，先让用户输入密码验证，
    密码正确后输入取款金额，取款成功后余额减除相应的金额*/
    public void takeMoney(){
        while(true){
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入密码进行验证！");
            int pass = sc.nextInt();
            if(pass == password){
                System.out.println("请输入需要取款的金额：");
                int withdrawals = sc.nextInt();
                if(withdrawals <= money) {
                    money= money-withdrawals;
                    System.out.println("账户余额：" + money);
                }else {
                    System.out.println("当前余额不足！");
                }
                break;
            }else {
                System.out.println("你输入的密码有误，请重新输入！");
            }
            sc.close();
        }
    }

    /*存款方法 saveMoney(int moneys)，
    存款是直接传入存款金额，账户余额增加相应的金额*/
    public void saveMoney(int inmoney){
        money = money + inmoney;
        System.out.println("此次存款为：" + inmoney);
        System.out.println("账户余额：" + money);
    }

    public static void main(String[] args) {
        Account acc = new Account(10000,"小明",123456,100000);
	    /*
	    acc.id = 10000;
	    acc.name = "小明";
	    acc.password = 123456;
	    acc.money = 100000;
	    */
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("---欢迎进入银行账户操作系统---");
            System.out.println("---------1银行账户信息--------");
            System.out.println("---------2取款操作------------");
            System.out.println("---------3存款操作------------");
            System.out.println("---------4退出系统------------");
            System.out.println("------------------------------");
            int choice = sc.nextInt();
            switch(choice) {
                case 1:
                    System.out.println("---银行账户信息---");
                    acc.Display();
                    break;
                case 2:
                    System.out.println("---取款操作---");
                    acc.takeMoney();
                    break;
                case 3:
                    System.out.println("---存款操作---");
                    acc.saveMoney(1000);
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("您的选择有误！");
                    break;
            }
        }
    }
}

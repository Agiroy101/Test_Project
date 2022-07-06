package hsp.chapter17.exercise;

import java.util.Scanner;

public class Homework01 {
    public static void main(String[] args) {
        A a = new A();
        B b = new B(a);
        new Thread(a).start();
        new Thread(b).start();

    }
}

class A implements Runnable {

    public boolean loop = true;

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    @Override
    public void run() {
        while (loop) {
//            Random random = new Random();
//            System.out.println(random.nextInt(100));
            System.out.println((int)(Math.random() * 100 + 1));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class B implements Runnable {

    A a = null;
    Scanner sc = new Scanner(System.in);


    public B(A a) {
        this.a = a;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("输入Q表示退出：");
            char key = sc.next().toUpperCase().charAt(0);
            if(key == 'Q'){
                a.loop = false;
//                a.setLoop(false);
                break;
            }


            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
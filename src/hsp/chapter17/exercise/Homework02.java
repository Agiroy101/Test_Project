package hsp.chapter17.exercise;

public class Homework02 {
    public static void main(String[] args) {
        TT tt = new TT();
        Thread t1 = new Thread(tt);
        Thread t2 = new Thread(tt);
        t1.start();
        t2.start();


    }
}

class TT implements Runnable {
    private int money = 10000;

    @Override
    public synchronized void run() {
        while (true) {
            if (money <= 0) {
                System.out.println("余额不足");
                break;
            }
            System.out.println(Thread.currentThread().getName() + "取出1000，当前剩余：" + (money -= 1000));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

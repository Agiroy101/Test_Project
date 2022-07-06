package hsp.chapter17.synchronized_;

public class SellTicket {
    public static void main(String[] args) {
        SellTicket01 t1 = new SellTicket01();
        SellTicket01 t2 = new SellTicket01();
        SellTicket01 t3 = new SellTicket01();

        t1.start();
        t2.start();
        t3.start();

        //使用Runnable方式
//        SellTicket02 st1 = new SellTicket02();
//        new Thread(st1).start();
//        new Thread(st1).start();
//        new Thread(st1).start();
    }
}

//使用Thread方式
class SellTicket01 extends Thread {

    public static int ticketNum = 50;
    public static boolean loop = true;

    public static synchronized void sell() {//this的对象不是同一个，所以锁不住，所以必须设置称为静态方法

//        synchronized ((Object) ticketNum) {//this的对象不是同一个，所以锁不住
            if (ticketNum <= 0) {
                System.out.println("售票结束....");
                loop = false;
                return;
            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("窗口" + Thread.currentThread().getName() + "售出一张票，剩余" + (--ticketNum) + "张票");
//        }
    }

    @Override
    public void run() {
        while (loop) {
            sell();
        }
    }
}

//使用Runnable方式
class SellTicket02 implements Runnable {

    public static int ticketNum = 50;
    public boolean loop = true;

    public synchronized void sell() {//同步方法，在同一时刻，只能有一个线程来执行run方法

        if (ticketNum <= 0) {
            System.out.println("售票结束....");
            loop = false;
            return;
        }

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("窗口" + Thread.currentThread().getName() + "售出一张票，剩余" + (--ticketNum) + "张票");

    }

    @Override
    public void run() {
        while (loop) {
            sell();
        }
    }
}
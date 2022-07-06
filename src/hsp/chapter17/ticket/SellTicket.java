package hsp.chapter17.ticket;

public class SellTicket {
    public static void main(String[] args) {
//        SellTicket01 t1 = new SellTicket01();
//        SellTicket01 t2 = new SellTicket01();
//        SellTicket01 t3 = new SellTicket01();
//
//        t1.start();
//        t2.start();
//        t3.start();

        //使用Runnable方式
        SellTicket02 st1 = new SellTicket02();
        new Thread(st1).start();
        new Thread(st1).start();
        new Thread(st1).start();
    }
}
//使用Thread方式
class SellTicket01 extends Thread{

    public static int ticketNum = 10 ;

    @Override
    public void run() {
        while (true){

            if (ticketNum <= 0){
                System.out.println("售票结束....");
                break;
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("窗口" + Thread.currentThread().getName() + "售出一张票，剩余" + (--ticketNum) + "张票");

        }
    }
}

//使用Runnable方式
class SellTicket02 implements Runnable{

    public int ticketNum = 10;

    @Override
    public void run() {
        while (true){

            if (ticketNum <= 0){
                System.out.println("售票结束....");
                break;
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("窗口" + Thread.currentThread().getName() + "售出一张票，剩余" + (--ticketNum) + "张票");

        }
    }
}
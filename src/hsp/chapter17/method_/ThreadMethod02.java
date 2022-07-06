package hsp.chapter17.method_;

public class ThreadMethod02 {
    public static void main(String[] args) throws InterruptedException {
        T1 t1 = new T1();
        t1.start();

        for (int i = 0; i < 20; i++) {
            System.out.println("hi" + i);
            Thread.sleep(1000);
            if (i== 4) {
                System.out.println("主线程让子线程先运行");
//                t1.join();
                Thread.yield();//礼让，不一定成功
                System.out.println("子线程执行完毕，主线程继续执行");
            }
        }
    }
}

class T1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("hello" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

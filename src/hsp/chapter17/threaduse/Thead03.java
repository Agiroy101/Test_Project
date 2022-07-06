package hsp.chapter17.threaduse;

public class Thead03 {
    public static void main(String[] args) {
        T1 t1 = new T1();
        T2 t2 = new T2();
        Thread thread1 = new Thread(t1);
        Thread thread2 = new Thread(t2);
        thread1.start();
        thread2.start();

    }
}

class T1 implements Runnable{

    int sum = 0;

    @Override
    public void run() {
        while (true) {
            System.out.println("hi" + (++sum) + "            " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (sum == 8)
                break;
        }
    }
}
class T2 implements Runnable{

    int sum = 0;

    @Override
    public void run() {
        while (true) {
            System.out.println("hello world" + (++sum) + "   " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(sum == 10)
                break;
        }
    }
}
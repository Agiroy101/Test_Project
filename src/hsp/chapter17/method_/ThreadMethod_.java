package hsp.chapter17.method_;

public class ThreadMethod_ {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.setName("Agiroy");
        t.setPriority(Thread.MAX_PRIORITY);
        t.start();

        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            System.out.println("hi" + i);
        }

        t.interrupt();
        System.out.println(t.getName() + "线程的优先级为：" + t.getPriority());

    }
}

class T extends Thread{

    @Override
    public void run() {
        while (true){
            for (int i = 0; i < 20; i++) {
                System.out.println(Thread.currentThread().getName() + "吃包子" + i);
            }
            try {
                System.out.println(Thread.currentThread().getName() + "休眠中");
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "被interrupt了");
            }
        }
    }
}
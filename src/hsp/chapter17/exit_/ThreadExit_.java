package hsp.chapter17.exit_;

public class ThreadExit_ {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.start();

        //如果希望main线程去控制t先后才能的终止，必须可以修改loop
        //让t突出run方法，从而终止t线程->通知方式
        //让主线程休眠10秒，再通知t线程退出
        System.out.println("main线程休眠10s");
        Thread.sleep(5000);
        t.setLoop(false);
    }
}

class T extends Thread{
     int sum = 0;
     boolean loop = true;

    @Override
    public void run() {
        while (loop) {
            System.out.println("T在运行中。。。。" + (++sum));

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}
package hsp.chapter17.method_;

public class ThreadMethod03 {
    public static void main(String[] args) throws InterruptedException {
        MyDaemonThread myDaemonThread = new MyDaemonThread();
        myDaemonThread.setDaemon(true);
        myDaemonThread.start();

        for (int i = 1; i < 10; i++) {
            System.out.println("chat....");
            Thread.sleep(1000);
        }
    }
}

class MyDaemonThread extends Thread{
    @Override
    public void run() {
        while (true){
            System.out.println("run...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
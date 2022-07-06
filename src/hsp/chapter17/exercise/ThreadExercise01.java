package hsp.chapter17.exercise;

public class ThreadExercise01 {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        Thread thread = new Thread(t);
        for (int i = 0; i < 10; i++) {
            System.out.println("hi" + i);
            Thread.sleep(1000);
            if(i == 4){
                thread.start();
                thread.join();
            }

        }
    }
}

class T implements Runnable{
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

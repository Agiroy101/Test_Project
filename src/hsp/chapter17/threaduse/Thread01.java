package hsp.chapter17.threaduse;

public class Thread01 {
    public static void main(String[] args) throws InterruptedException {
        //创建Cat对象，可以当做线程使用
        Cat cat = new Cat();
        cat.start();//启动线程->最终汇之星cat的run方法
//        cat.run();//run方法就是一个普通的方法，没有真正的启动一个线程，就会把run方法执行完毕，才向下执行，就不是多线程了

        //当main线程启动一个子线程Thread-0，主线程不会阻塞，会继续执行
        //这是，主线程和子线程是交替执行
        System.out.println("主线程继续执行" + Thread.currentThread().getName());
        for (int i = 0; i < 60; i++){
            System.out.println("主线程 i= " + i);
            //让主线程休眠
            Thread.sleep(1500);
        }
    }
}

//当一个类继承了Thread类，该类就可以当做线程来使用
class Cat extends Thread{

    int sum = 0;
    @Override
    public void run() {
        while (true) {
            System.out.println("喵喵喵" + (++sum) + "  " +Thread.currentThread().getName());
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(sum == 80)
                break;
        }
    }
}
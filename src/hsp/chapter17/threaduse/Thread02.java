package hsp.chapter17.threaduse;

public class Thread02 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        //dog.start();这里不能调用start
        //创建了Thread对象，把dog对象（实现Runnable），放入Thread
        Thread thread = new Thread(dog);
        thread.start();
    }
}

class Dog implements Runnable{//通过实现Runnable接口，开发线程

    int sum = 0;
    @Override
    public void run() {
        while (true){
            System.out.println("汪汪汪" + (++sum) + " " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(sum == 8)
                break;
        }


    }
}

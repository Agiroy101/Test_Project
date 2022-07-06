package hsp.chapter18.tankgame4;

public class Shot implements Runnable {
    int x;//子弹x的坐标
    int y;//子弹y的坐标
    int direct = 0;//子弹方向
    int speed = 6;//子弹的速度
    boolean isLive = true;//子弹是否还存活

    public Shot(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    @Override
    public void run() {
        while (true) {

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //根据方向来改变x,y坐标
            switch (direct) {
                case 0:
                    y -= speed;
                    break;
                case 1:
                    x += speed;
                    break;
                case 2:
                    y += speed;
                    break;
                case 3:
                    x -= speed;
                    break;
            }

            //测试，输出x，y的坐标
            System.out.println("子弹x = " + x + " y = " + y);
            //当子弹移动到面板的边界时，就应该销毁（把启动的子弹的线程销毁）
            //当子弹碰到敌人坦克时，也应该结束进程
            if(!( x >= 0 && x <= 1000 & y >= 0 && y <= 750 && isLive)){
                System.out.println("子弹线程退出");
                isLive = false;
                break;
            }
        }
    }
}

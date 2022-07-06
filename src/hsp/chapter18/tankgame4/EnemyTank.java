package hsp.chapter18.tankgame4;

import java.util.Vector;

public class EnemyTank extends Tank implements Runnable {
    //在敌人坦克类，使用Vector，保存多个Shot
    Vector<Shot> shots = new Vector<>();

    boolean isLive = true;

    public EnemyTank(int x, int y) {
        super(x, y);
    }


    //让敌方坦克可以发射多颗子弹
    Shot shot = null;

    public void shotEnemyTank() {
        if (isLive && shots.size() < 10) {//限制地方坦克的子弹数量
            //创建Shot对象,根据当前Hero对象的位置和方向来创建Shot
            switch (getDirect()) {
                case 0:
                    shot = new Shot(getX() + 20, getY(), 0);
                    break;
                case 1:
                    shot = new Shot(getX() + 60, getY() + 20, 1);
                    break;
                case 2:
                    shot = new Shot(getX() + 20, getY() + 60, 2);
                    break;
                case 3:
                    shot = new Shot(getX(), getY() + 20, 3);
                    break;
            }
        }

        shots.add(shot);
        //启动我们的Shot线程
        new Thread(shot).start();
    }


    @Override
    public void run() {
        while (true) {

            //这里我们判断如果shots.size() == 0，创建一颗子弹，放入到shots集合中，并启动
//            if (isLive && shots.size() == 0) {
//                //判断坦克的方向，创建对应的子弹
//                switch (getDirect()) {
//                    case 0:
//                        shot = new Shot(getX() + 20, getY(), 0);
//                        break;
//                    case 1:
//                        shot = new Shot(getX() + 60, getY() + 20, 1);
//                        break;
//                    case 2:
//                        shot = new Shot(getX() + 20, getY() + 60, 2);
//                        break;
//                    case 3:
//                        shot = new Shot(getX(), getY() + 20, 3);
//                        break;
//                }
//                shots.add(shot);
//                //启动
//                new Thread(shot).start();
//            }


            //根据坦克的方向来继续移动
            switch (getDirect()) {
                case 0://向上
                    //让坦克保持一个方向走30步
                    for (int i = 0; i < ((int) (Math.random() * 100) + 1); i++) {
                        moveUp();
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    shotEnemyTank();
                    break;
                case 1://向右
                    for (int i = 0; i < ((int) (Math.random() * 100) + 1); i++) {
                        moveRight();
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    shotEnemyTank();
                    break;
                case 2://向下
                    for (int i = 0; i < ((int) (Math.random() * 100) + 1); i++) {
                        moveDown();
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    shotEnemyTank();
                    break;
                case 3://向左
                    for (int i = 0; i < ((int) (Math.random() * 100) + 1); i++) {
                        moveLeft();
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    shotEnemyTank();
                    break;
            }


            //然后随机的改变坦克方向 0-3
            setDirect((int) (Math.random() * 4));

            //考虑线程什么时候退出
            if (!isLive || !super.isLive) {//当子弹碰到边界或者击中敌方坦克时，或者被击中时，子弹消失
                break;
            }
        }
    }
}

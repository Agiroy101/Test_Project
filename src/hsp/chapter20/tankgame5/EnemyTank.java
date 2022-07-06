package hsp.chapter20.tankgame5;

import java.util.Vector;

public class EnemyTank extends Tank implements Runnable {
    //在敌人坦克类，使用Vector，保存多个Shot
    Vector<Shot> shots = new Vector<>();

    //增加成员，EnemyTankk可以得到所有敌人坦克的Vector
//    Vector<EnemyTank> enemyTanks = new Vector<>();

    boolean isLive = true;

    public EnemyTank(int x, int y) {
        super(x, y);
    }

//    //这里提供一个set方法，可以将MyPanel的成员Vector<EnemyTank> enemyTanks = new Vector<>();
//    //设置到EnemyTank的成员enemyTanks
//    public void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
//        this.enemyTanks = enemyTanks;
//    }
//
//    //编写方法，判断当前的这个敌人坦克，是否和enemyTanks中的其他坦克发生重叠或者碰撞
//    public boolean isTouchEnemyTank() {
//
//        //判断当前敌人坦克（this）方向
//        switch (this.getDirect()) {
//            case 0://上
//                //让当前敌人坦克和其他所有的敌人坦克比较
//                for (int i = 0; i < enemyTanks.size(); i++) {
//                    //从Vector中取出一个敌人坦克
//                    EnemyTank enemyTank = enemyTanks.get(i);
//                    //不和自己比较
//                    if (enemyTank == this)
//                        continue;
//                    //如果敌人坦克是上/下
//                    //如果敌人坦克是上/下 x的范围[enemyTank.getX(),enemyTank.getY() + 40]
//                    //                 y的范围[enemyTank.getY(),enemyTank.getY() + 60]
//                    if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
//                        //当前坦克左上角的坐标[this.getX(),this.getY()]
//                        if (this.getX() >= enemyTank.getX()
//                                && this.getX() <= enemyTank.getX() + 40
//                                && this.getY() >= enemyTank.getY()
//                                && this.getY() <= enemyTank.getY() + 60) {
//                            return true;
//                        }
//
//                        //当前坦克右上角的坐标[this.getX()+40, this.getY()]
//                        if (this.getX() + 40 >= enemyTank.getX()
//                                && this.getX() + 40 <= enemyTank.getX() + 40
//                                && this.getY() >= enemyTank.getY()
//                                && this.getY() <= enemyTank.getY() + 60) {
//                            return true;
//                        }
//
//                    }
//                    //如果敌人坦克是左/右
//                    //如果敌人坦克是左/右 x的范围[enemyTank.getX(),enemyTank.getY() + 60]
//                    //                 y的范围[enemyTank.getY(),enemyTank.getY() + 40]
//                    if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {
//                        //当前坦克左上角的坐标[this.getX(),this.getY()]
//                        if (this.getX() >= enemyTank.getX()
//                                && this.getX() <= enemyTank.getX() + 60
//                                && this.getY() >= enemyTank.getY()
//                                && this.getY() <= enemyTank.getY() + 40) {
//                            return true;
//                        }
//
//                        //当前坦克右上角的坐标[this.getX()+40, this.getY()]
//                        if (this.getX() + 40 >= enemyTank.getX()
//                                && this.getX() + 40 <= enemyTank.getX() + 60
//                                && this.getY() >= enemyTank.getY()
//                                && this.getY() <= enemyTank.getY() + 40) {
//                            return true;
//                        }
//                    }
//
//                }
//                break;
//            case 1://右
//                for (int i = 0; i < enemyTanks.size(); i++) {
//                    //从Vector中取出一个敌人坦克
//                    EnemyTank enemyTank = enemyTanks.get(i);
//                    //不和自己比较
//                    if (enemyTank == this)
//                        continue;
//                    //如果敌人坦克是上/下
//                    //如果敌人坦克是上/下 x的范围[enemyTank.getX(),enemyTank.getY() + 40]
//                    //                 y的范围[enemyTank.getY(),enemyTank.getY() + 60]
//                    if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
//                        //当前坦克右上角的坐标[this.getX()+60,this.getY()]
//                        if (this.getX() + 60 >= enemyTank.getX()
//                                && this.getX() + 60 <= enemyTank.getX() + 40
//                                && this.getY() >= enemyTank.getY()
//                                && this.getY() <= enemyTank.getY() + 60) {
//                            return true;
//                        }
//
//                        //当前坦克右下角的坐标[this.getX()+60, this.getY()+40]
//                        if (this.getX() + 60 >= enemyTank.getX()
//                                && this.getX() + 60 <= enemyTank.getX() + 60
//                                && this.getY() + 40 >= enemyTank.getY()
//                                && this.getY() + 40 <= enemyTank.getY() + 60) {
//                            return true;
//                        }
//
//                    }
//                    //如果敌人坦克是左/右
//                    //如果敌人坦克是左/右 x的范围[enemyTank.getX(),enemyTank.getY() + 60]
//                    //                 y的范围[enemyTank.getY(),enemyTank.getY() + 40]
//                    if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {
//                        //当前坦克右上角的坐标[this.getX()+60,this.getY()]
//                        if (this.getX() + 60 >= enemyTank.getX()
//                                && this.getX() + 60 <= enemyTank.getX() + 60
//                                && this.getY() >= enemyTank.getY()
//                                && this.getY() <= enemyTank.getY() + 40) {
//                            return true;
//                        }
//
//                        //当前坦克右下角的坐标[this.getX()+60, this.getY()+40]
//                        if (this.getX() + 60 >= enemyTank.getX()
//                                && this.getX() + 60 <= enemyTank.getX() + 60
//                                && this.getY() + 40 >= enemyTank.getY()
//                                && this.getY() + 40 <= enemyTank.getY() + 60) {
//                            return true;
//                        }
//                    }
//
//                }
//                break;
//            case 2:
//                for (int i = 0; i < enemyTanks.size(); i++) {
//                    //从Vector中取出一个敌人坦克
//                    EnemyTank enemyTank = enemyTanks.get(i);
//                    //不和自己比较
//                    if (enemyTank == this)
//                        continue;
//                    //如果敌人坦克是上/下
//                    //如果敌人坦克是上/下 x的范围[enemyTank.getX(),enemyTank.getY() + 40]
//                    //                 y的范围[enemyTank.getY(),enemyTank.getY() + 60]
//                    if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
//                        //当前坦克左下角的坐标[this.getX(),this.getY()+60]
//                        if (this.getX() >= enemyTank.getX()
//                                && this.getX() <= enemyTank.getX() + 40
//                                && this.getY() + 60 >= enemyTank.getY()
//                                && this.getY() + 60 <= enemyTank.getY() + 60) {
//                            return true;
//                        }
//
//                        //当前坦克右下角的坐标[this.getX()+40, this.getY()+60]
//                        if (this.getX() + 40 >= enemyTank.getX()
//                                && this.getX() + 40 <= enemyTank.getX() + 40
//                                && this.getY() + 60 >= enemyTank.getY()
//                                && this.getY() + 60 <= enemyTank.getY() + 60) {
//                            return true;
//                        }
//
//                    }
//                    //如果敌人坦克是左/右
//                    //如果敌人坦克是左/右 x的范围[enemyTank.getX(),enemyTank.getY() + 60]
//                    //                 y的范围[enemyTank.getY(),enemyTank.getY() + 40]
//                    if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {
//                        //当前坦克右上角的坐标[this.getX()+60,this.getY()]
//                        if (this.getX() >= enemyTank.getX()
//                                && this.getX() <= enemyTank.getX() + 60
//                                && this.getY() + 60 >= enemyTank.getY()
//                                && this.getY() + 60 <= enemyTank.getY() + 40) {
//                            return true;
//                        }
//
//                        //当前坦克右下角的坐标[this.getX()+40, this.getY()+60]
//                        if (this.getX() + 40 >= enemyTank.getX()
//                                && this.getX() + 40 <= enemyTank.getX() + 60
//                                && this.getY() + 60 >= enemyTank.getY()
//                                && this.getY() + 60 <= enemyTank.getY() + 40) {
//                            return true;
//                        }
//                    }
//
//                }
//                break;
//            case 3:
//                for (int i = 0; i < enemyTanks.size(); i++) {
//                    //从Vector中取出一个敌人坦克
//                    EnemyTank enemyTank = enemyTanks.get(i);
//                    //不和自己比较
//                    if (enemyTank == this)
//                        continue;
//                    //如果敌人坦克是上/下
//                    //如果敌人坦克是上/下 x的范围[enemyTank.getX(),enemyTank.getY() + 40]
//                    //                 y的范围[enemyTank.getY(),enemyTank.getY() + 60]
//                    if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
//                        //当前坦克左上角的坐标[this.getX(),this.getY()]
//                        if (this.getX() >= enemyTank.getX()
//                                && this.getX() <= enemyTank.getX() + 40
//                                && this.getY() >= enemyTank.getY()
//                                && this.getY() <= enemyTank.getY() + 60) {
//                            return true;
//                        }
//
//                        //当前坦克左下角的坐标[this.getX(), this.getY()+40]
//                        if (this.getX() >= enemyTank.getX()
//                                && this.getX() <= enemyTank.getX() + 40
//                                && this.getY() + 40 >= enemyTank.getY()
//                                && this.getY() + 40 <= enemyTank.getY() + 60) {
//                            return true;
//                        }
//
//                    }
//                    //如果敌人坦克是左/右
//                    //如果敌人坦克是左/右 x的范围[enemyTank.getX(),enemyTank.getY() + 60]
//                    //                 y的范围[enemyTank.getY(),enemyTank.getY() + 40]
//                    if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {
//                        //当前坦克右上角的坐标[this.getX(),this.getY()]
//                        if (this.getX() >= enemyTank.getX()
//                                && this.getX() <= enemyTank.getX() + 60
//                                && this.getY() >= enemyTank.getY()
//                                && this.getY() <= enemyTank.getY() + 40) {
//                            return true;
//                        }
//
//                        //当前坦克右下角的坐标[this.getX(), this.getY()+40]
//                        if (this.getX() >= enemyTank.getX()
//                                && this.getX() <= enemyTank.getX() + 60
//                                && this.getY() + 40 >= enemyTank.getY()
//                                && this.getY() + 40 <= enemyTank.getY() + 40) {
//                            return true;
//                        }
//                    }
//
//                }
//                break;
//        }
//        return false;
//    }

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
                        if (!isTouchEnemyTank())
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
                        if (!isTouchEnemyTank())
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
                        if (!isTouchEnemyTank())
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
                        if (!isTouchEnemyTank())
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

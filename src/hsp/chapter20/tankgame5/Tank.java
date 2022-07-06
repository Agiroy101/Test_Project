package hsp.chapter20.tankgame5;

import java.util.Vector;

public class Tank {
    private int x;//坦克的横坐标
    private int y;//坦克的纵坐标
    private int direct;//坦克方向 0向上 1向右 2向下 3向左
    private int speed = 1;
    boolean isLive = true;

    Vector<EnemyTank> enemyTanks = new Vector<>();

    public void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        this.enemyTanks = enemyTanks;
    }

    public boolean isTouchEnemyTank() {

        //判断当前敌人坦克（this）方向
        switch (this.getDirect()) {
            case 0://上
                //让当前敌人坦克和其他所有的敌人坦克比较
                for (int i = 0; i < enemyTanks.size(); i++) {
                    //从Vector中取出一个敌人坦克
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //不和自己比较
                    if (enemyTank == this)
                        continue;
                    //如果敌人坦克是上/下
                    //如果敌人坦克是上/下 x的范围[enemyTank.getX(),enemyTank.getY() + 40]
                    //                 y的范围[enemyTank.getY(),enemyTank.getY() + 60]
                    if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
                        //当前坦克左上角的坐标[this.getX(),this.getY()]
                        if (this.getX() >= enemyTank.getX()
                                && this.getX() <= enemyTank.getX() + 40
                                && this.getY() >= enemyTank.getY()
                                && this.getY() <= enemyTank.getY() + 60) {
                            return true;
                        }

                        //当前坦克右上角的坐标[this.getX()+40, this.getY()]
                        if (this.getX() + 40 >= enemyTank.getX()
                                && this.getX() + 40 <= enemyTank.getX() + 40
                                && this.getY() >= enemyTank.getY()
                                && this.getY() <= enemyTank.getY() + 60) {
                            return true;
                        }

                    }
                    //如果敌人坦克是左/右
                    //如果敌人坦克是左/右 x的范围[enemyTank.getX(),enemyTank.getY() + 60]
                    //                 y的范围[enemyTank.getY(),enemyTank.getY() + 40]
                    if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {
                        //当前坦克左上角的坐标[this.getX(),this.getY()]
                        if (this.getX() >= enemyTank.getX()
                                && this.getX() <= enemyTank.getX() + 60
                                && this.getY() >= enemyTank.getY()
                                && this.getY() <= enemyTank.getY() + 40) {
                            return true;
                        }

                        //当前坦克右上角的坐标[this.getX()+40, this.getY()]
                        if (this.getX() + 40 >= enemyTank.getX()
                                && this.getX() + 40 <= enemyTank.getX() + 60
                                && this.getY() >= enemyTank.getY()
                                && this.getY() <= enemyTank.getY() + 40) {
                            return true;
                        }
                    }

                }
                break;
            case 1://右
                for (int i = 0; i < enemyTanks.size(); i++) {
                    //从Vector中取出一个敌人坦克
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //不和自己比较
                    if (enemyTank == this)
                        continue;
                    //如果敌人坦克是上/下
                    //如果敌人坦克是上/下 x的范围[enemyTank.getX(),enemyTank.getY() + 40]
                    //                 y的范围[enemyTank.getY(),enemyTank.getY() + 60]
                    if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
                        //当前坦克右上角的坐标[this.getX()+60,this.getY()]
                        if (this.getX() + 60 >= enemyTank.getX()
                                && this.getX() + 60 <= enemyTank.getX() + 40
                                && this.getY() >= enemyTank.getY()
                                && this.getY() <= enemyTank.getY() + 60) {
                            return true;
                        }

                        //当前坦克右下角的坐标[this.getX()+60, this.getY()+40]
                        if (this.getX() + 60 >= enemyTank.getX()
                                && this.getX() + 60 <= enemyTank.getX() + 60
                                && this.getY() + 40 >= enemyTank.getY()
                                && this.getY() + 40 <= enemyTank.getY() + 60) {
                            return true;
                        }

                    }
                    //如果敌人坦克是左/右
                    //如果敌人坦克是左/右 x的范围[enemyTank.getX(),enemyTank.getY() + 60]
                    //                 y的范围[enemyTank.getY(),enemyTank.getY() + 40]
                    if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {
                        //当前坦克右上角的坐标[this.getX()+60,this.getY()]
                        if (this.getX() + 60 >= enemyTank.getX()
                                && this.getX() + 60 <= enemyTank.getX() + 60
                                && this.getY() >= enemyTank.getY()
                                && this.getY() <= enemyTank.getY() + 40) {
                            return true;
                        }

                        //当前坦克右下角的坐标[this.getX()+60, this.getY()+40]
                        if (this.getX() + 60 >= enemyTank.getX()
                                && this.getX() + 60 <= enemyTank.getX() + 60
                                && this.getY() + 40 >= enemyTank.getY()
                                && this.getY() + 40 <= enemyTank.getY() + 60) {
                            return true;
                        }
                    }

                }
                break;
            case 2:
                for (int i = 0; i < enemyTanks.size(); i++) {
                    //从Vector中取出一个敌人坦克
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //不和自己比较
                    if (enemyTank == this)
                        continue;
                    //如果敌人坦克是上/下
                    //如果敌人坦克是上/下 x的范围[enemyTank.getX(),enemyTank.getY() + 40]
                    //                 y的范围[enemyTank.getY(),enemyTank.getY() + 60]
                    if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
                        //当前坦克左下角的坐标[this.getX(),this.getY()+60]
                        if (this.getX() >= enemyTank.getX()
                                && this.getX() <= enemyTank.getX() + 40
                                && this.getY() + 60 >= enemyTank.getY()
                                && this.getY() + 60 <= enemyTank.getY() + 60) {
                            return true;
                        }

                        //当前坦克右下角的坐标[this.getX()+40, this.getY()+60]
                        if (this.getX() + 40 >= enemyTank.getX()
                                && this.getX() + 40 <= enemyTank.getX() + 40
                                && this.getY() + 60 >= enemyTank.getY()
                                && this.getY() + 60 <= enemyTank.getY() + 60) {
                            return true;
                        }

                    }
                    //如果敌人坦克是左/右
                    //如果敌人坦克是左/右 x的范围[enemyTank.getX(),enemyTank.getY() + 60]
                    //                 y的范围[enemyTank.getY(),enemyTank.getY() + 40]
                    if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {
                        //当前坦克右上角的坐标[this.getX()+60,this.getY()]
                        if (this.getX() >= enemyTank.getX()
                                && this.getX() <= enemyTank.getX() + 60
                                && this.getY() + 60 >= enemyTank.getY()
                                && this.getY() + 60 <= enemyTank.getY() + 40) {
                            return true;
                        }

                        //当前坦克右下角的坐标[this.getX()+40, this.getY()+60]
                        if (this.getX() + 40 >= enemyTank.getX()
                                && this.getX() + 40 <= enemyTank.getX() + 60
                                && this.getY() + 60 >= enemyTank.getY()
                                && this.getY() + 60 <= enemyTank.getY() + 40) {
                            return true;
                        }
                    }

                }
                break;
            case 3:
                for (int i = 0; i < enemyTanks.size(); i++) {
                    //从Vector中取出一个敌人坦克
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //不和自己比较
                    if (enemyTank == this)
                        continue;
                    //如果敌人坦克是上/下
                    //如果敌人坦克是上/下 x的范围[enemyTank.getX(),enemyTank.getY() + 40]
                    //                 y的范围[enemyTank.getY(),enemyTank.getY() + 60]
                    if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
                        //当前坦克左上角的坐标[this.getX(),this.getY()]
                        if (this.getX() >= enemyTank.getX()
                                && this.getX() <= enemyTank.getX() + 40
                                && this.getY() >= enemyTank.getY()
                                && this.getY() <= enemyTank.getY() + 60) {
                            return true;
                        }

                        //当前坦克左下角的坐标[this.getX(), this.getY()+40]
                        if (this.getX() >= enemyTank.getX()
                                && this.getX() <= enemyTank.getX() + 40
                                && this.getY() + 40 >= enemyTank.getY()
                                && this.getY() + 40 <= enemyTank.getY() + 60) {
                            return true;
                        }

                    }
                    //如果敌人坦克是左/右
                    //如果敌人坦克是左/右 x的范围[enemyTank.getX(),enemyTank.getY() + 60]
                    //                 y的范围[enemyTank.getY(),enemyTank.getY() + 40]
                    if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {
                        //当前坦克右上角的坐标[this.getX(),this.getY()]
                        if (this.getX() >= enemyTank.getX()
                                && this.getX() <= enemyTank.getX() + 60
                                && this.getY() >= enemyTank.getY()
                                && this.getY() <= enemyTank.getY() + 40) {
                            return true;
                        }

                        //当前坦克右下角的坐标[this.getX(), this.getY()+40]
                        if (this.getX() >= enemyTank.getX()
                                && this.getX() <= enemyTank.getX() + 60
                                && this.getY() + 40 >= enemyTank.getY()
                                && this.getY() + 40 <= enemyTank.getY() + 40) {
                            return true;
                        }
                    }

                }
                break;
        }
        return false;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void moveUp() {
        if (y - speed >= 0 && y - speed + 60 <= 750) {
            y -= speed;
        }else {
            System.out.println("遇到边界不能继续向上移动" + x+ "   " + y);
        }
    }

    public void moveRight() {
        if ((x + speed >= 0 && x + speed + 60 <= 1000)){
            x += speed;
        }else {
            System.out.println("遇到边界不能继续向右移动" + x+ "   " + y);
        }
    }

    public void moveLeft() {
        if ((x - speed >= 0 && x - speed + 60 <= 1000)){
            x -= speed;
        }else {
            System.out.println("遇到边界不能继续向左移动" + x+ "   " + y);
        }
    }

    public void moveDown() {
        if (y + speed >= 0 && y + speed + 60<= 750) {
            y += speed;
        }else {
            System.out.println("遇到边界不能继续向下移动" + x+ "   " + y);
        }
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

package hsp.chapter20.tankgame6;

import java.util.Vector;

public class Hero extends Tank {
    //定义一个Shot对象，表示一个射击（线程）
    Shot shot = null;
    Vector<Shot> shots = new Vector<>();
    public Hero(int x, int y) {
        super(x, y);
    }

    //射击
    public void shotEnemyTank() {

        //发射多颗子弹，控制在我们的面板上，最多只有五颗
//        if(shots.size() == 5)
//            return;


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

        shots.add(shot);
        //启动我们的Shot线程
        new Thread(shot).start();
    }
}

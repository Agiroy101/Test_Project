package hsp.chapter18.tankgame3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.Vector;

//为了监听键盘事件，实现KeyListener
//为了让Panel不听的重绘子弹，需要将MyPanel实现Runnable接口，当做一个线程使用
public class MyPanel extends JPanel implements KeyListener,Runnable {
    //定义我的坦克
    Hero hero = null;

    //定义敌人的坦克,放入Vector
    Vector<EnemyTank> enemyTanks = new Vector<>();
    //初始化敌人坦克的数量
    int enemyTankSize = 3;


    public MyPanel() {
        hero = new Hero(100, 100);
        hero.setSpeed(5);
        for (int i = 0; i < enemyTankSize; i++) {
            //创建一个敌人的坦克
            EnemyTank tank = new EnemyTank((100 * (1 + i)), 0);
            //设置方向
            tank.setDirect(new Random().nextInt(3));
            enemyTanks.add(tank);
        }

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);//填充矩形，默认黑色

        //画出坦克，封装方法
        drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 0);

        //画出hero射击的子弹
        if(hero.shot != null && hero.shot.isLive != false){
//            g.fill3DRect(hero.shot.x, hero.shot.y,  3, 3, false);
        }



//        drawTank(hero.getX() + 60, hero.getY(), g, 1, 1);

        //画出敌人的坦克,遍历Vector
        for (EnemyTank tank : enemyTanks) {
            drawTank(tank.getX(), tank.getY(), g, tank.getDirect(), 1);
        }
//        for (int i = 0; i < enemyTanks.size(); i++) {
//            EnemyTank tank = enemyTanks.get(i);
//            drawTank(tank.getX(),tank.getY(),g,tank.getDirect(),1);
//        }




    }

    /**
     * @param x      坦克的左上角x的坐标
     * @param y      坦克的左上角y的坐标
     * @param g      画笔
     * @param direct 坦克方向（上下左右）
     * @param type   （坦克类型）
     */
    //编写方法，画出坦克
    public void drawTank(int x, int y, Graphics g, int direct, int type) {

        switch (type) {
            case 0://我们的坦克
                g.setColor(Color.cyan);
                break;
            case 1://敌人的坦克
                g.setColor(Color.red);
                break;
        }

        //根据坦克的方向，来绘制坦克
        //direct表示方向（0；向上 1：向右 2：向下 3：向左）
        switch (direct) {
            case 0://表示向上
//                g.fill3DRect(hero.getX(),hero.getY(),10,60,false);
                g.fill3DRect(x, y, 10, 60, false);//画出坦克左边轮子
                g.fill3DRect(x + 30, y, 10, 60, false);//画出坦克右边轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//画出坦克盖子
                g.fillOval(x + 10, y + 20, 20, 20);//画出坦克圆形盖子
                g.drawLine(x + 20, y + 30, x + 20, y);//画出坦克炮筒
//                g.drawLine(x + 15, y + 30,x + 15, y);//画出坦克炮筒
//                g.drawLine(x + 25, y + 30,x + 25, y);//画出坦克炮筒
                break;
            case 1://表示向右
                g.fill3DRect(x, y, 60, 10, false);//画出坦克左边轮子
                g.fill3DRect(x, y + 30, 60, 10, false);//画出坦克右边轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//画出坦克盖子
                g.fillOval(x + 20, y + 10, 20, 20);//画出坦克圆形盖子
                g.drawLine(x + 30, y + 20, x + 60, y + 20);//画出坦克炮筒
                break;
            case 2://表示向下
                g.fill3DRect(x, y, 10, 60, false);//画出坦克左边轮子
                g.fill3DRect(x + 30, y, 10, 60, false);//画出坦克右边轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//画出坦克盖子
                g.fillOval(x + 10, y + 20, 20, 20);//画出坦克圆形盖子
                g.drawLine(x + 20, y + 30, x + 20, y + 60);//画出坦克炮筒
                break;
            case 3://表示向左
                g.fill3DRect(x, y, 60, 10, false);//画出坦克左边轮子
                g.fill3DRect(x, y + 30, 60, 10, false);//画出坦克右边轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//画出坦克盖子
                g.fillOval(x + 20, y + 10, 20, 20);//画出坦克圆形盖子
                g.drawLine(x + 30, y + 20, x, y + 20);//画出坦克炮筒
                break;
            default:
                System.out.println("暂时没有处理");
        }

    }




    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
//            hero.setY(hero.getY() - 5);
            hero.moveUp();
            hero.setDirect(0);
        } else if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) {
//            hero.setX(hero.getX() + 5);
            hero.moveRight();
            hero.setDirect(1);
        } else if (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN) {
//            hero.setY(hero.getY() + 5);
            hero.moveDown();
            hero.setDirect(2);
        } else if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) {
//            hero.setX(hero.getX() - 5);
            hero.moveLeft();
            hero.setDirect(3);
        }

        //如果用户按下的是J，就发射
        if (e.getKeyCode() == KeyEvent.VK_J) {
            System.out.println("用户按下了J键，子弹发射");
            hero.shotEnemyTank();
        }

        //让面板重绘
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.repaint();
        }
    }
}

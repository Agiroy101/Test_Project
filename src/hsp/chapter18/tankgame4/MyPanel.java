package hsp.chapter18.tankgame4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.Vector;

//为了监听键盘事件，实现KeyListener
//为了让Panel不听的重绘子弹，需要将MyPanel实现Runnable接口，当做一个线程使用
public class MyPanel extends JPanel implements KeyListener, Runnable {
    //定义我的坦克
    Hero hero = null;

    //定义一个Vector，用于存放炸弹
    //当子弹击中坦克时，加入一个Bomb对象到bombs
    Vector<Bomb> bombs = new Vector<>();

    //定义三张炸弹图片，用于显示爆炸效果
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;


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

            //启动敌人坦克，让他动起来
            new Thread(tank).start();

            Shot shot = null;
            //因为是随机方向的地方坦克，所以需要判断
            //给该enemyTank加入一颗子弹
            switch (tank.getDirect()) {
                case 0:
                    //给该enemyTank加入一颗子弹
                    shot = new Shot(tank.getX() + 20, tank.getY(), 0);
//                    //加入enemyTank的Vector成员
//                    tank.shots.add(shot);
//                    //启动shot对象
//                    new Thread(shot).start();
                    break;
                case 1:
                    shot = new Shot(tank.getX() + 60, tank.getY() + 20, 1);
                    break;
                case 2:
                    shot = new Shot(tank.getX() + 20, tank.getY() + 60, 2);

                    break;
                case 3:
                    shot = new Shot (tank.getX(), tank.getY() + 20, 3);
                    break;
            }

            tank.shots.add(shot);
            new Thread(shot).start();


            enemyTanks.add(tank);

        }

        //初始化图片对象
        image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.gif"));
        image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_2.gif"));
        image3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_3.gif"));


    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);//填充矩形，默认黑色

        //画出坦克，封装方法
        if(hero != null && hero.isLive) {
            drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 0);
        }else {
            hero.setX(((int)(Math.random()*1000)));
            hero.setY(((int)(Math.random()*750)));
            drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 0);
            hero.isLive = true;
        }

        //画出hero射击的子弹
//        if(hero.shot != null && hero.shot.isLive != false){
//            g.fill3DRect(hero.shot.x, hero.shot.y,  3, 3, false);
//        }
        //画出hero的多颗子弹
        for (int i = 0; i < hero.shots.size(); i++) {
            Shot shot = hero.shots.get(i);
            if (shot.isLive) {
                g.fill3DRect(shot.x, shot.y, 3, 3, false);
            } else {//如果该shot对象已经无效，就从shots集合中移除
                hero.shots.remove(shot);
            }
        }


        //如果bombs集合中有对象，就画出
        for (int i = 0; i < bombs.size(); i++) {
            //取出炸弹
            Bomb bomb = bombs.get(i);
            //根据当前这个bomb对象的life值去画出对应的图片
            if(bomb.life > 6){
                g.drawImage(image1,bomb.x,bomb.y,60,60,this);
            }else if(bomb.life >3){
                g.drawImage(image2,bomb.x,bomb.y,60,60,this);
            }else {
                g.drawImage(image3,bomb.x,bomb.y,60,60,this);
            }
            //让这个炸弹的生命值减少
            bomb.lifeDown();
            //如果bomb life为0，就从bombs的集合中删除
            if(bomb.life == 0){
                bombs.remove(bomb);
            }

        }


//        drawTank(hero.getX() + 60, hero.getY(), g, 1, 1);

        //画出敌人的坦克,遍历Vector
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank tank = enemyTanks.get(i);
            if(tank.isLive) {//当敌人坦克是存活的，才画出该坦克
                drawTank(tank.getX(), tank.getY(), g, tank.getDirect(), 1);
                //画出敌方坦克的所有子弹
                for (int j = 0; j < tank.shots.size(); j++) {
                    Shot shot = tank.shots.get(j);
                    if (shot.isLive) {
                        g.fill3DRect(shot.x, shot.y, 3, 3, false);
                    } else {
                        //从Vector移除
                        tank.shots.remove(shot);
                    }
                }
            }

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

    //编写方法，判断我方的子弹是否击中敌人坦克
    public void hitTank(Shot s, Tank tank) {
        //判断击中坦克
        switch (tank.getDirect()) {
            case 0://坦克向上的方向
            case 2://坦克向下的方向
                if (s.x > tank.getX() && s.x < tank.getX() + 40 && s.y > tank.getY() && s.y < tank.getY() + 60) {
                    s.isLive = false;
                    tank.isLive = false;
                    //创建Bomb对象，加入到bombs集合
                    Bomb bomb = new Bomb(tank.getX(), tank.getY());
                    bombs.add(bomb);
                    enemyTanks.remove(tank);
                }
                break;
            case 1://坦克向右的方向
            case 3://坦克向左的方向
                if (s.x > tank.getX() && s.x < tank.getX() + 60 && s.y > tank.getY() && s.y < tank.getY() + 40) {
                    s.isLive = false;
                    tank.isLive = false;
                    Bomb bomb = new Bomb(tank.getX(), tank.getY());
                    bombs.add(bomb);
                    //当我的子弹击中敌人坦克后，将tank从Vector移除
                    enemyTanks.remove(tank);
                }
                break;
        }
    }

    //判断是否击中了敌人坦克
    //如果我们的坦克可以发射多个子弹
    //在判断我方子弹是否击中敌人坦克时，就需要把我们的子弹集合中
    //所有的子弹，都取出和敌人的所有坦克，进行判断
    public void hitEnemyTank(){
        for(int i = 0; i < hero.shots.size(); i++){
            Shot shot = hero.shots.get(i);
            if(shot.isLive && (shot != null)){
                for (int j = 0; j < enemyTanks.size(); j++){
                    EnemyTank tank = enemyTanks.get(j);
                    hitTank(shot,tank);
                }
            }
        }
    }

    //编写方法，判断地方坦克是否击中我方坦克
    public void hitHero(){
        //遍历所有敌人的坦克
        for (int i = 0; i < enemyTanks.size(); i++) {
            //取出敌人坦克
            EnemyTank tank = enemyTanks.get(i);
            //比那里tank对象的所有子弹
            for (int j = 0; j < tank.shots.size(); j++) {
                //取出子弹
                Shot shot = tank.shots.get(j);
                //判断shot是否击中我方的坦克
                hitTank(shot,hero);

            }

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
            //判断是否击中了敌人坦克
            hitEnemyTank();

            //判断敌人坦克是否击中了我方坦克
            hitHero();
            this.repaint();
        }
    }
}

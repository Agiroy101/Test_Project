package hsp.chapter16.event_;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BallMove extends JFrame{

    MyPanel mp = null;

    public static void main(String[] args) {
        BallMove ballMove = new BallMove();

    }

    public BallMove(){
        mp = new MyPanel();
        this.add(mp);
        this.setSize(400,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        //窗口JFrame对象可以监听键盘事件，即可以监听到面板发生的键盘事件
        this.addKeyListener(mp);
    }
}

//面板,可以画出小球
//KeyListener是监听器，可以监听键盘事件
class MyPanel extends JPanel implements KeyListener {

    //为了让小球可以涌动，把他的左上角的坐标(x,y)设置变量
    int x = 10;
    int y = 10;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x,y,20,20);
    }

    //有字符输出是，该方法就会输出
    @Override
    public void keyTyped(KeyEvent e) {

    }

    //当某个键按下，该方法会触发
    @Override
    public void keyPressed(KeyEvent e) {
//        System.out.println(e.getKeyChar()+"被按下。。。。");
//        System.out.println((char)e.getKeyCode()+"被按下。。。。");

        //根据用户按下的不同键，来处理小球的移动（上下左右的键）
//        if(e.getKeyCode() == KeyEvent.VK_DOWN){//KeyEvent.VK_DOWN就是向下的箭头对应的code
        if(e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN){
            y++;
        }else if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
            y--;
        }else if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) {
            x++;
        }else if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) {
            x--;
        }

        this.repaint();
    }

    //当某个键释放，该方法会触发
    @Override
    public void keyReleased(KeyEvent e) {

    }
}

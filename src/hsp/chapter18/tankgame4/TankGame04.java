package hsp.chapter18.tankgame4;

import javax.swing.*;

public class TankGame04 extends JFrame {

    //定义MyPanel
    MyPanel mp = null;
    public static void main(String[] args) {
        TankGame04 tankGame02 = new TankGame04();
    }

    public TankGame04(){
        mp = new MyPanel();
        //将mp放入到Thread，并启动
        Thread thread = new Thread(mp);
        thread.start();
        this.add(mp);//把面板（就是游戏的绘图区域）
        this.setSize(1200,1000);
        this.addKeyListener(mp);//让JFrame 监听mp的键盘事件
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

}

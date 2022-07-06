package hsp.chapter16.draw_;

import javax.swing.*;
import java.awt.*;

public class DrawCircle extends JFrame{ //JFrame对应窗口，可以理解成一个画框

    //定义一个面板
    private MyPanel mp = null;
    public static void main(String[] args) {
        new DrawCircle();
        System.out.println("退出程序");
    }

    public DrawCircle(){
        //初始化面板
        mp = new MyPanel();
        //把面板放入到窗口（画框）
        this.add(mp);
        //设置窗口的大小
        this.setSize(2000,2000);
        //当点击窗口的小×，程序完全退出
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置可以显示
        this.setVisible(true);


    }


}

//1.先定义一个MyPanel，继承JPanel类，画图形，就在面板上画
class MyPanel extends JPanel{

    //1.MyPanel对象就是一个画板
    //2.Graphics g把g理解成一支画笔
    //3.Graphics 提供了很多绘图的方法
    @Override
    public void paint(Graphics g) {//绘图方法
        super.paint(g);//调用父类的方法完成初始化
        System.out.println("paint方法被调用");
        //画出一个圆形（椭圆）
        g.drawOval(0,0,100,100);

        //画直线
        g.drawLine(0,0,100,100);
        g.drawLine(100,0,0,100);

        //画矩形边框
        g.drawRect(0,0,100,100);

        //填充矩形
        g.setColor(Color.green);
        g.fillRect(100,100,100,100);

        //填充椭圆
        g.setColor(Color.red);
        g.fillOval(100,100,100,100);

        //画图片
        //1.加载图片资源
        Image image = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/logo.jpg"));
        g.drawImage(image,200,200,500,500,this);

        //给画笔设置颜色和字体
        //设置画笔的字体 setFont(Font font)
        //设置画笔的颜色 setColor(Color c)
        g.setColor(Color.pink);
        g.setFont(new Font("宋体",Font.BOLD,20));
        //这里设置的800,800坐标是字体左下角
        g.drawString("你好世界",800,800);

        //绘制坦克
        g.fillRect(900,100,20,100);
        g.fillRect(920, 120,50,60);//中间的长方体
        g.fillRect(950,100,20,100);
        g.setColor(Color.blue);
        g.fillOval(920,135,30,30);
        g.fillRect(933,100,4,36);

    }
}
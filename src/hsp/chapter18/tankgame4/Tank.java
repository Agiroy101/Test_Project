package hsp.chapter18.tankgame4;

public class Tank {
    private int x;//坦克的横坐标
    private int y;//坦克的纵坐标
    private int direct;//坦克方向 0向上 1向右 2向下 3向左
    private int speed = 1;
    boolean isLive = true;

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

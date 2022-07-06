package hsp.chapter20.tankgame6;

import java.io.*;
import java.util.Vector;

/**
 * @author Agiroy
 * @date 2022/4/21 18:33
 * @effect 该类用于记录相关信息的，和文件交互
 */

public class Recorder {
    //定义变量，记录我方击毁敌人坦克数
    private static int allEnemyTankNum = 0;
    //定义IO对象，准备写数据到文件中
    private static FileWriter fw = null;
    private static BufferedWriter bw = null;
    private static BufferedReader br = null;

    //把记录文件保存到src下
    private static String recordFile = "src\\myRecord.txt";
    //定义一个Vector，指向MyP对象的敌人坦克的Vector
    private static Vector<EnemyTank> enemyTanks = null;

    //定义一个Node的Vector，用于保存敌人的信息node
    private static Vector<Node> nodes = new Vector<>();

    public static void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        Recorder.enemyTanks = enemyTanks;
    }

    //返回记录文件的目录
    public static String getRecordFile() {
        return recordFile;
    }

    //增加一个方法，用于读取recordFile，恢复相关信息
    public static Vector<Node> getNodesAndEnemyTankRec() {

        try {
            br = new BufferedReader(new FileReader(recordFile));
            allEnemyTankNum = Integer.parseInt(br.readLine());
            //循环读取文件，生成nodes集合
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] s = line.split(" ");
                Node node = new Node(Integer.parseInt(s[0]), Integer.parseInt(s[1]), Integer.parseInt(s[2]));
                nodes.add(node);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }

        return nodes;


    }


    //增加一个方法，当游戏退出时，我们将allEnemyTankNum保存到recordFile
    //对keepRecord进行升级，保存敌人坦克的坐标和方向
    public static void keepRecord() {
        try {
            bw = new BufferedWriter(new FileWriter(recordFile));
            bw.write(allEnemyTankNum + "\r\n");

            //遍历敌人坦克的Vector，然后根据情况保存即可
            //OOP,定义一个属性，然后通过set方法得到敌人坦克的Vector
            for (int i = 0; i < enemyTanks.size(); i++) {
                //取出敌人坦克
                EnemyTank tank = enemyTanks.get(i);
                if (tank.isLive) {
                    //保存该tank的信息
                    String record = tank.getX() + " " + tank.getY() + " " + tank.getDirect();
                    //写入到文件
                    bw.write(record + "\r\n");

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null)
                    bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static int getAllEnemyTankNum() {
        return allEnemyTankNum;
    }

    public static void setAllEnemyTankNum(int allEnemyTankNum) {
        Recorder.allEnemyTankNum = allEnemyTankNum;
    }

    //当我方坦克击毁一个敌方坦克，就应当allEnemyTankNum++
    public static void addAllEnemyTankNum() {
        allEnemyTankNum++;
    }
}

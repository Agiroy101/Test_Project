package hsp.chapter19.properties_;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Agiroy
 * @date 2022/4/20 18:37
 * @effect
 */

public class Properties01 {
    public static void main(String[] args) throws IOException {

        //读取mysql.properties文件，并得到ip，user和pwd
        BufferedReader br = new BufferedReader(new FileReader("D:\\Test_Project\\src\\hsp\\chapter19\\mysql.properties"));
        String line = "";
        while ((line = br.readLine()) != null){
            String[] s = line.split("=");
            System.out.println(s[0] + "值为：" + s[1]);
        }

        br.close();



    }
}

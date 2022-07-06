package hsp.chapter19.homework;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @author Agiroy
 * @date 2022/4/21 14:22
 * @effect
 */

public class Homework02 {
    public static void main(String[] args) throws Exception{
        String filePath = "d:\\hello.txt";
        String line;
        int i = 0;
        BufferedReader br = new BufferedReader(new FileReader(filePath));
//        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath),"utf-8"));

        while ((line = br.readLine())!= null){
            System.out.println((++i) + line);
        }

        br.close();
    }
}

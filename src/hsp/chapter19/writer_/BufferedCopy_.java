package hsp.chapter19.writer_;

import java.io.*;

public class BufferedCopy_ {
    public static void main(String[] args) {

        //1.BufferedReader和 BufferedWriter都是按照字符操作
        //2.不要去操作二进制文件（图片，音频, doc, pdf等），可能造成文件损坏

        String srcFilePath = "d:\\hello.txt";
        String destFilePath = "d:\\a2.txt";

        BufferedReader br = null;
        BufferedWriter bw = null;
        String line;

        try {
            br = new BufferedReader(new FileReader(srcFilePath));
            bw = new BufferedWriter(new FileWriter(destFilePath));
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
                if (bw != null)
                    bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}

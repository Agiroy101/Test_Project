package hsp.chapter19.outputstream_;

import java.io.*;

public class BufferedCopy02 {
    public static void main(String[] args) {

        String srcFilePath = "d:\\logo.jpg";
        String destFilePath = "d:\\1.jpg";

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        byte[] buf = new byte[1024];
        int readLen = 0;

        try {
            bis = new BufferedInputStream(new FileInputStream(srcFilePath));
            bos = new BufferedOutputStream(new FileOutputStream(destFilePath));
            while ((readLen = bis.read(buf)) != -1) {
                bos.write(buf, 0, readLen);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bis != null){
                    bis.close();
                }
                if (bos != null){
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}

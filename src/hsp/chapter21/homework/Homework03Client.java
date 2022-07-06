package hsp.chapter21.homework;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author Agiroy
 * @date 2022/4/25 13:37
 * @effect
 */

public class Homework03Client {
    public static void main(String[] args) throws Exception {

        //接受用户拒输入，指定下载文件名
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要下载的文件名");
        String downloadFileName = scanner.nextLine();

        //连接服务端，准备发送
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(downloadFileName.getBytes());
        socket.shutdownOutput();

        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        byte[] bytes = StreamUtils.streamToByteArray(bis);

        String destFilePath = "src\\" + downloadFileName + ".mp3";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFilePath));
        bos.write(bytes);

        bos.close();
        bis.close();
        outputStream.close();
        socket.close();

    }
}

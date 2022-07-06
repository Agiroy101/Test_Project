package hsp.chapter21.homework;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author Agiroy
 * @date 2022/4/24 18:21
 * @effect
 */

public class Homework01Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);

        OutputStream os = socket.getOutputStream();
        os.write("hello".getBytes());
        socket.shutdownOutput();

        InputStream is = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int readLen = 0;
        while ((readLen = is.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, readLen));
        }
        is.close();
        os.close();
        socket.close();

    }
}

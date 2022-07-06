package hsp.chapter21.homework;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Agiroy
 * @date 2022/4/24 18:21
 * @effect
 */

public class Homework01Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = serverSocket.accept();

        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();
        String s = "";
        byte[] bytes = new byte[1024];
        int readLen = 0;
        while ((readLen = is.read(bytes)) != -1) {
            s = new String(bytes, 0, readLen);
        }
        System.out.println(s);
        if (s.equals("name")){
            os.write("我是Agiroy".getBytes());
        }else if(s.equals("hobby")){
            os.write("编写java程序".getBytes());
        }else {
           os.write("你说啥呢".getBytes());
        }
        socket.shutdownOutput();

        os.close();
        is.close();
        socket.close();

    }
}

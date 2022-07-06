package hsp.chapter21.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Agiroy
 * @date 2022/4/24 14:02
 * @effect
 */

public class SocketTCP01Server {
    public static void main(String[] args) throws IOException {

        //1.在本机的9999端口监听，等待连接
        //细节：要求在本机没有其他服务在监听（占用）9999端口
        //细节：这个ServerSocket可以通过accept()返回多个Socket[多个客户端连接服务器的并发（多并发）]
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端，在9999端口监听，等待连接。。。。");

        //2.当没有客户端连接9999端口时，程序会阻塞，等待连接
        //如果有客户端连接，则会返回Socket对象，程序继续
        Socket socket = serverSocket.accept();
        System.out.println("服务端 socket = " + socket.getClass());

        //3.通过socket.getInputStream()读取客户端写入到数据通道的数据，显示
        InputStream inputStream = socket.getInputStream();

        //4.IO读取
        byte[] buf = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(buf)) != -1){
            System.out.println(new String(buf,0,readLen));//根据读取到的实际长度显示内容
        }

        //关闭流和socket
        inputStream.close();
        socket.close();
        serverSocket.close();


    }
}

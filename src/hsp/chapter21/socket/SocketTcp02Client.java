package hsp.chapter21.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author Agiroy
 * @date 2022/4/24 14:09
 * @effect
 */

public class SocketTcp02Client {
    public static void main(String[] args) throws IOException {
        //1.连接服务器（ip，端口）
        //连接本机的9999端口,如果连接成功，返回Socket对象
//        InetAddress localHost = InetAddress.getLocalHost();
//        System.out.println(localHost);
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端 socket返回=" + socket.getClass());

        //2.连接上后，生成Socket，通过socket.getOutputStream()
        //得到和socket对象关联的输出流对象
        OutputStream outputStream = socket.getOutputStream();

        //3.通过输出流，写入数据到数据通道
        outputStream.write("Hello,server".getBytes());

        //设置结束标记
        socket.shutdownOutput();

        //4.获取和socket关联的输入流，读取数据（字节），并显示
        InputStream inputStream = socket.getInputStream();
        byte[] buf = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(buf)) != -1) {
            System.out.println(new String(buf, 0 ,readLen));
        }

        //关闭流对象和socket，必须关闭
        inputStream.close();
        outputStream.close();
        socket.close();
        System.out.println("客户端退出");

    }
}

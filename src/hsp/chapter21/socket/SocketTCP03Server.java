package hsp.chapter21.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Agiroy
 * @date 2022/4/24 14:02
 * @effect
 */

public class SocketTCP03Server {
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


        //4.IO读取，使用字符流
        String line = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        line = br.readLine();
        System.out.println(line);


        //5.获取socket相关联的输出流
        OutputStream outputStream = socket.getOutputStream();

        //使用字符输出流的方式回复信息
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        bw.write("heollo,client 字符流");
        bw.newLine();//插入一个换行表示结束标记
        bw.flush();//手动刷新

        //设置结束标记
//        socket.shutdownOutput();


        //关闭流和socket
        bw.close();
        br.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务器退出");


    }
}

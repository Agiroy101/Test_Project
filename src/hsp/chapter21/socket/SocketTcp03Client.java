package hsp.chapter21.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author Agiroy
 * @date 2022/4/24 14:09
 * @effect
 */

public class SocketTcp03Client {
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

        //3.通过输出流，写入数据到数据通道,要求使用字符流
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        bw.write("hello,server 字符流");
        bw.newLine();//插入一个换行符，表示写入的内容结束，注意，要求对方使用readLine()方法！！！！
        bw.flush();//如果使用的字符流，需要手动刷新，否则数据不会写入数据通道

        //设置结束标记
//        socket.shutdownOutput();

        //4.获取和socket关联的输入流，读取数据（字节），并显示
        InputStream inputStream = socket.getInputStream();

        //使用字符输入流的方式得到信息
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String s = br.readLine();        System.out.println(s);

        //关闭流对象和socket，必须关闭
        br.close();
        bw.close();
        socket.close();
        System.out.println("客户端退出");

    }
}

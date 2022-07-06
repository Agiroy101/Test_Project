package hsp.chapter21.upload;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author Agiroy
 * @date 2022/4/24 15:45
 * @effect 文件上传的客户端
 */

public class TCPFileUploadClient {
    public static void main(String[] args) throws Exception {

        //客户端连接服务端8888，得到Socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(),8888);

        //创建读取磁盘文件的输入流
        String filePath = "d:\\logo.jpg";
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File(filePath)));

        //bytes就是filePath对应的字节数组
        byte[] bytes = StreamUtils.streamToByteArray(bis);

        //通过socket获取到输出流，将bytes数据发送给服务端
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(bytes);//将文件对应的字节数组的内容，写入到数据通道

        socket.shutdownOutput();//设置写入数据的结束标记

        //通过socket对象得到服务器发送的回复信息
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String s = br.readLine();
        System.out.println(s);

        //使用StreamUtils的方法，直接将InputSream读取到的内容转成字符串
        String s1 = StreamUtils.streamToString(socket.getInputStream());
        System.out.println(s1);


        //关闭相关的流
        br.close();
        bos.close();
        bis.close();
        socket.close();


    }
}

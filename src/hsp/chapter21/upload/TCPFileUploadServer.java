package hsp.chapter21.upload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Agiroy
 * @date 2022/4/24 15:45
 * @effect 文件上传的服务端
 */

public class TCPFileUploadServer {
    public static void main(String[] args) throws Exception {

        //1.服务端在本机监听8888端口
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务端在8888端口监听");
        //2.等待客户端联机
        Socket socket = serverSocket.accept();

//        InputStream inputStream = socket.getInputStream();
//        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(String.valueOf(inputStream)));
//        byte[] buf = new byte[1024];
//        int readLen = 0;
//        while ((readLen = bis.read(buf))!= -1){
//
//        }

        //读取客户端发送的数据
        //通过Socket得到输入流
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        byte[] bytes = StreamUtils.streamToByteArray(bis);

        //将得到的bytes数组，写入到指定的路径，就得到一个文件了
        String destFilePath = "src\\logo.jpg";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFilePath));
        bos.write(bytes);

        //向客户端回复”收到图片“
        //通过socket获取到输出流（字符）
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write("收到图片");
        bw.flush();
//        bw.newLine();
        socket.shutdownOutput();



        //关闭其他流
        bw.close();
        bos.close();
        bis.close();
        socket.close();
        serverSocket.close();


    }
}

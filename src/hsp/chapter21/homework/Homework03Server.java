package hsp.chapter21.homework;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Agiroy
 * @date 2022/4/25 13:34
 * @effect 文件下载的服务端
 */

public class Homework03Server {
    public static void main(String[] args) throws Exception {

        //监听9999端口
        ServerSocket serverSocket = new ServerSocket(9999);
        //等待客户端连接
        Socket socket = serverSocket.accept();
        //读取客户端发送要下载的文件名
        InputStream inputStream = socket.getInputStream();
        byte[] buf = new byte[1024];
        int len = 0;
        String downloadFileName = "";
        //使用了while循环，考虑到将来客户端发送的数据较大的情况
        while ((len = inputStream.read(buf)) != -1){
            downloadFileName += new String(buf,0,len);
        }

        System.out.println("客户端希望下载的文件名：" + downloadFileName);

        String resFileName = "";
        if (downloadFileName.equals("高山流水")){
            resFileName = "C:\\Users\\h6108\\Desktop\\分享资料\\高山流水.mp3";
        }else {
            resFileName = "C:\\Users\\h6108\\Desktop\\分享资料\\无名.mp3";
        }

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(resFileName));

        //使用工具类StreamUtils，读取文件到一个字节数组
        byte[] bytes = StreamUtils.streamToByteArray(bis);

        //得到Socket相关的输出流
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(bytes);
        socket.shutdownOutput();

        inputStream.close();
        bos.close();
        bis.close();
        socket.close();
        serverSocket.close();

    }
}

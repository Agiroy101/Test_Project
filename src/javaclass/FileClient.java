package javaclass;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class FileClient {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub

        Socket socket = new Socket("127.0.0.1", 10001); // 创建客户端Socket
        OutputStream out = socket.getOutputStream(); // 获取Socket的输出流对象
        // 创建FileInputStream对象
        FileInputStream fis = new FileInputStream("d:\\xm.jpg");
        byte[] buf = new byte[1024]; // 定义一个字节数组
        int len; // 定义一个int类型的变量len
        while ((len = fis.read(buf)) != -1) { // 循环读取数据
            out.write(buf, 0, len);
        }
        socket.shutdownOutput(); // 关闭客户端输出流
        InputStream in = socket.getInputStream(); // 获取Socket的输入流对象
        byte[] bufMsg = new byte[1024]; // 定义一个字节数组
        int num = in.read(bufMsg); // 接收服务端的信息
        String Msg = new String(bufMsg, 0, num);
        System.out.println(Msg);
        fis.close(); // 关键输入流对象
        socket.close(); // 关闭Socket对象
    }

}


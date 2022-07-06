package javaclass;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerDemogaiban {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub

        new TCPServer().listen();
    }

}

class TCPServer {
    private static final int PORT = 7788;

    public void listen() throws Exception {
        ServerSocket serverSocket = new ServerSocket(PORT);
        while (true) {
            final Socket client = serverSocket.accept();
            new Thread() {
                public void run() {
                    OutputStream os;
                    try {
                        os = client.getOutputStream();
                        System.out.println("开始与客户端交互数据");
                        os.write(("欢迎你!").getBytes());
                        Thread.sleep(5000);
                        System.out.println("结束与客户端交互数据");
                        os.close();
                        client.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                ;
            }.start();
        }
    }
}

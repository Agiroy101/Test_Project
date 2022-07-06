package javaclass;

import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;

public class ClientDemo {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub

        new TCPClient().connect();
    }

}

class TCPClient {
    private static final int PORT = 7788;

    public void connect() throws Exception {
        Socket client = new Socket(InetAddress.getLocalHost(), PORT);
        InputStream is = client.getInputStream();
        byte[] buf = new byte[1024];
        int len = is.read(buf);
        System.out.println(new String(buf, 0, len));
        client.close();
    }
}

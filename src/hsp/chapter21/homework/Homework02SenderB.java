package hsp.chapter21.homework;

import java.io.IOException;
import java.net.*;

/**
 * @author Agiroy
 * @date 2022/4/24 18:45
 * @effect
 */

public class Homework02SenderB {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8889);
        byte[] buf = "四大名著是哪".getBytes();
        DatagramPacket packet = new DatagramPacket(buf, buf.length, InetAddress.getLocalHost(),8888);
        socket.send(packet);

        buf = new byte[1024];
        packet = new DatagramPacket(buf, buf.length);
        socket.receive(packet);
        System.out.println(new String(packet.getData(),0, packet.getLength()));

        socket.close();

    }
}

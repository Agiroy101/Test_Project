package hsp.chapter21.homework;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author Agiroy
 * @date 2022/4/24 18:45
 * @effect
 */

public class Homework02ReceiverA {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8888);
        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        socket.receive(packet);

        String s = new String(packet.getData(), 0, packet.getLength());
        System.out.println(s);
        String rs = "";
        if (s.equals("四大名著是哪些")) {
            rs = "四大名著是红楼梦水浒传三国演义和西游记";
        } else {
            rs = "what?";
        }
        buf = rs.getBytes();
        packet = new DatagramPacket(buf, buf.length, InetAddress.getLocalHost(),8889);
        socket.send(packet);

        socket.close();
    }
}

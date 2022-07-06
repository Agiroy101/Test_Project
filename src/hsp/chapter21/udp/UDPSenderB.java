package hsp.chapter21.udp;

import java.io.IOException;
import java.net.*;

/**
 * @author Agiroy
 * @date 2022/4/24 17:43
 * @effect UDP接收端
 */

public class UDPSenderB {
    public static void main(String[] args) throws IOException {

        //创建DatagramSocket对象，准备发送和接受数据
        DatagramSocket socket = new DatagramSocket(8889);//可以同时发送和接收数据，在本机所以不能和接收端同一端口

        //2.将需要发送的数据，封装到DatagramPacket对象中
        byte[] bytes = "hello，明天吃火锅".getBytes();
//        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("192.168.14.30"),9999);

        //说明：封装的DatagramPacket对象 bytes内容字节数组，bytes.length,主机（ip），端口
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(),9999);

        socket.send(packet);

        //接受A端回复的信息

        byte[] buf = new byte[1024];
        packet = new DatagramPacket(buf, buf.length);
        socket.receive(packet);


        int length = packet.getLength();//实际接收到的数据长度
        byte[] data = packet.getData();//实际接收到的数据
        System.out.println(new String(data,0,length));


        socket.close();
        System.out.println("发送端B退出");

    }
}

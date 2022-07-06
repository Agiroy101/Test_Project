package hsp.chapter21.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author Agiroy
 * @date 2022/4/24 17:43
 * @effect UDP发送端
 */

public class UDPReceiverA {
    public static void main(String[] args) throws IOException {
        //1.创建一个DatagramSocket对象，准备在9999接收数据
        DatagramSocket socket = new DatagramSocket(9999);
        //2.构建一个DatagramPacket对象，准备接收数据
        //UDP协议 每个数据报的大小限制在64KB内，不适合传输大量数据
        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);

        //3.调用接收方法,将通过网络传输的DatagramPacket对象填充到packet对象
        //当有数据报发送到本机的9999端口时，就会接受到数据
        //如果没有数据报发送到本机9999端口，就会阻塞等待
        System.out.println("接收端A 等待就收数据");
        socket.receive(packet);


        //4.可以吧packet进行拆包，取出数据，并显示
        int length = packet.getLength();//实际接收到的数据长度
        byte[] data = packet.getData();//实际接收到的数据
        System.out.println(new String(data,0,length));

        //发送给B端回复信息

        byte[] bytes = "好的，明天见".getBytes();
        packet = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(),8889);

        socket.send(packet);




        socket.close();
        System.out.println("接收端A退出");


    }
}

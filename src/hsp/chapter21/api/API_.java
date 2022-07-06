package hsp.chapter21.api;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Agiroy
 * @date 2022/4/23 19:11
 * @effect InetAddres类的使用
 */

public class API_ {
    public static void main(String[] args) throws UnknownHostException {

        //获取本机的InetAddress对象
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);

        //根据指定主机名 获取InetAddress对象
        InetAddress host1 = InetAddress.getByName("DESKTOP-HH0LI9A");
        System.out.println(host1);

        //根据域名返回InetAddress对象
        InetAddress host2 = InetAddress.getByName("www.baidu.com");
        System.out.println(host2);

        //通过InetAddress对象，获取对应的地址
        String hostAddress = host2.getHostAddress();
        System.out.println(hostAddress);

        //通过InetAddress对象，获取对应的主机名/或者域名
        String hostName = host2.getHostName();
        System.out.println(hostName);

    }
}

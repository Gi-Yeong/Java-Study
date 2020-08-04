package sec06.exam01_inetaddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressExample {

    public static void main(String[] args) {
        try {
            InetAddress local = InetAddress.getLocalHost();
            System.out.println("내 컴퓨터 IP : " + local.getHostAddress());

            InetAddress[] iaArr = InetAddress.getAllByName("www.daum.net");
            for (InetAddress remote : iaArr) {
                System.out.println("Daum IP : " + remote.getHostAddress());
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}

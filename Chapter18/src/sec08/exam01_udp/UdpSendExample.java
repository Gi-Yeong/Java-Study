package sec08.exam01_udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class UdpSendExample {

    public static void main(String[] args) throws Exception {
        DatagramSocket datagramSocket = new DatagramSocket();

        System.out.println("[발신 시작]");

        for (int i = 0; i < 3; i++) {
            String message = "메시지" + i;
            byte[] byteArrs = message.getBytes(StandardCharsets.UTF_8);
            DatagramPacket datagramPacket = new DatagramPacket(
                    byteArrs, byteArrs.length, new InetSocketAddress("localhost", 5001)
            );

            datagramSocket.send(datagramPacket);
            System.out.println("[보낸 바이트 수: " + byteArrs.length + "]");
        }

        datagramSocket.close();
    }
}

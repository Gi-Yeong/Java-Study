package sec08.exam01_udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.charset.StandardCharsets;

public class UdpReceiveExample {

    public static void main(String[] args) throws Exception {
        DatagramSocket datagramSocket = new DatagramSocket(5001);

        Thread thread = new Thread(() -> {
            System.out.println("[수신 시작]");
            while (true) {
                try {
                    DatagramPacket datagramPacket = new DatagramPacket(new byte[100], 100);
                    datagramSocket.receive(datagramPacket);

                    String data = new String(datagramPacket.getData(), 0, datagramPacket.getLength(), StandardCharsets.UTF_8);

                    System.out.println("[받은 내용 : " + datagramPacket.getSocketAddress() + "]" + data);
                } catch (IOException e) {
                    System.out.println("[수신 종료]");
                    break;
                }
            }
        });

        thread.start();

        Thread.sleep(10000);
        datagramSocket.close();
    }
}

package sec09.exam01_udp;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.StandardProtocolFamily;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class UdpReceiveExample {

    public static void main(String[] args) {
        try {
            DatagramChannel datagramChannel = DatagramChannel.open(StandardProtocolFamily.INET);
            datagramChannel.bind(new InetSocketAddress(5001));

            Thread thread = new Thread(() -> {
                System.out.println("[수신 시작]");
                try {
                    while (true) {
                        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(100);
                        SocketAddress socketAddress = datagramChannel.receive(byteBuffer);

                        byteBuffer.flip();
                        Charset charset = Charset.forName(String.valueOf(StandardCharsets.UTF_8));
                        String data = charset.decode(byteBuffer).toString();

                        System.out.println("[받은 내용: " + socketAddress.toString() + "]" + data);
                    }
                } catch (Exception e) {
                    System.out.println("[수신 종료]");
                }
            });
            thread.start();

            Thread.sleep(10000);
            datagramChannel.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

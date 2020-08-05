package sec09.exam01_udp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.StandardProtocolFamily;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class UdpSendExample {

    public static void main(String[] args) {
        try {
            DatagramChannel datagramChannel = DatagramChannel.open(StandardProtocolFamily.INET);

            System.out.println("[발신 시작]");

            for (int i = 0; i < 3; i++) {
                String data = "메시지" + i;
                Charset charset = Charset.forName(String.valueOf(StandardCharsets.UTF_8));
                ByteBuffer byteBuffer = charset.encode(data);

                int byteCount = datagramChannel.send(byteBuffer, new InetSocketAddress("localhost", 5001));
                System.out.println("[보낸 바이트 수]" + byteCount + " bytes");
            }

            System.out.println("[발신 종료]");
            datagramChannel.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

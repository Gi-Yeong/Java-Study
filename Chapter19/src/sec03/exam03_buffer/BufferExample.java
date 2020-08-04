package sec03.exam03_buffer;

import java.nio.Buffer;
import java.nio.ByteBuffer;

public class BufferExample {

    public static void main(String[] args) {
        System.out.println("[7 바이트 크기로 버퍼 생성]");
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(7);
        printState(byteBuffer);

        byteBuffer.put((byte) 10);
        byteBuffer.put((byte) 11);
        System.out.println("[2바이트 저장 후]");
        printState(byteBuffer);

        byteBuffer.put((byte) 12);
        byteBuffer.put((byte) 13);
        byteBuffer.put((byte) 14);
        System.out.println("[3바이트 저장 후]");
        printState(byteBuffer);

        byteBuffer.flip();
        System.out.println("[flip() 실행 후]");
        printState(byteBuffer);

        byteBuffer.get(new byte[3]);
        System.out.println("[3바이트 읽은 후]");
        printState(byteBuffer);
        
        byteBuffer.mark();
        System.out.println("[현재 위치를 마크 해놈]");
        printState(byteBuffer);

        byteBuffer.get(new byte[2]);
        System.out.println("[2바이트 읽은 후]");
        printState(byteBuffer);
        
        byteBuffer.reset();
        System.out.println("[리셋]");
        printState(byteBuffer);

        byteBuffer.rewind();
        System.out.println("[rewind]");
        printState(byteBuffer);

        byteBuffer.clear();
        System.out.println("[clear]");
        printState(byteBuffer);
    }

    public static void printState(Buffer buffer) {
        System.out.print("position : " + buffer.position());
        System.out.print("\tlimit : " + buffer.limit());
        System.out.println("\tcapacity : " + buffer.capacity());
    }
}

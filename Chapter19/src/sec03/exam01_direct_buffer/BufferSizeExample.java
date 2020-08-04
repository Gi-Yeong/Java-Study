package sec03.exam01_direct_buffer;

import java.nio.ByteBuffer;

public class BufferSizeExample {

    public static void main(String[] args) {
        ByteBuffer directByteBuffer = ByteBuffer.allocateDirect(200 * 1024 * 1024); // 200 MB 운영체제 메모리 영역에 생성
        System.out.println("다이렉트 버퍼가 생성 되었습니다.");

        ByteBuffer nonDirectByteBuffer = ByteBuffer.allocate(200 * 1024 * 1024); // 200 MB JVM Heap Memory 영역에 생성
        System.out.println("넌 다이렉트 버퍼가 생성 되었습니다.");
    }
}

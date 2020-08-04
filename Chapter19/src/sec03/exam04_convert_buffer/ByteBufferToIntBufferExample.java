package sec03.exam04_convert_buffer;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.Arrays;

public class ByteBufferToIntBufferExample {

    public static void main(String[] args) {
        // int[] -> IntBuffer -> ByteBuffer
        int[] writeDate = {10, 20};
        IntBuffer writeIntBuffer = IntBuffer.wrap(writeDate);
        ByteBuffer writeByteBuffer = ByteBuffer.allocate(writeIntBuffer.capacity() * 4);
        for (int i = 0; i < writeDate.length; i++) {
            writeByteBuffer.putInt(writeIntBuffer.get(i));
        }

        writeByteBuffer.flip();

        // byteBuffer -> IntBuffer -> int[]
        ByteBuffer readByteBuffer = writeByteBuffer;
        IntBuffer readIntBuffer = writeByteBuffer.asIntBuffer();

        int[] readData = new int[readIntBuffer.capacity()];
        readIntBuffer.get(readData);

        System.out.println("[배열 복원]" + Arrays.toString(readData));
    }
}

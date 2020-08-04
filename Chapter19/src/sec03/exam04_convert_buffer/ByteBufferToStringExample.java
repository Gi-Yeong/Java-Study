package sec03.exam04_convert_buffer;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class ByteBufferToStringExample {

    public static void main(String[] args) {
        Charset charset = Charset.forName(String.valueOf(StandardCharsets.UTF_8));

        // 문자열 -> 인코딩 -> ByteBuffer
        String data = "안녕하세요";
        ByteBuffer byteBuffer = charset.encode(data);

        // ByteBuffer -> 디코딩 -> CharBuffer -> 문자열
        data = charset.decode(byteBuffer).toString();
        System.out.println(data);

        System.out.println(Float.SIZE);
        System.out.println(Integer.SIZE);
    }
}

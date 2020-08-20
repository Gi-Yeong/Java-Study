package sec02.stream_kind;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FromDirectoryExample {

    public static void main(String[] args) {
        Path path = Paths.get("F:/Study/This is Java");
        try {
            Stream<Path> stream = Files.list(path);
            stream.forEach(s -> System.out.println(s.getFileName()));
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

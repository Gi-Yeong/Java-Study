package sec02.stream_kind;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FromFileContentExample {

    public static void main(String[] args) {
        Path path = Paths.get("F:/Temp/linedata.txt");
        Stream<String> stringStream;

        // Files.lines()
        try {
            stringStream = Files.lines(path, Charset.defaultCharset());
            stringStream.forEach(System.out::println);
            stringStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();

        // BufferedReader 의 lines()
        try {
            File file = path.toFile();
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            stringStream = bufferedReader.lines();
            stringStream.forEach(System.out::println);
            stringStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}

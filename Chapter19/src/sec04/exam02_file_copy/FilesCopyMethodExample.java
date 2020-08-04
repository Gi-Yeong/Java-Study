package sec04.exam02_file_copy;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FilesCopyMethodExample {

    public static void main(String[] args) throws Exception {
        Path from = Paths.get("F:/Temp/choa.gif");
        Path to = Paths.get("F:/Temp/choa2.gif");

        Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.COPY_ATTRIBUTES);

        System.out.println("복사 완료");
    }
}

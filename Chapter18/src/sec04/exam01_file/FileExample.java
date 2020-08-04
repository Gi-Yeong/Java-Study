package sec04.exam01_file;

import java.io.File;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileExample {

    public static void main(String[] args) {
        File dir = new File("F:/Temp/Dir");
        File file1 = new File("F:/Temp/file1.txt");
        File file2 = new File("F:/Temp/file2.txt");
        try {
            File file3 = new File(new URI("file:///F:/Temp/file3.txt"));
            if (!dir.exists()) dir.mkdirs();
            if (file1.exists() == false) file1.createNewFile();
            if (file2.exists() == false) file2.createNewFile();
            if (file3.exists() == false) file3.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }

        File temp = new File("F:/Temp");
        File[] contents = temp.listFiles(); // F:Temp 안에 있는 파일이나 디렉토리를 배열로 만들어서 리턴함
        System.out.println("날짜           시간          형태 크기      이름");
        System.out.println("------------------------------------------------------");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm:ss");
        for (File file: contents) {
            System.out.print(sdf.format(new Date(file.lastModified())));
            if (file.isDirectory()) {
                System.out.print("\t<DIR>\t\t\t" + file.getName());
            } else {
                System.out.print("\t\t\t" + file.length() + "\t" + file.getName());
            }
            System.out.println();
        }

    }
}

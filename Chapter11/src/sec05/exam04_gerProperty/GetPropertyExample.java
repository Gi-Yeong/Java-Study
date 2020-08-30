package sec05.exam04_gerProperty;

import java.util.Properties;
import java.util.Set;

public class GetPropertyExample {

    public static void main(String[] args) {
        String osName = System.getProperty("os.name");
        String userName = System.getProperty("user.name");
        String userHome = System.getProperty("user.home");
        System.out.println("운영체제 이름:" + osName);
        System.out.println("사용자 이름:" + userName);
        System.out.println("사용자 홈:" + userHome);

        Properties properties = System.getProperties();
        Set keys = properties.keySet();
        for (Object objkey : keys) {
            String key = (String) objkey;
            String value = System.getProperty(key);
            System.out.println(key + " : " + value);
        }
    }
}

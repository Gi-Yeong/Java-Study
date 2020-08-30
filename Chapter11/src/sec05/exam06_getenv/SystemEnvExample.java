package sec05.exam06_getenv;

public class SystemEnvExample {

    public static void main(String[] args) {
        String javaHome = System.getenv("JAVA_HOME");
        System.out.println(javaHome);
    }
}

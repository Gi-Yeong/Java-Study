package sec06.exam03_newinstance;

public class NewInstanceExample {

    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("sec06.exam03_newinstance.ReceiveAction");

        Action action = (Action) clazz.newInstance();
        action.execute();


    }
}

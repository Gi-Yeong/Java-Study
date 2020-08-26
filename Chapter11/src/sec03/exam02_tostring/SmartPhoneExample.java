package sec03.exam02_tostring;

public class SmartPhoneExample {

    public static void main(String[] args) {
        SmartPhone myPhone = new SmartPhone("Google", "Android");
        String strObj = myPhone.toString();

        System.out.println(strObj);

        System.out.println(myPhone);
    }
}

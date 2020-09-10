package sec06.exam02_field_default_value;

public class FieldInitValueExample {

    public static void main(String[] args) {
        FieldInitValue fieldInitValue = new FieldInitValue();

        System.out.println(fieldInitValue.byteField);
        System.out.println(fieldInitValue.shortField);
        System.out.println(fieldInitValue.intField);
        System.out.println(fieldInitValue.longField);

        System.out.println(fieldInitValue.booelanField);
        System.out.println(fieldInitValue.charField);

        System.out.println(fieldInitValue.floatField);
        System.out.println(fieldInitValue.doubleField);

        System.out.println(fieldInitValue.arrField);
        System.out.println(fieldInitValue.referenceField);
    }
}

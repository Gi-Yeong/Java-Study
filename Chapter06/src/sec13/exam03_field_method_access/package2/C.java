package sec13.exam03_field_method_access.package2;

import sec13.exam03_field_method_access.package1.A;

public class C {

    public C() {
        A a = new A();
        a.field1 = 1;
//        a.field2 = 1; default 는 다른 패키지에서 사용 불가
//        a.field3 = 1; private 는 클래스를 벗어나서 사용 불가

        a.method1();
//        a.method2(); default 는 다른 패키지에서 사용 불가
//        a.method3(); private 는 클래스를 벗어나서 사용 불가
    }
}

package sec13.exam02_constructor_access.package2;

import sec13.exam02_constructor_access.package1.A;

public class C {
    A a1 = new A(true);
//    A a2 = new A(); default 접근 제한자는 다른 패키지에서는 호출 불가
//    A a3 = new A("문자열");
}

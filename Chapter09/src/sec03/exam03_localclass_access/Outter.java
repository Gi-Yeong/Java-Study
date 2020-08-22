package sec03.exam03_localclass_access;

public class Outter {
    // 자바 7 이전
    public void method1(final int arg) { // final 을 안 붙이면 컴파일 에러
        final int localVariable = 1;

        class Inner {
            void method() {
                // 여기에 로컬 변수와 지역 변수가 복사되어 사용 됨 (컴파일러가 함)
                // ex)
                // int arg = 10;
                // int localVariable = 1;
                int result = arg + localVariable;
            }
        }
    }


    // 자바 8 이후
    public void method2(int arg) { // final 을 안 붙여도 됨, 하지만 final 특성을 가짐
        int localVariable = 1;

        class Inner {
            // 여기에 로컬 변수와 지역 변수가 필드로 복사되어 사용 됨 (컴파일러가 함),
            // 하지만 final 을 붙이면 java7 처럼 메소드 안에 로컬 변수로 복사하여 사용 됨
            // ex)
            // int arg = 10;
            // int localVariable = 1;
            void method() {
                int result = arg + localVariable;
            }
        }
    }
}

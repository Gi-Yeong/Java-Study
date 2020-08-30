package sec05.exam02_gc;

public class GcExample {

    public static void main(String[] args) {
        Employee emp;

        emp = new Employee(1);
        emp = null;
        emp = new Employee(2);
        emp = new Employee(3);

        System.out.print("emp 가 최종적으로 참조하는 사원 번호");
        System.out.println(emp.eno);
        System.gc();
        // gc 는 원래 프로그램 마지막에 실행 하는 것이 아니라, 중간 중간 메모리를 정리 해야 할때 호출 한다.
    }
}

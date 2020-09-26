package sec05.exam02_final_method;

public class SportsCar extends Car {

    @Override
    public void speedUp() {
        speed += 10;
    }
    
    // final method 는 재정의 할 수 없다
//    public void stop() {
//        
//    }
}

package sec04.exam02_super;

public class SupersonicAirplaneExample {

    public static void main(String[] args) {
        SupersonicAirplane supersonicAirplane = new SupersonicAirplane();
        supersonicAirplane.takeOff();
        supersonicAirplane.fly();
        supersonicAirplane.flyMode = SupersonicAirplane.SUPERSONIC;
        supersonicAirplane.fly();
        supersonicAirplane.flyMode = SupersonicAirplane.NORMAL;
        supersonicAirplane.fly();
        supersonicAirplane.land();
    }
}

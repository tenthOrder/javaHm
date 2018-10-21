package ru.itis;

public class Main {
    public static void main(String[] args) {
        APC apc = new APC("A354P2", "5.56mm", true);
        Car car = new Car("234A12", Car.Layout.FOUR_WHEEL_DRIVE, Car.SteeringWheelSide.LEFT);
        HangGlider hangGlider = new HangGlider("23CASF", "paper", "wood", 1.5);
        HotAirBalloon hotAirBalloon = new HotAirBalloon("3CE421", "polycarbonate", 30);
        Plane plane = new Plane("124CAA", Plane.EngineType.JET, 2);
        Train train = new Train("ADCWC2", 3, "LocomotiveMcLocoFace");
        ParkingLot parkingLot = new ParkingLot(5);
        System.out.println(parkingLot.park(apc));
        System.out.println(parkingLot.park(car));
        System.out.println(parkingLot.park(hangGlider));
        System.out.println(parkingLot.park(hotAirBalloon));
        System.out.println(parkingLot.park(plane));
        System.out.println(parkingLot.park(train));
        parkingLot.leave(3);
        System.out.println(parkingLot.park(train));
        System.out.println(parkingLot.getRegistrationNumber(3));
    }
}

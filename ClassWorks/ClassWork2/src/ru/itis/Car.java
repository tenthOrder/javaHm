package ru.itis;

public class Car extends Transport implements CanChangeHorizontalSpeed, CanTurn {
    private Layout layout;
    private SteeringWheelSide steeringWheelSide;

    public enum Layout {FRONT_WHEEL_DRIVE, REAR_WHEEL_DRIVE, FOUR_WHEEL_DRIVE}
    public enum SteeringWheelSide {LEFT, RIGHT}

    public Car(String registrationNumber, Layout layout, SteeringWheelSide steeringWheelSide) {
        super(registrationNumber);
        this.layout = layout;
        this.steeringWheelSide = steeringWheelSide;
    }

    @Override
    public void changeSpeedBy(double amount) {
        horizontalSpeed += amount;
    }

    @Override
    public void turn(double angle) {
        direction += angle;
    }
}

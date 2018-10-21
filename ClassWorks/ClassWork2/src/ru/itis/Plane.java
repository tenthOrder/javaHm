package ru.itis;

public class Plane extends Transport implements CanChangeHeight, CanTurn, CanChangeHorizontalSpeed {
    private EngineType engineType;
    private int numberOfEngines;

    enum EngineType {PROPELLER, JET};

    public Plane(String registrationNumber, EngineType engineType, int numberOfEngines) {
        super(registrationNumber);
        this.engineType = engineType;
        this.numberOfEngines = numberOfEngines;
    }

    @Override
    public void changeHeightBy(double amount) {
        heightAboveGround += amount;
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

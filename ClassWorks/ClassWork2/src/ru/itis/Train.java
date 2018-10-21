package ru.itis;

public class Train extends Transport implements CanChangeHorizontalSpeed {
    private int numberOfCars;
    private String locomotiveModel;

    public Train(String registrationNumber, int numberOfCars, String locomotiveModel) {
        super(registrationNumber);
        this.numberOfCars = numberOfCars;
        this.locomotiveModel = locomotiveModel;
    }

    @Override
    public void changeSpeedBy(double amount) {
        horizontalSpeed += amount;
    }
}

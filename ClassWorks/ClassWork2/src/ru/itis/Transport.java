package ru.itis;

public abstract class Transport {
    private String registrationNumber;
    protected double horizontalSpeed;
    protected double direction;
    protected double heightAboveGround;

    public Transport(String registrationNumber) {
        this.registrationNumber = registrationNumber;
        this.horizontalSpeed = 0;
        this.direction = 0;
        heightAboveGround = 0;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }
}

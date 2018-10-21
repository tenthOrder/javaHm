package ru.itis;

public class APC extends Transport implements Armed, CanChangeHorizontalSpeed, CanTurn {

    private String weaponCaliber;
    private boolean isAmphibious;

    public APC(String registrationNumber, String weaponCaliber, boolean isAmphibious) {
        super(registrationNumber);
        this.weaponCaliber = weaponCaliber;
        this.isAmphibious = isAmphibious;
    }

    @Override
    public void shoot() {
        System.out.println("BRATATAT");
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

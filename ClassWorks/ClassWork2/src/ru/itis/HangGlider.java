package ru.itis;

public class HangGlider extends Transport implements CanTurn {
    private String sailclothMaterial;
    private String frameMaterial;
    private double glideRatio;

    public HangGlider(String registrationNumber, String sailclothMaterial,
                      String frameMaterial, double glideRatio) {
        super(registrationNumber);
        this.sailclothMaterial = sailclothMaterial;
        this.frameMaterial = frameMaterial;
        this.glideRatio = glideRatio;
    }

    @Override
    public void turn(double angle) {
        direction += angle;
    }
}

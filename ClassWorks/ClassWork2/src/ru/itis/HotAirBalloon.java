package ru.itis;

public class HotAirBalloon extends Transport implements CanChangeHeight {
    private String envelopeMaterial;
    private double envelopeVolume;

    public HotAirBalloon(String registrationNumber, String envelopeMaterial,
                         double envelopeVolume) {
        super(registrationNumber);
        this.envelopeMaterial = envelopeMaterial;
        this.envelopeVolume = envelopeVolume;
    }

    @Override
    public void changeHeightBy(double amount) {
        heightAboveGround += amount;
    }
}

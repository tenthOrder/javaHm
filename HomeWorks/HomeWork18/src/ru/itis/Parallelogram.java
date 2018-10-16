package ru.itis;

public abstract class Parallelogram extends ConvexQuadrilateral {

    protected double acuteAngle;

    public Parallelogram(double x, double y, double a, double b, double acuteAngle) {
        super(x, y, a, b, a, b);
        this.acuteAngle = acuteAngle;
    }

    public double getArea() {
        return a * b * Math.sin(acuteAngle);
    }
}

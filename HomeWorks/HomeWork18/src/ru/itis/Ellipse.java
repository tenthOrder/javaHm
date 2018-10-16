package ru.itis;

public class Ellipse extends Shape {

    protected double majorAxis;
    protected double minorAxis;

    public Ellipse(double x, double y, double majorAxis, double minorAxis) {
        super(x, y);
        this.majorAxis = majorAxis;
        this.minorAxis = minorAxis;
    }

    //approximate
    @Override
    public double getPerimeter() {
        return 4 * (Math.PI * majorAxis * minorAxis
                + (majorAxis - minorAxis) * (majorAxis - minorAxis))
                / (majorAxis + minorAxis);
    }

    @Override
    public double getArea() {
        return majorAxis * minorAxis * Math.PI;
    }

}

package ru.itis;

public class Triangle extends Shape {

    protected static final double A_DEFAULT = 2;
    protected static final double B_DEFAULT = 3;
    protected static final double C_DEFAULT = 4;

    protected double a;
    protected double b;
    protected double c;

    public Triangle(double x, double y, double a, double b, double c) {
        super(x, y);
        if (a < b + c && b < a + c && c < a + b) {
            this.a = a;
            this.b = b;
            this.c = c;
        } else {
            this.a = A_DEFAULT;
            this.b = B_DEFAULT;
            this.c = C_DEFAULT;
        }
    }

    @Override
    public double getPerimeter() {
        return a + b + c;
    }

    //Heron's formula
    @Override
    public double getArea() {
        double semiperimeter = getPerimeter() / 2.0;
        return Math.sqrt(semiperimeter * (semiperimeter - a)
                * (semiperimeter - b) * (semiperimeter - c));
    }
}

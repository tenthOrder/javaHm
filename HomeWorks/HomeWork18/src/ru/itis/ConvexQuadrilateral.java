package ru.itis;

public abstract class ConvexQuadrilateral extends Shape {

    protected double a;
    protected double b;
    protected double c;
    protected double d;

    public ConvexQuadrilateral(double x, double y, double a, double b, double c, double d) {
        super(x, y);
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public double getPerimeter() {
        return a + b + c + d;
    }
}

package ru.itis;

public abstract class Shape {

    protected double x;
    protected double y;

    public Shape(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public abstract double getPerimeter();

    public abstract double getArea();
}

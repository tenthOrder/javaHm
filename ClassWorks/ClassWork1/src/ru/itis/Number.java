package ru.itis;

public class Number {
    protected double a;

    Number(double a) {
        this.a = a;
    }

    public void print() {
        System.out.println(a);
    }

    public double getModule() {
        return Math.abs(a);
    }
}

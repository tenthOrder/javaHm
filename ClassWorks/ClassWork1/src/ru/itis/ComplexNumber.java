package ru.itis;

public class ComplexNumber extends Number {
    protected double b;

    ComplexNumber(double a, double b) {
        super(a);
        this.b = b;
    }

    @Override
    public void print() {
        StringBuilder output = new StringBuilder();
        if (a != 0) {
            output.append(a);
        }
        if (b != 0) {
            if (b > 0 && output.length() > 0) {
                output.append("+");
            }
            output.append(b);
            output.append("i");
        }
        if (output.length() == 0) {
            output.append(0);
        }
        System.out.println(output);
    }


    @Override
    public double getModule() {
        return (Math.sqrt(a * a + b * b));
    }
}

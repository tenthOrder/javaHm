package ru.itis;

public class Quaternion extends ComplexNumber {
    protected double c;
    protected double d;

    Quaternion(double a, double b, double c, double d) {
        super(a, b);
        this.c = c;
        this.d = d;
    }

    @Override
    public void print() {
        StringBuilder output = new StringBuilder();
        if (a != 0) {
            output.append(a);
        }
        if (b != 0) {
            if (b > 0) {
                output.append("+");
            }
            output.append(b);
            output.append("i");
        }
        if (c != 0) {
            if (c > 0) {
                output.append("+");
            }
            output.append(c);
            output.append("j");
        }
        if (d != 0) {
            if (d > 0) {
                output.append("+");
            }
            output.append(d);
            output.append("k");
        }
        if (output.length() == 0) {
            output.append(0);
        }
        System.out.println(output);
    }

    @Override
    public double getModule() {
        return Math.sqrt(a * a + b * b + c * c + d * d);
    }

}

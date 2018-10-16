package ru.itis;

// a and c are the parallel sides, a < c
public class Trapezium extends ConvexQuadrilateral {

    protected static final double A_DEFAULT = 2;
    protected static final double B_DEFAULT = 3;
    protected static final double C_DEFAULT = 6;
    protected static final double D_DEFAULT = 5;

    public Trapezium(double x, double y, double a, double b, double c, double d) {
        super(x, y, a, b, c, d);
        //if condition of existence is violated
        if (!(Math.abs(d - b) < Math.abs(c - a) && Math.abs(c - a) < b + d)) {
            this.a = A_DEFAULT;
            this.b = B_DEFAULT;
            this.c = C_DEFAULT;
            this.d = D_DEFAULT;
            return;
        }
        if (a > c) {
            this.a = c;
            this.c = a;
        }
    }

    @Override
    public double getArea() {
        double semiperimeter = getPerimeter() / 2;
        return (a + c) / Math.abs(c - a)
                * Math.sqrt((semiperimeter - c) * (semiperimeter - a)
                * (semiperimeter - c - b) * (semiperimeter - c - d));
    }
}

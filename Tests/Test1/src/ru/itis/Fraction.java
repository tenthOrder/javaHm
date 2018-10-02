package ru.itis;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction() {
        numerator = 0;
        denominator = 1;
    }

    public Fraction(int numerator, int denominator) {
        setNumerator(numerator);
        setDenominator(denominator);
    }

    public Fraction(Fraction other) {
        this.numerator = other.numerator;
        this.denominator = other.denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        if (denominator < 0) {
            this.numerator *= -1;
            denominator *= -1;
        }
        this.denominator = denominator != 0 ? denominator : 1;
    }

    public void print() {
        System.out.print(numerator + "/" + denominator);
    }

    private int gcd(int first, int second) {
        if (first == second) {
            return first;
        }
        if (first > second) {
            return gcd(first - second, second);
        }
        return  gcd(first, second - first);
    }

    public void optimize() {
        if (numerator != 0) {
            int divisor = gcd(Math.abs(numerator), denominator);
            numerator /= divisor;
            denominator /= divisor;
        }
    }

    public static Fraction add(Fraction first, Fraction second) {
        int numerator = first.numerator * second.denominator + second.numerator * first.denominator;
        int denominator = first.denominator * second.denominator;
        return new Fraction(numerator, denominator);
    }
}

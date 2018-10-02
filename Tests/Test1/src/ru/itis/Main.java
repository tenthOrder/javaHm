package ru.itis;

public class Main {

    public static void main(String[] args) {
        Fraction frac = new Fraction(15, 20);
        frac.optimize();
        frac.print();
    }
}

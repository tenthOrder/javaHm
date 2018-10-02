package ru.itis;

import java.util.Scanner;

public class Program {

    private static double f(double x) {
        return x * x;
    }

    private static double leftRiemannSums(double a, double b, int n) {
        double h = (b - a) / n;
        double result = 0;
        for (double x = a; x < b; x += h) {
            result += f(x) * h;
        }
        return result;
    }

    private static double rightRiemannSums(double a, double b, int n) {
        double h = (b - a) / n;
        double result = 0;
        for (double x = a + h; x <= b; x += h) {
            result += f(x) * h;
        }
        return result;
    }

    private static double byMidpointSums(double a, double b, int n) {
        double h = (b - a) / n;
        double result = 0;
        for (double x = a; x < b; x += h) {
            result += f(x + h / 2) * h;
        }
        return result;
    }

    private static double byTrapezoidalRule(double a, double b, int n) {
        double h = (b - a) / n;
        double result = 0;
        for (double x = a; x < b; x += h) {
            result += (f(x) + f(x + h)) / 2 * h;
        }
        return result;
    }

    private static double bySimpsonRule(double a, double b, int n) {
        double h = (b - a) / n;
        double result = 0;
        for (double x = a; x < b; x += h) {
            result += h / 6 * (f(x) + 4 * f(x + h / 2) + f(x + h));
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        int n = scanner.nextInt();
        System.out.println("Методом левых прямоугольников - " + leftRiemannSums(a, b, n) + ", " + n);
        System.out.println("Методом правых прямоугольников - " + rightRiemannSums(a, b, n) + ", " + n);
        System.out.println("Методом средних прямоугольников - " + byMidpointSums(a, b, n) + ", " + n);
        System.out.println("Методом трапеции - " + byTrapezoidalRule(a, b, n) + ", " + n);
        System.out.println("Методом Симпсона - " + bySimpsonRule(a, b, n) + ", " + n);
    }
}

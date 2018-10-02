package ru.itis;

import java.util.Scanner;

public class Program {

    private static int calc(int n, int cur, int last1, int last2 ) {
        return n == cur ? last1 + last2 : calc(n, cur + 1, last1 + last2, last1);
    }

    public static int fib(int n) {
        if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else{
            return calc(n, 3, 1, 0);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(fib(scanner.nextInt()));
    }
}

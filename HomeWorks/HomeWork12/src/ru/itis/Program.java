package ru.itis;

import java.util.Scanner;

public class Program {

    private static void toUpper(char[] text) {
        for (int i = 0; i < text.length; i++) {
            if (text[i] >= 'a' && text[i] <= 'z') {
                text[i] -= 32;
            }
        }
    }

    private static void toLower(char[] text) {
        for (int i = 0; i < text.length; i++) {
            if (text[i] >= 'A' && text[i] <= 'Z') {
                text[i] += 32;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char anArray[] = scanner.nextLine().toCharArray();
        toUpper(anArray);
        System.out.println(anArray);
        toLower(anArray);
        System.out.println(anArray);
    }
}

package ru.itis;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstText = scanner.nextLine();
        String secondText = scanner.nextLine();
        PlagiarismChecker plagiarismChecker = new PlagiarismChecker(firstText, secondText);
        System.out.println(plagiarismChecker.getMeasure());
    }
}

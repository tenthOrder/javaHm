package ru.itis;

import java.util.Random;
import java.util.Scanner;

public class Main {

    static int mainSum = 0;

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int[] mainArray;

        int numbersCount = scanner.nextInt();
        int threadsCount = scanner.nextInt();

        mainArray = new Random().ints(numbersCount, 0, 1001).toArray();

        int expectedSum = 0;
        for (int num : mainArray) {
            expectedSum += num;
        }

        CounterThread[] threads = new CounterThread[threadsCount];

        int rangeSize = numbersCount / threadsCount;
        int leftovers = numbersCount - rangeSize * threadsCount;
        int start = 0;
        for (int i = 0; i < threadsCount; i++) {
            int finish = start + rangeSize;
            if (leftovers > 0) {
                leftovers--;
                finish++;
            }
            threads[i] = new CounterThread(start, finish, mainArray);
            start = finish;
        }
        for (CounterThread thread : threads) {
            thread.start();
        }

        for (CounterThread thread : threads) {
            thread.join();
        }

        System.out.println(Integer.compare(mainSum, expectedSum));
    }
}
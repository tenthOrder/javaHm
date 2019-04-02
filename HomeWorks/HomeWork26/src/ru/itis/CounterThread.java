package ru.itis;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CounterThread extends Thread {
    private int start;
    private int finish;
    private int[] array;

    private static final Lock lock = new ReentrantLock();

    public CounterThread(int start, int finish, int[] array) {
        this.start = start;
        this.finish = finish;
        this.array = array;
    }

    @Override
    public void run() {
        int sum = 0;
        for (int i = start; i < finish; i++) {
            sum += array[i];
        }
        lock.lock();
        Main.mainSum += sum;
        lock.unlock();
    }
}
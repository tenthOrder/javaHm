package ru.itis;

public interface CellQueue {
    void enqueue(Cell cell);

    Cell dequeue();

    boolean isEmpty();
}

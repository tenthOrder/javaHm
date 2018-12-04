package ru.itis;

public interface Iterator<T extends Comparable<T>> {
    boolean hasNext();
    T next();
}

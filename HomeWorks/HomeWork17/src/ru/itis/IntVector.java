package ru.itis;

class IntVector {
    private int[] elements;
    private int count;

    IntVector(int n) {
        elements = new int[n];
        count = n;
    }

    IntVector(int[] array) {
        this(array.length);
        for (int i = 0; i < count; i++) {
            elements[i] = array[i];
        }
    }

    public double length() {
        return Math.sqrt(scalarProduct(this, this));
    }

    public static int scalarProduct(IntVector first, IntVector second) {
        int result = 0;
        for (int i = 0; i < first.count; i++) {
            result += first.elements[i] * second.elements[i];
        }
        return result;
    }

    public static double cosBetween(IntVector first, IntVector second) {
        return scalarProduct(first, second) / (first.length() * second.length());
    }
}

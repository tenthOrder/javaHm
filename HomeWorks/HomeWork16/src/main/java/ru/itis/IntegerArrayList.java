package ru.itis;

import java.util.Arrays;

public class IntegerArrayList {
    private int[] elements;
    private int count;
    private boolean sorted;

    public IntegerArrayList() {
        elements = new int[10];
        count = 0;
        sorted = true;
    }

    private void ensureCapacity(int n) {
        if (n > elements.length) {
            int[] newElements = new int[n * 3 / 2];
            for (int i = 0; i < count; i++) {
                newElements[i] = elements[i];
            }
            elements = newElements;
        }
    }

    public void addElement(int element) {
        ensureCapacity(count + 1);
        elements[count++] = element;
        if (count > 1 && elements[count - 2] > elements[count - 1]) {
            sorted = false;
        }
    }

    public int size() {
        return count;
    }

    public void remove(int position) {
        if (count > position) {
            count--;
            for (int i = position; i < count; i++) {
                elements[i] = elements[i + 1];
            }
        }
    }

    public void reverse() {
        sorted = false;
        int tmp;
        for (int i = 0; i < count / 2; i++) {
            tmp = elements[i];
            elements[i] = elements[count - i - 1];
            elements[count - i - 1] = tmp;
        }
    }

    private int binarySearch(int target) {
        int l = 0;
        int r = count;
        int answer = -1;
        while (l != r) {
            int m = l + (r - l) / 2;
            if (elements[m] == target) {
                answer = m;
                l = r;
            } else if (target < elements[m]) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return answer;
    }

    public int indexOf(int element) {
        if (sorted) {
            return binarySearch(element);
        }
        for (int i = 0; i < count; i++) {
            if (element == elements[i]) {
                return i;
            }
        }
        return -1;
    }

    public void sort() {
        if (sorted) {
            return;
        }
        Arrays.sort(elements, 0, count);
    }

    public void print() {
        System.out.print("[");
        for (int i = 0; i < count - 1; i++) {
            System.out.print(elements[i] + " ");
        }
        System.out.println(elements[count - 1] + "]");
    }


    public void merge(IntegerArrayList second) {
        int newCount = count + second.size();
        ensureCapacity(newCount);
        for (int i = 0; i < second.size(); i++) {
            elements[i + count] = second.elements[i];
        }
        if (!second.sorted || elements[count] > elements[count + 1]) {
            sorted = false;
        }
        count = newCount;
    }
}

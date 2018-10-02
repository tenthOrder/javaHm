package ru.itis;

public class Main {

    public static void main(String[] args) {
        IntegerArrayList arList = new IntegerArrayList();
        for (int i = 0; i < 11; i++) {
            arList.addElement(i);
        }
        arList.print();
        System.out.println(arList.size());
        for (int i = 0; i < 3; i++) {
            arList.remove(0);
        }
        arList.print();
        arList.reverse();
        arList.print();
        System.out.println(arList.indexOf(9));
        arList.sort();
        arList.print();
        IntegerArrayList arListSecond = new IntegerArrayList();
        for (int i = 1; i > - 11; i--) {
            arListSecond.addElement(i);
        }
        arListSecond.print();
        arList.merge(arListSecond);
        arList.print();
    }
}

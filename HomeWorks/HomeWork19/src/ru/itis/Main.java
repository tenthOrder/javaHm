package ru.itis;

import java.io.FileInputStream;

public class Main {

    public static void main(String[] args) throws Exception {
        MyScanner myScanner = new MyScanner(new FileInputStream("input.txt"));
        System.out.println(myScanner.nextInt());
        System.out.println(myScanner.nextDouble());
        System.out.println("c" + myScanner.nextString() + "c");
        System.out.println(myScanner.nextInt());
    }
}

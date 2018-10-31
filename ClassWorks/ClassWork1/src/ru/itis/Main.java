package ru.itis;

public class Main {

    public static void main(String[] args) {
        Number number = new Number(10.0);
        ComplexNumber complexNumber = new ComplexNumber(-2, 3.5);
        Quaternion quaternion = new Quaternion(0, 3.4, 0, 2);
        Quaternion zeroQuaternion = new Quaternion(0, 0, 0, 0);
        number.print();
        System.out.println(number.getModule());
        complexNumber.print();
        System.out.println(complexNumber.getModule());
        quaternion.print();
        System.out.println(quaternion.getModule());
        zeroQuaternion.print();
        System.out.println(zeroQuaternion.getModule());
    }
}

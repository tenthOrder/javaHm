package ru.itis;

public class Main {

    public static void main(String[] args) {
        LinkedListImpl<Integer> list = new LinkedListImpl<>();
        list.add(3);
        list.add(0);
        list.add(-2);
        list.add(10);
        list.add(151);
        list.add(-45);

        MyStream<Integer> stream = new MyStream<>(list);
        stream.filter(value -> value > 0)
                .forEach(value -> System.out.println(value));
        System.out.println();
        stream.map(value -> value > 0 ? value : -value)
                .forEach(value -> System.out.println(value));
    }
}

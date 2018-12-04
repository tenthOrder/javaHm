package ru.itis;

public class Main {

    public static void printList(LinkedListImpl<?> list) {
        Iterator<?> iterator = list.getIterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedListImpl<Integer> list = new LinkedListImpl<>();
        list.add(1);
        list.add(2);
        printList(list);
        list.clear();
        printList(list);
        list.add(4);
        list.add(6);
        list.add(-1);
        list.add(0);
        printList(list);
        list.sort();
        printList(list);
        System.out.println(list.get(2));
        list.remove(1);
        list.remove(Integer.valueOf(6));
        printList(list);
    }
}

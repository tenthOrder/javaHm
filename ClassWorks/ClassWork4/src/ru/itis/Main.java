package ru.itis;

public class Main {

    public static void reverse(Node head) {
        Node prev = null;
        Node current = head;
        Node next = head.getNext();
        while (next != null) {
            current.setNext(prev);
            prev = current;
            current = next;
            next = next.getNext();
        }
        current.setNext(prev);
    }

    public static void placeEvenIndexedElementsFirst(Node head) {
        if (head.getNext() == null) {
            return;
        }
        Node current = head.getNext();
        Node oddHead = head; // can be removed, left for clarity
        Node evenHead = current; // can be removed, left for clarity
        Node currentOdd = oddHead;
        Node currentEven = evenHead;
        current = current.getNext();
        boolean isEven = false;
        while (current != null) {
            if (isEven) {
                currentEven.setNext(current);
                currentEven = currentEven.getNext();
            } else {
                currentOdd.setNext(current);
                currentOdd = currentOdd.getNext();
            }
            isEven = !isEven;
            current = current.getNext();
        }
        currentEven.setNext(oddHead);
        currentOdd.setNext(null);
    }

    public static void bubbleSort(Node head) {
        Node end = null;
        while (head.getNext() != end) {
            Node prev = null;
            Node current = head;
            Node next = current.getNext();
            while (current.getNext() != end) {
                if (current.getValue() > next.getValue()) {
                    // swap
                    current.setNext(next.getNext());
                    if (prev == null) {
                        head = next;
                    } else {
                        prev.setNext(next);
                    }
                    next.setNext(current);

                    prev = next;
                    next = current.getNext();
                } else {
                    prev = current;
                    current = next;
                    next = next.getNext();
                }
            }
            end = current;
        }
    }

    public static void selectionSort(Node head) {
        if (head.getNext() == null) {
            return;
        }
        Node endOfSortedPart = null;
        do {
            //find min in unsorted part of list
            Node start = endOfSortedPart == null ? head : endOfSortedPart.getNext();
            Node prev = start;
            Node current = start.getNext();
            Node min = start;
            Node minPrev = endOfSortedPart;
            while (current != null) {
                if (current.getValue() < min.getValue()) {
                    minPrev = prev;
                    min = current;
                }
                prev = current;
                current = current.getNext();
            }

            //swap min with start
            Node startNext = start.getNext();
            start.setNext(min.getNext());
            if (endOfSortedPart != null) {
                endOfSortedPart.setNext(min);
            }
            if (startNext == min) {
                min.setNext(start);
            } else {
                min.setNext(startNext);
                if (minPrev != null) {
                    minPrev.setNext(start);
                }
            }

            endOfSortedPart = min;
        } while (endOfSortedPart.getNext().getNext() != null);
    }

    public static void printList(Node head) {
        Node current = head;
        while (current.getNext() != null) {
            System.out.print(current.getValue() + "->");
            current = current.getNext();
        }
        System.out.println(current.getValue());
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);
        Node h = new Node(8);

        a.setNext(b);
        b.setNext(c);
        c.setNext(d);
        d.setNext(e);
        e.setNext(f);
        f.setNext(g);
        g.setNext(h);

        reverse(a);
        printList(h);
        bubbleSort(h);
        printList(a);
        placeEvenIndexedElementsFirst(a);
        printList(b);
        selectionSort(b);
        printList(a);



    }
}

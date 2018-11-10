package ru.itis;

public class Path extends CellLinkedListImpl {

    public void addBegin(Cell o) {
        if (head == null) {
            head = new Node(o, null, null);
            tail = head;
        } else {
            head.setPrev(new Node(o, head, null));
            head = head.getPrev();
        }
    }
}

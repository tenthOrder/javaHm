package ru.itis;

public class CellLinkedListImpl {
    protected Node head;
    protected Node tail;

    public void add(Cell o) {
        if (head == null) {
            head = new Node(o, null, null);
            tail = head;
        } else {
            tail.setNext(new Node(o, null, tail));
            tail = tail.getNext();
        }
    }

    //returns null if no element with index exists
    public Object get(int index) {
        Node node = getNode(index);
        if (node != null) {
            return node.getValue();
        } else {
            return null;
        }
    }

    //finds node with index, returns null if no element with index exists
    private Node getNode(int index) {
        int count = 0;
        Node current = head;
        while (current != null && count < index) {
            current = current.getNext();
            count++;
        }
        return current;
    }

    public void clear() {
        head = null;
        tail = null;
    }

    //removes the first occurrence of o, does nothing if no objects equal to o are found
    public void remove(Object o) {
        for (Node current = head; current != null; current = current.getNext()) {
            if (current.getValue().equals(o)) {
                removeNode(current);
                return;
            }
        }
    }

    protected void removeNode(Node node) {
        Node next = node.getNext();
        Node prev = node.getPrev();
        if (prev == null) {
            head = next;
        } else {
            prev.setNext(next);
        }
        if (next == null) {
            tail = prev;
        } else {
            next.setPrev(prev);
        }
    }

    public void remove(int index) {
        Node nodeToRemove = getNode(index);
        if (nodeToRemove != null) {
            removeNode(nodeToRemove);
        }
    }

    protected class Node {
        private Cell value;
        private Node next;
        private Node prev;

        public Node(Cell value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        public Cell getValue() {
            return value;
        }

        public Node getNext() {
            return next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }
    }

    private class LinkedListImplCellIterator implements CellIterator {

        Node current;

        public LinkedListImplCellIterator() {
            current = head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Cell next() {
            Cell result = current.getValue();
            current = current.getNext();
            return result;
        }
    }

    public CellIterator getIterator() {
        return new LinkedListImplCellIterator();
    }

}


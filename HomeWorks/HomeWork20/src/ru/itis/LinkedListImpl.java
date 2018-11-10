package ru.itis;

public class LinkedListImpl {
    private Node head;
    private Node tail;

    public void add(Comparable o) {
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

    private void removeNode(Node node) {
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

    public void sort() {
        class BucketElement implements Comparable<BucketElement> {
            LinkedListImpl list;
            int rang;

            BucketElement(Comparable o) {
                rang = 1;
                list = new LinkedListImpl();
                list.add(o);
            }

            @Override
            public int compareTo(BucketElement o) {
                return Integer.compare(this.rang, o.rang);
            }

        }
        LinkedListImpl buckets = new LinkedListImpl();
        Iterator iterator = this.getIterator();
        while (iterator.hasNext()) {
            buckets.add(new BucketElement(iterator.next()));
            /*
             *  Merge same rang buckets, until there is only one left or
             *  all of the buckets are of different rangs.
             *  Because we only add buckets to the end and merge them until
             *  there is either only one left or all of them are of different rangs,
             *  only the last two buckets can be equal in rang;
             */
            while (buckets.tail.getPrev() != null &&
                    buckets.tail.getPrev().getValue().compareTo(buckets.tail.getValue()) == 0) {
                BucketElement secondToLast = (BucketElement) buckets.tail.getPrev().getValue();
                BucketElement last = (BucketElement) buckets.tail.getValue();
                secondToLast.list = merge(secondToLast.list, last.list);
                buckets.removeNode(buckets.tail);
            }
        }
        /*
         *  Now merge all of the buckets, until only one is left.
         *  That bucket's list is the sorted initial list.
         */
        while (buckets.tail.getPrev() != null) {
            BucketElement secondToLast = (BucketElement) buckets.tail.getPrev().getValue();
            BucketElement last = (BucketElement) buckets.tail.getValue();
            secondToLast.list = merge(secondToLast.list, last.list);
            buckets.removeNode(buckets.tail);
        }

        BucketElement first = (BucketElement) buckets.head.getValue();
        this.head = first.list.head;
        this.tail = first.list.tail;
    }

    private static LinkedListImpl merge(LinkedListImpl firstList, LinkedListImpl secondList) {
        LinkedListImpl result = new LinkedListImpl();
        Node curFirst = firstList.head;
        Node curSecond = secondList.head;
        while (curFirst != null && curSecond != null) {
            if (curFirst.getValue().compareTo(curSecond.getValue()) < 0) {
                result.add(curFirst.getValue());
                curFirst = curFirst.getNext();
            } else {
                result.add(curSecond.getValue());
                curSecond = curSecond.getNext();
            }
        }
        for (; curFirst != null; curFirst = curFirst.getNext()) {
            result.add(curFirst.getValue());
        }
        for (; curSecond != null; curSecond = curSecond.getNext()) {
            result.add(curSecond.getValue());
        }
        return result;
    }

    private class Node {
        private Comparable value;
        private Node next;
        private Node prev;

        private Node(Comparable value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        public Comparable getValue() {
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

    private class LinkedListImplIterator implements Iterator {

        Node current;

        public LinkedListImplIterator() {
            current = head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Comparable next() {
            Comparable result = current.getValue();
            current = current.getNext();
            return result;
        }
    }

    public Iterator getIterator() {
        return new LinkedListImplIterator();
    }

}


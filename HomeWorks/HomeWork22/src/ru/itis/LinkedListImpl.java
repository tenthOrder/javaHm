package ru.itis;

public class LinkedListImpl<T extends Comparable<T>> {
    private Node<T> head;
    private Node<T> tail;

    public void add(T o) {
        if (head == null) {
            head = new Node<>(o, null, null);
            tail = head;
        } else {
            tail.setNext(new Node<>(o, null, tail));
            tail = tail.getNext();
        }
    }

    //returns null if no element with index exists
    public T get(int index) {
        Node<T> node = getNode(index);
        if (node != null) {
            return node.getValue();
        } else {
            return null;
        }
    }

    //finds node with index, returns null if no element with index exists
    private Node<T> getNode(int index) {
        int count = 0;
        Node<T> current = head;
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

    //removes the first occurrence of o, does nothing if no elements equal to o are found
    public void remove(T o) {
        for (Node<T> current = head; current != null; current = current.getNext()) {
            if (current.getValue().equals(o)) {
                removeNode(current);
                return;
            }
        }
    }

    private void removeNode(Node<T> node) {
        Node<T> next = node.getNext();
        Node<T> prev = node.getPrev();
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
        Node<T> nodeToRemove = getNode(index);
        if (nodeToRemove != null) {
            removeNode(nodeToRemove);
        }
    }

    public void sort() {
        class BucketElement implements Comparable<BucketElement> {
            LinkedListImpl<T> list;
            int rang;

            BucketElement(T o) {
                rang = 1;
                list = new LinkedListImpl<>();
                list.add(o);
            }

            @Override
            public int compareTo(BucketElement o) {
                return Integer.compare(this.rang, o.rang);
            }

        }
        LinkedListImpl<BucketElement> buckets = new LinkedListImpl<>();
        Iterator<T> iterator = this.getIterator();
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
                BucketElement secondToLast = buckets.tail.getPrev().getValue();
                BucketElement last = buckets.tail.getValue();
                secondToLast.list = merge(secondToLast.list, last.list);
                buckets.removeNode(buckets.tail);
            }
        }
        /*
         *  Now merge all of the buckets, until only one is left.
         *  That bucket's list is the sorted initial list.
         */
        while (buckets.tail.getPrev() != null) {
            BucketElement secondToLast = buckets.tail.getPrev().getValue();
            BucketElement last = buckets.tail.getValue();
            secondToLast.list = merge(secondToLast.list, last.list);
            buckets.removeNode(buckets.tail);
        }

        BucketElement first = buckets.head.getValue();
        this.head = first.list.head;
        this.tail = first.list.tail;
    }

    private static <T extends Comparable<T>> LinkedListImpl<T> merge(LinkedListImpl<T> firstList,
                                                                     LinkedListImpl<T> secondList) {
        LinkedListImpl<T> result = new LinkedListImpl<>();
        Node<T> curFirst = firstList.head;
        Node<T> curSecond = secondList.head;
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

    private static class Node<E> {
        private E value;
        private Node<E> next;
        private Node<E> prev;

        private Node(E value, Node<E> next, Node<E> prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        public E getValue() {
            return value;
        }

        public Node<E> getNext() {
            return next;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }
    }

    private class LinkedListImplIterator implements Iterator<T> {

        Node<T> current;

        public LinkedListImplIterator() {
            current = head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T result = current.getValue();
            current = current.getNext();
            return result;
        }
    }

    public Iterator<T> getIterator() {
        return new LinkedListImplIterator();
    }

}


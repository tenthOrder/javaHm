package ru.itis;

public class CellQueueLinkedListImpl extends Path implements CellQueue {
    @Override
    public void enqueue(Cell cell) {
        addBegin(cell);
    }

    @Override
    public Cell dequeue() {
        Cell result = tail.getValue();
        removeNode(tail);
        return result;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }
}

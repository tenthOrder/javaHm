package ru.itis;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class MyStream<T extends Comparable<T>> {
    private LinkedListImpl<T> list;

    private MyStream() {
        this.list = new LinkedListImpl<>();
    }

    public MyStream(LinkedListImpl<T> list) {
        this.list = list;
    }

    public <R extends Comparable<R>> MyStream<R> map(Function<T, R> func) {
        MyStream<R> res = new MyStream<>();
        for (T el : this.list) {
            res.list.add(func.apply(el));
        }
        return res;
    }

    public MyStream<T> filter(Predicate<T> filter) {
        MyStream<T> res = new MyStream<>();
        for (T el : this.list) {
            if (filter.test(el)) {
                res.list.add(el);
            }
        }
        return res;
    }

    public void forEach(Consumer<T> consumer) {
        for (T el : this.list) {
            consumer.accept(el);
        }
    }
}

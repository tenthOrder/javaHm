package ru.itis;

public class Map<K, V> {

    private static class Entry<K, V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Entry[] entries;
    private int collisionCount;

    public Map() {
        entries = new Entry[100];
        collisionCount = 0;
    }

    private int getIndex(K key) {
        int index = key.hashCode() % entries.length;
        return index > 0 ? index : -index;
    }

    public void put(K key, V value) {
        int index = getIndex(key);
        if (entries[index] != null) {
            if (entries[index].key.equals(key)) {
                entries[index].value = value;
                return;
            } else {
                collisionCount++;
            }
        }
        entries[index] = new Entry<>(key, value);
    }

    public int getCollisionCount() {
        return collisionCount;
    }
}

package ru.itis;

public class Map<K, V> {

    private static class Entry<K, V> {
        K key;
        V value;
        int hash;
        Entry next;

        public Entry(K key, V value, int hash, Entry next) {
            this.key = key;
            this.value = value;
            this.hash = hash;
            this.next = next;
        }
    }

    private Entry<K, V>[] entries;
    private int collisionCount;

    public Map() {
        entries = new Entry[16];
        collisionCount = 0;
    }

    private int calcIndex(K key) {
        return key.hashCode() & (entries.length - 1);
    }

    public void put(K key, V value) {
        int hash = key.hashCode();
        Entry entry = getEntry(key, hash);
        if (entry != null) {
            entry.value = value;
        } else {
            int index = calcIndex(key);
            if (entries[index] == null) {
                entries[index] = new Entry<>(key, value, hash, null);
            } else {
                collisionCount++;
                entries[index] = new Entry<>(key, value, hash, entries[index]);
            }
        }
    }

    // returns an entry, corresponding to key. If such an entry is not found returns null
    private Entry getEntry(K key, int hash) {
        Entry curEntry = entries[calcIndex(key)];
        while (curEntry != null && curEntry.hash != hashCode() && !curEntry.key.equals(key)) {
            curEntry = curEntry.next;
        }
        return curEntry;
    }

    // returns null if no entry with key exists
    public V get(K key) {
        int hash = key.hashCode();
        Entry entry = getEntry(key, hash);
        if (entry != null) {
            return (V) entry.value;
        }
        return null;
    }

    public int getCollisionCount() {
        return collisionCount;
    }
}

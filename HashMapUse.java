class HashMap<K, V> {
    private static final int INITIAL_CAPACITY = 1 << 4;
    private final Entry<K, V>[] buckets;
    private int size = 0;

    public HashMap() {
        this(INITIAL_CAPACITY);
    }

    public HashMap(int capacity) {
        buckets = new Entry[capacity];
    }

    public void put(K key, V value) {
        int index = Math.abs(key.hashCode()) % buckets.length;
        Entry<K, V> existing = buckets[index];
        if (existing == null) {
            Entry<K, V> entry = new Entry<>(key, value);
            buckets[index] = entry;
            size++;
        } else {
            while (existing.next != null) {
                if (existing.Key.equals(key)) {
                    existing.value = value;
                    return;
                }
                existing = existing.next;
            }

            if (existing.Key.equals(key)) {
                existing.value = value;
            } else {
                Entry<K, V> entry = new Entry<>(key, value);
                existing.next = entry;
                size++;
            }

        }
    }

    public V get(K key) {
        Entry<K, V> head = buckets[Math.abs(key.hashCode()) % buckets.length];
        while (head != null) {
            if (head.Key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }

        return null;
    }

}

class Entry<K, V> {
    final K Key;
    V value;
    Entry<K, V> next;

    public Entry(K key, V val) {
        this.Key = key;
        this.value = val;
        this.next = null;
    }
}

public class HashMapUse {
    public static void main(String[] args) {

        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("ayushi", 10);
        hm.put("happy", 40);
        hm.put("ayushi", 50);
        System.out.println("happy" + hm.get("happy"));
        System.out.println("ayushi" + hm.get("ayushi"));
    }
}

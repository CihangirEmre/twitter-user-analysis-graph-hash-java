package prolab;



public class myHashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private myDoublyLinkedList<Entry<K, V>>[] table;
    private int size;
    public myHashMap() {
        this.table = new myDoublyLinkedList[DEFAULT_CAPACITY];
        this.size = 0;
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            table[i] = new myDoublyLinkedList<>();
        }
    }

    public void put(K key, V value) {
        int index = hash(key);
        myDoublyLinkedList<Entry<K, V>> bucket = table[index];

        for (int i = 0; i < bucket.size(); i++) {
            Entry<K, V> entry = bucket.getNode(i).data;
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }

        bucket.addtoEnd(new Entry<>(key, value));
        size++;

        // Load factor kontrolü ve gerektiğinde yeniden hash yapma
        if ((double) size / table.length > 0.75) {
            resize();
        }
    }

    public V get(K key) {
        int index = hash(key);
        myDoublyLinkedList<Entry<K, V>> bucket = table[index];

        for (int i = 0; i < bucket.size(); i++) {
            Entry<K, V> entry = bucket.getNode(i).data;
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }

        return null;
    }

    public void remove(K key) {
        int index = hash(key);
        myDoublyLinkedList<Entry<K, V>> bucket = table[index];

        for (int i = 0; i < bucket.size(); i++) {
            Entry<K, V> entry = bucket.getNode(i).data;
            if (entry.getKey().equals(key)) {
                bucket.removewithValue(entry);
                size--;
                return;
            }
        }
    }

    public int size() {
        return size;
    }

    public int hash(K key) {
        return Math.abs(key.hashCode() % table.length);
    }

    private void resize() {
        int newCapacity = table.length * 2;
        myDoublyLinkedList<Entry<K, V>>[] newTable = new myDoublyLinkedList[newCapacity];

        for (int i = 0; i < newCapacity; i++) {
            newTable[i] = new myDoublyLinkedList<>();
        }

        // Mevcut elemanları yeni table'a taşıma
        for (int i = 0; i < table.length; i++) {
            myDoublyLinkedList<Entry<K, V>> bucket = table[i];
            for (int j = 0; j < bucket.size(); j++) {
                Entry<K, V> entry = bucket.getNode(j).data;
                int index = Math.abs(entry.getKey().hashCode() % newCapacity);
                newTable[index].addtoEnd(entry);
            }
        }

        table = newTable;
    }

    public static class Entry<K, V> {
        private final K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}

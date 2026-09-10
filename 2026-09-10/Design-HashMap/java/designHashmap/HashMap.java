package designHashmap;

class MyHashMap {
    static class Node {
        public int key;
        public int value;
        public Node next;

        Node(int key, int value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
    private final Node[] map;
    private static final int DEFAULT_CAPACITY = 10_007;

    public MyHashMap() {
        this.map = new Node[DEFAULT_CAPACITY];
    }
    
    public void put(int key, int value) {
        int indexKey = hash(key);
        Node current = map[indexKey];
        
        while (current != null) {
            if (current.key == key) {
                current.value = value;
                return;
            }
            current = current.next;
        }

        map[indexKey] = new Node(key, value, map[indexKey]);
    }
    
    public int get(int key) {
        int indexKey = hash(key);
        Node current = map[indexKey];

        while (current != null) {
            if (current.key == key) {
                return current.value;
            }
            current = current.next;
        }

        return -1;
    }
    
    public void remove(int key) {
        int indexKey = hash(key);
        Node current = map[indexKey];
        Node prev = null;

        while (current != null) {
            if (current.key == key) {
                if (prev == null) {
                    map[indexKey] = current.next; 
                } else {
                    prev.next = current.next;
                }
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    private int hash(int key) {
        return key % map.length;
    }
}
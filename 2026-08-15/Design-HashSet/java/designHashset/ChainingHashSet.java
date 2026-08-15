package designHashset;

public class ChainingHashSet implements HashSetI {

    private static final int BUCKET_SIZE = 10_007;
    private final Node[] bucket;

    private static class Node {
        int key;
        Node next;

        Node(int key, Node next) {
            this.key = key;
            this.next = next;
        }
    }

    public ChainingHashSet() {
        bucket = new Node[BUCKET_SIZE];
    }

    public void add(int key) {
        int index = hash(key);
        Node current = bucket[index];

        // Check if key already exists
        while (current != null) {
            if (current.key == key) {
                return;
            }
            current = current.next;
        }

        // Insert new key at the head of the list O(1)
        bucket[index] = new Node(key, bucket[index]);
    }

    public void remove(int key) {
        int index = hash(key);
        Node current = bucket[index];
        Node prev = null;

        while (current != null) {
            if (current.key == key) {
                if (prev == null) {
                    bucket[index] = current.next; // Remove head node
                } else {
                    prev.next = current.next;     // Bypass current node
                }
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public boolean contains(int key) {
        int index = hash(key);
        Node current = bucket[index];

        while (current != null) {
            if (current.key == key) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    private int hash(int key) {
        return Math.floorMod(key, BUCKET_SIZE);
    }
}

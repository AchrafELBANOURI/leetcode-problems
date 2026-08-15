package designHashset;

import java.util.Arrays;
import java.lang.Math;

public class LinearProbingHashSet implements HashSetI {
    private final int[] bucket;
    private static final int BUCKET_SIZE = 10_007;
    private static final int EMPTY = Integer.MIN_VALUE;
    private static final int DELETED = Integer.MIN_VALUE + 1;

    public LinearProbingHashSet() {
        bucket = new int[BUCKET_SIZE];
        Arrays.fill(bucket, EMPTY);
    }

    public void add(int key) {
        int h1 = hash1(key);
        int firstDeletedIndex = -1;

        for (int i = 0; i < BUCKET_SIZE; i++) {
            int indexKey = (h1 + i) % BUCKET_SIZE;

            if (bucket[indexKey] == key) {
                return; // Key already present
            }

            if (bucket[indexKey] == DELETED && firstDeletedIndex == -1) {
                firstDeletedIndex = indexKey; // Mark first available deleted slot
            }

            if (bucket[indexKey] == EMPTY) {
                // Insert at first DELETED slot if available, otherwise at current EMPTY slot
                int targetIndex = (firstDeletedIndex != -1) ? firstDeletedIndex : indexKey;
                bucket[targetIndex] = key;
                return;
            }
        }

        // Table is full and no slot found
        if (firstDeletedIndex != -1) {
            bucket[firstDeletedIndex] = key;
        }
    }
    
    public void remove(int key) {
        int h1 = hash1(key);

        for (int i = 0; i < BUCKET_SIZE; i++) {
            int indexKey = (h1 + i) % BUCKET_SIZE;

            if (bucket[indexKey] == key) {
                bucket[indexKey] = DELETED;
                return;
            }

            if (bucket[indexKey] == EMPTY) {
                return; // Key does not exist
            }
        }
    }
    
    public boolean contains(int key) {
        int h1 = hash1(key);

        for (int i = 0; i < BUCKET_SIZE; i++) {
            int indexKey = (h1 + i) % BUCKET_SIZE;

            if (bucket[indexKey] == key) {
                return true;
            }

            if (bucket[indexKey] == EMPTY) {
                return false; // Key cannot exist past an empty slot
            }
        }

        return false;
    }

    private int hash1(int key) {
        return Math.floorMod(key, BUCKET_SIZE);
    }
}

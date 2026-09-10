# Daily LeetCode Problem - September 10, 2026

## Problem

[706. Design HashMap](https://leetcode.com/problems/design-hashmap/)

## Problem Statement

Design a HashMap without using any built-in hash table libraries.

Implement the `MyHashMap` class:

- `MyHashMap()` initializes the object with an empty map.
- `void put(int key, int value)` inserts a `(key, value)` pair into the HashMap. If the `key` already exists in the map, update the corresponding `value`.
- `int get(int key)` returns the `value` to which the specified `key` is mapped, or `-1` if this map contains no mapping for the `key`.
- `void remove(int key)` removes the key and its corresponding value if the map contains the mapping for the `key`.

## Solutions

### Java Solution

Located in [`java/designHashmap/Solution.java`](java/designHashmap/Solution.java)

#### Approach

Used separate chaining with a singly linked list to resolve hash collisions.

1. **Bucket Array:** Maintained a fixed-size array of `Node` pointers with a prime capacity (`10,007`) to optimize key distribution and reduce collision frequency.
2. **Modulo Hashing:** Computed array indices using standard modulo arithmetic (`key % DEFAULT_CAPACITY`).
3. **LinkedList Traversal:**
   - `put`: Iterates through the chain at the bucket index. If the key exists, updates its value in-place; otherwise, prepends a new `Node` at the head.
   - `get`: Traverses the linked list at the bucket index until the target key is found or returns `-1`.
   - `remove`: Uses a two-pointer approach (`current` and `prev`) to unlink and remove the target node.

#### Complexity Analysis

- **Time Complexity:**
  - Average Case: $O(1)$ for `put`, `get`, and `remove`.
  - Worst Case: $O(N)$ when all keys hash to the same bucket, causing linear search across the chain.
- **Space Complexity:** $O(K + N)$ where $K = 10,007$ (bucket array capacity) and $N$ is the total number of unique keys inserted.

---

### Python Solution

Located in [`python/solution.ipynb`](python/solution.ipynb)

#### Approach

Follows the identical separate chaining architecture implemented in Java to maintain cross-language parity.

1. **Custom Node & Map Initialization:** Defines a helper `Node` class with `key`, `value`, and `next` attributes, initializing a list of size `10_007` filled with `None`.
2. **Hash Function:** Implements a private `_hash(key)` helper method using `key % len(self.map)`.
3. **Chain Operations:**
   - `put`: Traverses the chain to update an existing key or prepends `Node(key, value, self.map[index])`.
   - `get`: Scans the bucket's linked list and returns the matching value or `-1`.
   - `remove`: Adjusts head pointers or updates `prev.next` to unlink target nodes.
4. **Operation Harness:** Includes a `Solution.operations` executor and `assert_test` assertion runner to validate string-driven operation arrays.

#### Complexity Analysis

- **Time Complexity:**
  - Average Case: $O(1)$ for `put`, `get`, and `remove`.
  - Worst Case: $O(N)$ if all elements collapse into a single chain.
- **Space Complexity:** $O(K + N)$ where $K$ is the fixed initial bucket length and $N$ is the number of active key-value pairs.

---

## Notes/Explanation

- **Prime Capacity Choice:** Setting `DEFAULT_CAPACITY = 10_007` (a prime number) minimizes clustered collisions when keys follow regular patterns or steps.
- **Head Insertion Optimization:** When a new key is added to a bucket, inserting it at the head of the list takes $O(1)$ time after verifying key non-existence during the initial traversal pass.

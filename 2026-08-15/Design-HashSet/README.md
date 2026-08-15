# Daily LeetCode Problem - August 15, 2026

## Problem

[705. Design HashSet](https://leetcode.com/problems/design-hashset/)

## Problem Statement

Design a HashSet without using any built-in hash table libraries.

Implement `MyHashSet` class:

- `void add(key)` Inserts the value `key` into the HashSet.
- `bool contains(key)` Returns whether the value `key` exists in the HashSet or not.
- `void remove(key)` Removes the value `key` in the HashSet. If `key` does not exist in the HashSet, do nothing.

### Example 1

```text
Input
["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
[[], [1], [2], [1], [3], [2], [2], [2], [2]]

Output
[null, null, null, true, false, null, true, null, false]

Explanation
MyHashSet myHashSet = new MyHashSet();
myHashSet.add(1);      // set = [1]
myHashSet.add(2);      // set = [1, 2]
myHashSet.contains(1); // return True
myHashSet.contains(3); // return False (not found)
myHashSet.add(2);      // set = [1, 2]
myHashSet.contains(2); // return True
myHashSet.remove(2);   // set = [1]
myHashSet.contains(2); // return False (already removed)
```

### Constraints

- `0 <= key <= 10^6`
- At most `10^4` calls will be made to `add`, `remove`, and `contains`.

---

## Solutions

### Java Solution

Located in [`java/designHashset/Solution.java`](java/designHashset/Solution.java)

#### Approach

We implemented a Strategy pattern supporting four primary collision resolution strategies for open addressing and separate chaining:

1. **Chaining (`ChainingHashSet`):** Uses an array of singly-linked lists (`Node[]`). Insertions occur at the head of the list in $\mathcal{O}(1)$ time after checking for uniqueness.
2. **Linear Probing (`LinearProbingHashSet`):** Resolves collisions using linear stepping $h(k, i) = (h_1(k) + i) \bmod M$.
3. **Quadratic Probing (`QuadraticProbingHashSet`):** Resolves collisions using quadratic stepping $h(k, i) = (h_1(k) + i^2) \bmod M$.
4. **Double Hashing (`DoubleHashingHashSet`):** Employs a secondary hash function $h_2(k) = R - (k \bmod R)$ to compute probe strides $h(k, i) = (h_1(k) + i \cdot h_2(k)) \bmod M$.

To handle deletions in open addressing strategies without breaking probe sequences, slots utilize tombstone markers (`DELETED = Integer.MIN_VALUE + 1`). During `add` operations, new keys preferentially reuse the first encountered `DELETED` slot.

```java
package designHashset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    enum Strategy {
        CHAINING,
        LINEAR_PROBING,
        QUADRATIC_PROBING,
        DOUBLE_HASHING,
    }

    public static HashSetI createHashSet(Strategy strategy) {
        switch (strategy) {
            case LINEAR_PROBING:
                return new LinearProbingHashSet();
            case QUADRATIC_PROBING:
                return new QuadraticProbingHashSet();
            case DOUBLE_HASHING:
                return new DoubleHashingHashSet();
            default:
                return new ChainingHashSet();
        }
    }

    public static List<Boolean> operations(String[] ops, int[] values, Strategy strategy) {
        if (!ops[0].equals("HashSet")) {
            throw new IllegalArgumentException("HashSet Operation Must be the first One");
        }

        List<Boolean> output = new ArrayList<>(ops.length);
        HashSetI hs = createHashSet(strategy);
        output.add(null);

        for (int i = 1; i < ops.length; i++) {
            if (ops[i].equals("add")) {
                hs.add(values[i]);
                output.add(null);
            } else if (ops[i].equals("remove")) {
                hs.remove(values[i]);
                output.add(null);
            } else if (ops[i].equals("contains")) {
                output.add(hs.contains(values[i]));
            } else {
                throw new IllegalArgumentException("Unexpected Operation Name -- Allowed Operations : HashSet - add - remove - contains , index : " + i);
            }
        }

        return output;
    }
}
```

#### Complexity Analysis

- **Time Complexity:**
  - **Average Case:** $\mathcal{O}(1)$ for `add`, `remove`, and `contains` across all strategies under low load factors.
  - **Worst Case:** $\mathcal{O}(N)$ when severe hashing collisions degrade probe sequences or list chains into linear scans.
- **Space Complexity:** $\mathcal{O}(M + N)$ where $M = 10007$ is the fixed prime bucket size and $N$ is the number of inserted elements.

---

### Python Solution

Located in [`python/solution.ipynb`](python/solution.ipynb)

#### Approach

The Python implementation utilizes **Separate Chaining** built over dynamic native lists (`List[List[int]]`).

The hash table maintains $M = 10007$ fixed buckets (a prime number to minimize clustering). Key lookups, additions, and deletions map keys to their corresponding bucket index using modulo arithmetic (`key % BUCKET_SIZE`) and execute operations directly on the inner list bucket.

```python
from typing import List, Optional

class Solution:
    class MyHashSet:
        def __init__(self):
            self.BUCKET_SIZE = 10007
            self.bucket = [[] for _ in range(self.BUCKET_SIZE)]

        def _hash(self, key: int) -> int:
            return key % self.BUCKET_SIZE

        def add(self, key: int) -> None:
            listNode = self.bucket[self._hash(key)]
            if key not in listNode:
                listNode.append(key)

        def remove(self, key: int) -> None:
            listNode = self.bucket[self._hash(key)]
            if key in listNode:
                listNode.remove(key)

        def contains(self, key: int) -> bool:
            listNode = self.bucket[self._hash(key)]
            return key in listNode

    @staticmethod
    def operations(ops: List[str], values: List[int]) -> List[Optional[bool]]:
        if ops[0] != "MyHashSet" and ops[0] != "HashSet":
            raise ValueError("HashSet Operation Must be the first One")

        output: List[Optional[bool]] = []
        hs = Solution.MyHashSet()
        output.append(None)

        for i in range(1, len(ops)):
            op = ops[i]
            val = values[i]

            if op == "add":
                hs.add(val)
                output.append(None)
            elif op == "remove":
                hs.remove(val)
                output.append(None)
            elif op == "contains":
                output.append(hs.contains(val))
            else:
                raise ValueError(
                    f"Unexpected Operation Name -- Allowed Operations : HashSet - add - remove - contains , index : {i}"
                )

        return output
```

#### Complexity Analysis

- **Time Complexity:**
  - **Average Case:** $\mathcal{O}(1)$ for `add`, `remove`, and `contains`. With $M = 10007$ buckets and $N \le 10000$ operations, average chain length is $\le 1$.
  - **Worst Case:** $\mathcal{O}(K)$ where $K$ is the length of the chain at `bucket[hash(key)]`.
- **Space Complexity:** $\mathcal{O}(M + N)$ to store the array of buckets and active keys.

---

## Notes/Explanation

- **Prime Bucket Sizing:** Using $M = 10007$ (a prime number near $10^4$) produces a uniform hash distribution across integer inputs, preventing primary clustering.
- **Handling Negative Numbers in Java:** Java's `%` operator yields negative outputs for negative dividends (e.g., `-5 % 10007 = -5`). Using `Math.floorMod(key, BUCKET_SIZE)` ensures non-negative bucket indices. Python's `%` handles negative numbers natively.
- **Tombstone Strategy:** In open addressing (`Linear`, `Quadratic`, `Double Hashing`), replacing deleted entries with `DELETED` instead of `EMPTY` prevents search sequences in `contains()` from terminating prematurely when searching for keys inserted after a collision.

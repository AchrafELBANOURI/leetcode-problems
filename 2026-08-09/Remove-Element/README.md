# Daily LeetCode Problem - August 09, 2026

## Problem

[LeetCode 27. Remove Element](https://leetcode.com/problems/remove-element/)

## Problem Statement

Given an integer array `nums` and an integer `val`, remove all occurrences of `val` in `nums` **in-place**. The order of the elements may be changed. Then return _the number of elements in_ `nums` _which are not equal to_ `val`.

Consider the number of elements in `nums` which are not equal to `val` be `k`. To get accepted, you need to do the following things:

1. Change the array `nums` such that the first `k` elements of `nums` contain the elements which are not equal to `val`. The remaining elements of `nums` are not important as well as the size of `nums`.
2. Return `k`.

## Solutions

### Java Solution

Located in [`java/Solution.java`](java/Solution.java)

#### Approach

We use a **Two-Pointer (Reader / Writer)** approach to overwrite occurrences of `val` in-place:

1. Initialize a writer pointer `k = 0` to track the placement index for valid elements.
2. Iterate through the array using a reader index `i` from `0` to `nums.length - 1`.
3. Whenever `nums[i]` is not equal to `val`, place `nums[i]` at index `k` (`nums[k] = nums[i]`) and increment `k`.
4. Return `k`, which represents the count of elements remaining after removal.

```java
public class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k++] = nums[i];
            }
        }

        return k;
    }
}
```

#### Complexity Analysis

- **Time Complexity:** $\mathcal{O}(N)$ — We traverse the array of length $N$ exactly once.
- **Space Complexity:** $\mathcal{O}(1)$ — The operation is performed in-place using constant auxiliary memory.

### Python Solution

Located in [`python/solution.ipynb`](python/solution.ipynb)

#### Approach

The Python solution follows the same two-pointer in-place mutation pattern:

1. Maintain a pointer `k` initialized to `0`.
2. Loop over every index `i` in `nums`.
3. If `nums[i] != val`, copy `nums[i]` to `nums[k]` and increment `k` by `1`.
4. Return `k` as the final length of the filtered sub-array.

```python
from typing import List

class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        k = 0

        for i in range(len(nums)):
            if nums[i] != val:
                nums[k] = nums[i]
                k += 1
        return k
```

#### Complexity Analysis

- **Time Complexity:** $\mathcal{O}(N)$ — A single pass through the list of length $N$.
- **Space Complexity:** $\mathcal{O}(1)$ — In-place array modification requires no additional storage structures.

## Notes/Explanation

### Key Insights

- **Two-Pointer In-Place Filtering:** This technique is a standard pattern for array filtering without allocating extra memory. The reader pointer (`i`) scans every element, while the writer pointer (`k`) maintains the boundary of valid elements.
- **Alternative Approach (When Target Values are Rare):** If elements equal to `val` appear infrequently, swapping the target element with the last element (`nums[i] = nums[n - 1]`) and decreasing array length `n` avoids unnecessary copy operations for remaining elements.

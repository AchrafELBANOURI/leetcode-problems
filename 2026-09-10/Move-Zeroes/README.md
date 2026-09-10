# Daily LeetCode Problem - September 10, 2026

## Problem

[283. Move Zeroes](https://leetcode.com/problems/move-zeroes/)

## Problem Statement

Given an integer array `nums`, move all `0`'s to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

### Examples

**Example 1:**

- **Input:** `nums = [0,1,0,3,12]`
- **Output:** `[1,3,12,0,0]`

**Example 2:**

- **Input:** `nums = [0]`
- **Output:** `[0]`

### Constraints

- `1 <= nums.length <= 10^4`
- `-2^31 <= nums[i] <= 2^31 - 1`

---

## Key Logic & Mathematical Insights

### 1. Two-Pointer Partitioning

The algorithm uses a fast pointer (`i`) to scan the array and a slow write pointer (`j`) to track the target position for the next non-zero element.

Whenever `nums[i] != 0` (or `val != 0`), swap `nums[i]` and `nums[j]` in-place, then increment `j`:

$$\text{Swap } nums[i] \longleftrightarrow nums[j], \quad j \leftarrow j + 1$$

This ensures that the subarray $nums[0 \dots j-1]$ always contains all non-zero elements in their original relative order, while zeros are pushed to the right.

---

## Core Code Implementations

### Java Solution

```java
package moveZeroes;

import utilities.TestUtils;

class Solution {
    public void moveZeroes(int[] nums) {
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        int[] expected = {1, 3, 12, 0, 0};

        TestUtils.assertTest(expected, nums, "Test Case -- Move Zeroes");
    }
}
```

### Python Solution

**Standard Two-Pointer In-Place:**

```python
def moveZeroes(nums: list[int]) -> None:
    j = 0
    for i, val in enumerate(nums):
        if val:
            nums[i], nums[j] = nums[j], val
            j += 1
```

---

## Algorithmic Steps

1. **Initialize Pointer:** Set write index `j = 0`.
2. **Scan & Swap:** Iterate through `nums` with pointer `i`.
   - If `nums[i]` is non-zero, swap `nums[i]` and `nums[j]`.
   - Increment `j`.
3. **In-Place Result:** All non-zero elements are gathered in the prefix `nums[0...j-1]`, leaving remaining positions `nums[j...n-1]` filled with `0`.

---

## Complexity Analysis

- **Time Complexity:** $O(N)$ linear time in a single pass.
- **Space Complexity:** $O(1)$ auxiliary space (modifies `nums` strictly in-place).

# Daily LeetCode Problem - October 02, 2026

## Problem

[Two Sum II - Input Array Is Sorted](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/)

## Problem Statement

Given a 1-indexed array of integers `numbers` that is already sorted in non-decreasing order, find two numbers such that they add up to a specific `target` number.

Return the indices of the two numbers as an array of length 2, with the indices being 1-indexed and in ascending order.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

### Example 1

```text
Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore index1 + index2 = 1 + 2 = 3.
```

### Example 2

```text
Input: numbers = [2,3,4], target = 6
Output: [1,3]
Explanation: The sum of 2 and 4 is 6. Therefore index1 + index3 = 1 + 3 = 4.
```

### Example 3

```text
Input: numbers = [-1,0], target = -1
Output: [1,2]
Explanation: The sum of -1 and 0 is -1. Therefore index1 + index2 = 1 + 2 = 3.
```

## Solutions

### Java Solution

Located in [`java/twoSumIIInputArrayIsSorted/Solution.java`](java/twoSumIIInputArrayIsSorted/Solution.java)

#### Approach

Because the array is sorted, we can use the **two-pointer technique**.

- Initialize `left` at the beginning of the array and `right` at the end.
- Compute `sum = numbers[left] + numbers[right]`.
- If the sum equals the target, return the 1-indexed positions.
- If the sum is too large, move the `right` pointer left.
- If the sum is too small, move the `left` pointer right.

This works because the array is sorted, so shrinking the range eliminates impossible combinations.

```java
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int left = 0, right = n - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }

        return new int[2];
    }
}
```

#### Complexity Analysis

- **Time Complexity:** $O(N)$ — each pointer moves at most $N$ times.
- **Space Complexity:** $O(1)$ — only a constant amount of extra space is used.

---

### Python Solution

Located in [`python/solution.py`](python/solution.py)

#### Approach

The same two-pointer method is used in Python with the array indices as `left` and `right`.

```python
class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        n = len(numbers)
        left, right = 0, n - 1

        while left < right:
            total = numbers[left] + numbers[right]

            if total == target:
                return [left + 1, right + 1]
            elif total > target:
                right -= 1
            else:
                left += 1

        return [0, 0]
```

#### Complexity Analysis

- **Time Complexity:** $O(N)$ — the pointers traverse the array once.
- **Space Complexity:** $O(1)$ — no additional data structures are required.

## Notes/Explanation

- The array is guaranteed to be sorted, which is the key reason a two-pointer solution is efficient.
- The problem expects 1-indexed positions, so we return `left + 1` and `right + 1`.
- Since there is exactly one valid answer, the loop ends as soon as the pair is found.

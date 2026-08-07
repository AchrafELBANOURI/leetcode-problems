# Daily LeetCode Problem - Concatenation of Array

## Problem

[LeetCode 1929. Concatenation of Array](https://leetcode.com/problems/concatenation-of-array/)

## Problem Statement

Given an integer array `nums` of length `n`, you want to create an array `ans` of length `2n` where `ans[i] == nums[i]` and `ans[i + n] == nums[i]` for `0 <= i < n` (**0-indexed**).

Specifically, `ans` is the concatenation of two `nums` arrays.

Return _the array_ `ans`.

## Solutions

### Java Solution

Located in [`java/Solution.java`](java/Solution.java)

#### Approach

We construct an array of length `2 * n` and copy the elements of `nums` twice:

1. Determine the length `n` of the input array `nums`.
2. Allocate a new result array `ans` of size `2 * n`.
3. Use `System.arraycopy()` to copy `nums` into the first half (`0` to `n-1`) of `ans`.
4. Use `System.arraycopy()` a second time to copy `nums` into the second half (`n` to `2n-1`) of `ans`.
5. Return the concatenated array.

#### Complexity Analysis

- **Time Complexity:** $\mathcal{O}(N)$ — `System.arraycopy()` operates at memory-level speeds to copy $N$ elements twice, performing in linear time.
- **Space Complexity:** $\mathcal{O}(N)$ — Required output array of size $2N$ (or $\mathcal{O}(1)$ auxiliary space excluding the returned result).

### Python Solution

Located in [`python/solution.ipynb`](python/solution.ipynb)

#### Approach

Python handles sequence concatenation natively using the `+` operator or `* 2` multiplier:

1. Return `nums + nums` (or `nums * 2`) to produce a new list containing the elements of `nums` repeated twice sequentially.

```python
class Solution:
    def getConcatenation(self, nums: List[int]) -> List[int]:
        return nums + nums
```

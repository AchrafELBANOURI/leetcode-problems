# Daily LeetCode Problem - June 13, 2025

## Problem

[11. Container With Most Water](https://leetcode.com/problems/container-with-most-water/) - Medium

## Problem Statement

You are given an integer array `height` of length `n`. There are `n` vertical lines drawn such that the two endpoints of the `ith` line are `(i, 0)` and `(i, height[i])`.

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

**Notice** that you may not slant the container.

### Examples

**Example 1:**

```
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
```

**Example 2:**

```
Input: height = [1,1]
Output: 1
```

### Constraints

- `n == height.length`
- `2 <= n <= 10^5`
- `0 <= height[i] <= 10^4`

## Solutions

### Java Solution

Located in [`java/Solution.java`](java/Solution.java)

#### Approach

The Java solution uses the two-pointer technique:
1. Start with two pointers, one at the beginning (`l = 0`) and one at the end (`r = height.length - 1`) of the array.
2. Calculate the area between the lines at positions `l` and `r`.
3. The area is determined by the minimum height of the two lines multiplied by the distance between them.
4. To maximize the area, we move the pointer pointing to the shorter line inward (since moving the taller line would only decrease the area).
5. Continue this process until the pointers meet.
6. Keep track of the maximum area encountered during this process.

#### Complexity Analysis

- Time Complexity: O(n) - We need to scan the array once.
- Space Complexity: O(1) - We use only constant extra space.

### Python Solution

Located in [`python/solution.ipynb`](python/solution.ipynb)

#### Approach

The Python solution also implements the two-pointer technique:
1. Initialize two pointers, `l` at index 0 (left end) and `r` at index `len(height) - 1` (right end).
2. Calculate the area between the two lines, which is min(height[l], height[r]) * (r - l).
3. Track the maximum area found during the traversal.
4. At each step, move the pointer that points to the shorter line inward:
   - If height[l] <= height[r], move left pointer rightward (l += 1)
   - If height[l] > height[r], move right pointer leftward (r -= 1)
5. Continue until the pointers meet.

#### Complexity Analysis

- Time Complexity: O(n) - We need to scan the array once.
- Space Complexity: O(1) - We use only constant extra space.
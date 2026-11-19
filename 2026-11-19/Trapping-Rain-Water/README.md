# Daily LeetCode Problem - November 19, 2026

## Problem

[Trapping Rain Water - LeetCode 42](https://leetcode.com/problems/trapping-rain-water/)

## Problem Statement

Given an array `height` of non-negative integers representing an elevation map, where the width of each bar is 1, calculate how much water can be trapped between the bars after raining.

**Example 1:**

```text
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
```

**Example 2:**

```text
Input: height = [4,2,0,3,2,5]
Output: 9
```

**Constraints:**

- `n == height.length`
- `1 <= n <= 2 * 10^4`
- `0 <= height[i] <= 10^5`

## Solutions

### Java Solution

Located in [`java/trappingRainWater/Solution.java`](java/trappingRainWater/Solution.java)

#### Approach

**Two Pointers (Optimal Solution)**

We use two pointers, `left` and `right`, starting at the beginning and end of the array respectively.

We also maintain:

- `leftMax`: Maximum height encountered so far from the left.
- `rightMax`: Maximum height encountered so far from the right.
- `totalWater`: Total amount of trapped water.

**Algorithm:**

1. Initialize `left = 0` and `right = n - 1`.
2. Initialize `leftMax`, `rightMax`, and `totalWater` to `0`.
3. While `left < right`:
   - If `height[left] < height[right]`:
     - The left side is the limiting side, so process the left position.
     - If `leftMax > height[left]`, water can be trapped at this position:
       `totalWater += leftMax - height[left]`.
     - Otherwise, update `leftMax = height[left]`.
     - Move the left pointer forward.
   - Otherwise:
     - Process the right position.
     - If `rightMax > height[right]`, add the trapped water:
       `totalWater += rightMax - height[right]`.
     - Otherwise, update `rightMax = height[right]`.
     - Move the right pointer backward.
4. Return `totalWater`.

**Why does this work?**

The amount of water trapped at any position depends on the minimum of the maximum heights on its left and right sides:

`water[i] = min(leftMax, rightMax) - height[i]`

The key observation is that we don't need to calculate both maximum boundaries for every position.

When `height[left] < height[right]`, we know that the right boundary is at least as high as the current left boundary. Therefore, the left maximum determines how much water can be trapped at the current left position.

The same reasoning applies symmetrically to the right pointer.

This allows us to calculate trapped water in a single traversal without using additional arrays.

#### Complexity Analysis

- **Time Complexity:** `O(n)` — Each pointer moves toward the other, and every element is processed at most once.
- **Space Complexity:** `O(1)` — We only use a constant number of variables, regardless of the input size.

### Python Solution

Located in [`python/solution.py`](python/solution.py)

#### Approach

**Two Pointers (Optimal Solution)**

The Python implementation follows the same Two Pointers approach as the Java solution.

1. Initialize two pointers at the beginning and end of the array.
2. Maintain `left_max` and `right_max` to track the maximum heights encountered from each side.
3. Process the side with the smaller current height.
4. Calculate trapped water using the corresponding maximum boundary.
5. Move the pointer toward the center.
6. Return the accumulated water.

#### Complexity Analysis

- **Time Complexity:** `O(n)` — Each element is visited at most once.
- **Space Complexity:** `O(1)` — Only a constant number of variables are used.

## Notes/Explanation

### Important Observations

- Water can only be trapped when there are taller boundaries surrounding a position.
- The water level at a position is determined by the shorter of its two maximum boundaries.
- We don't need to store the left and right maximum heights for every position.
- The Two Pointers technique allows us to calculate the result in one pass.

### Comparison of Approaches

| Approach                                | Time Complexity | Space Complexity |
| --------------------------------------- | --------------- | ---------------- |
| Brute Force                             | O(n²)           | O(1)             |
| Dynamic Programming (Prefix/Suffix Max) | O(n)            | O(n)             |
| Two Pointers                            | O(n)            | O(1)             |

### Key Takeaway

The most important insight is that **we process the side with the smaller current boundary because that side determines the maximum possible water level at that position**.

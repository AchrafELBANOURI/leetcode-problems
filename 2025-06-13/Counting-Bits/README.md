# Daily LeetCode Problem - June 13, 2025

## Problem

[338. Counting Bits](https://leetcode.com/problems/counting-bits/) - Easy

## Problem Statement

Given an integer `n`, return an array `ans` of length `n + 1` such that for each `i` (`0 <= i <= n`), `ans[i]` is the number of `1`'s in the binary representation of `i`.

### Examples

**Example 1:**

```
Input: n = 2
Output: [0,1,1]
Explanation:
0 --> 0 (no 1's)
1 --> 1 (1 has 1 '1' bit)
2 --> 10 (2 has 1 '1' bit)
```

**Example 2:**

```
Input: n = 5
Output: [0,1,1,2,1,2]
Explanation:
0 --> 0 (no 1's)
1 --> 1 (1 has 1 '1' bit)
2 --> 10 (2 has 1 '1' bit)
3 --> 11 (3 has 2 '1' bits)
4 --> 100 (4 has 1 '1' bit)
5 --> 101 (5 has 2 '1' bits)
```

### Constraints

- `0 <= n <= 10^5`

### Follow Up

- Can you solve it in linear time O(n) and using only O(1) extra space?

## Solutions

### Java Solution

Located in [`java/Solution.java`](java/Solution.java)

#### Approach

<!-- Add Java solution approach here -->

#### Complexity Analysis

- Time Complexity: O(n) - We need to compute the bits for each number from 0 to n.
- Space Complexity: O(n) - To store the result array of length n+1.

### Python Solution

Located in [`python/solution.ipynb`](python/solution.ipynb)

#### Approach

<!-- Add Python solution approach here -->

#### Complexity Analysis

- Time Complexity: O(n) - We need to compute the bits for each number from 0 to n.
- Space Complexity: O(n) - To store the result array of length n+1.

## Notes/Explanation

<!-- Add any additional notes or explanations here -->

# Daily LeetCode Problem - $(date +%B\ %d,\ %Y)

## Problem

[62. Unique Paths](https://leetcode.com/problems/unique-paths/) - Medium

## Problem Statement

A robot is located at the top-left corner of a `m x n` grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?

The test cases are generated so that the answer fits in a 32-bit integer.

### Examples

**Example 1:**
```
Input: m = 3, n = 7
Output: 28
```

**Example 2:**
```
Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
```

### Constraints

- `1 <= m, n <= 100`
- The answer fits in a 32-bit integer.

## Solutions

### Java Solution

Located in [`java/Solution.java`](java/Solution.java)

#### Approach

<!-- Add Java solution approach here -->

#### Complexity Analysis

- **Time Complexity**: O(m * n), where m and n are the dimensions of the grid. Each cell is computed once.
- **Space Complexity**: O(m * n), for the DP table used to store intermediate results.

### Python Solution

Located in [`python/solution.ipynb`](python/solution.ipynb)

#### Approach

<!-- Add Python solution approach here -->

#### Complexity Analysis

- **Time Complexity**: O(m * n), where m and n are the dimensions of the grid. Each cell is computed once.
- **Space Complexity**: O(m * n), for the DP table used to store intermediate results.

## Notes/Explanation

<!-- Add any additional notes or explanations here -->

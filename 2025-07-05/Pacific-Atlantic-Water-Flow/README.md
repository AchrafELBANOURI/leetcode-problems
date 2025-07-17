# Daily LeetCode Problem - July 17, 2025

## Problem

[417. Pacific Atlantic Water Flow](https://leetcode.com/problems/pacific-atlantic-water-flow/) - Medium

## Problem Statement

Given an `m x n` matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.

Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.

Return a list of grid coordinates where water can flow to both the Pacific and Atlantic oceans.

### Examples

**Example 1:**
```
Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
```

**Example 2:**
```
Input: heights = [[2,1],[1,2]]
Output: [[0,0],[0,1],[1,0],[1,1]]
```

### Constraints

- `m == heights.length`
- `n == heights[i].length`
- `1 <= m, n <= 200`
- `0 <= heights[i][j] <= 10^5`

## Solutions

### Java Solution

Located in [`java/Solution.java`](java/Solution.java)

#### Approach

The Java solution uses a depth-first search (DFS) approach to explore the matrix. It maintains two sets to track cells that can flow to the Pacific and Atlantic oceans, respectively.

#### Complexity Analysis

- **Time Complexity**: O(m * n), where m and n are the dimensions of the matrix.
- **Space Complexity**: O(m * n), for the visited arrays and recursion stack.

### Python Solution

Located in [`python/solution.ipynb`](python/solution.ipynb)

#### Approach

The Python solution implements a similar DFS-based approach, iterating through the matrix to identify cells that meet the criteria for both oceans.

#### Complexity Analysis

- **Time Complexity**: O(m * n), where m and n are the dimensions of the matrix.
- **Space Complexity**: O(m * n), for the visited arrays and recursion stack.

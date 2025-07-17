# Daily LeetCode Problem - July 17, 2025

## Problem

[200. Number of Islands](https://leetcode.com/problems/number-of-islands/) - Medium

## Problem Statement

Given an `m x n` 2D binary grid `grid` which represents a map of `'1'`s (land) and `'0'`s (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

### Examples

**Example 1:**
```
Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
```

**Example 2:**
```
Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
```

### Constraints

- `m == grid.length`
- `n == grid[i].length`
- `1 <= m, n <= 300`
- `grid[i][j]` is `'0'` or `'1'`.

## Solutions

### Java Solution

Located in [`java/Solution.java`](java/Solution.java)

#### Approach

The Java solution uses Depth-First Search (DFS) to traverse the grid. A `visitedSet` is used to keep track of visited cells. For each unvisited land cell ('1'), the DFS explores all connected land cells, marking them as visited. The number of islands is incremented for each DFS initiation.

#### Complexity Analysis

- **Time Complexity**: O(m * n), where m and n are the dimensions of the grid. Each cell is visited once.
- **Space Complexity**: O(m * n), for the `visitedSet` and recursion stack.

### Python Solution

Located in [`python/solution.ipynb`](python/solution.ipynb)

#### Approach

The Python solution also employs Depth-First Search (DFS). A `visited_set` is used to track visited cells. For each unvisited land cell ('1'), the DFS explores all connected land cells, marking them as visited. The number of islands is incremented for each DFS initiation.

#### Complexity Analysis

- **Time Complexity**: O(m * n), where m and n are the dimensions of the grid. Each cell is visited once.
- **Space Complexity**: O(m * n), for the `visited_set` and recursion stack.
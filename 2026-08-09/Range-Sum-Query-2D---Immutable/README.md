# Daily LeetCode Problem - August 09, 2026

## Problem

[LeetCode 304 - Range Sum Query 2D - Immutable](https://leetcode.com/problems/range-sum-query-2d-immutable/)

## Problem Statement

Given a 2D matrix, design a data structure that efficiently calculates the sum of elements within a subgrid specified by its top-left corner `(row1, col1)` and bottom-right corner `(row2, col2)`.

Implement the `NumMatrix` class:

- `NumMatrix(int[][] matrix)` Initializes the object with the 2D integer array.
- `int sumRegion(int row1, int col1, int row2, int col2)` Returns the sum of the region bounded by the specified coordinates.

## Solutions

### Java Solution

Located in [`java/rangeSumQuery2D/Solution.java`](java/rangeSumQuery2D/Solution.java)

#### Approach

To avoid performing $O(R \times C)$ calculations for every `sumRegion` call, we compute a **2D Prefix Sum Array** during initialization.

1. Create a `prefix` array of dimensions $(R+1) \times (C+1)$ where `prefix[r+1][c+1]` stores the sum of all elements from $(0,0)$ up to $(r,c)$.
2. Populate the prefix array using the inclusion-exclusion relation:
   $$\text{prefix}[r+1][c+1] = \text{prefix}[r+1][c] + \text{prefix}[r][c+1] - \text{prefix}[r][c] + \text{matrix}[r][c]$$
3. Answer each `sumRegion` query in $O(1)$ time using the subgrid formula:
   $$\text{Sum} = \text{prefix}[row2+1][col2+1] - \text{prefix}[row1][col2+1] - \text{prefix}[row2+1][col1] + \text{prefix}[row1][col1]$$

#### Complexity Analysis

- **Time Complexity:**
  - **Constructor:** $O(R \times C)$ where $R$ is the number of rows and $C$ is the number of columns.
  - **`sumRegion` Query:** $O(1)$ constant time lookup.
- **Space Complexity:** $O(R \times C)$ extra space for the prefix sum matrix.

---

### Python Solution

Located in [`python/solution.ipynb`](python/solution.ipynb)

#### Approach

The Python implementation mirrors the 2D prefix sum technique. An auxiliary matrix of size $(R+1) \times (C+1)$ is initialized with zeros.

During initialization, cumulative sums are computed row by row. For subgrid region queries, region sums are derived using constant-time inclusion-exclusion evaluation on the prefix array.

#### Complexity Analysis

- **Time Complexity:**
  - **Constructor:** $O(R \times C)$ to precompute prefix totals.
  - **`sumRegion` Query:** $O(1)$ constant time lookup.
- **Space Complexity:** $O(R \times C)$ to store the $(R+1) \times (C+1)$ 2D prefix matrix.

---

## Notes/Explanation

- **1-Based Index Padding:** Using a prefix grid sized $(R+1) \times (C+1)$ eliminates boundary checks for subgrids starting at index `row1 = 0` or `col1 = 0`.
- **Inclusion-Exclusion Principle:** Adding overlapping top and left regions counts the top-left intersection twice. Subtracting `prefix[row1][col1]` during construction (or adding it back during range queries) ensures exact coverage without duplicate sums.

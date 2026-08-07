# Daily LeetCode Problem - Valid Sudoku

## Problem

[LeetCode 36. Valid Sudoku](https://leetcode.com/problems/valid-sudoku/)

## Problem Statement

Determine if a `9 x 9` Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

1. Each row must contain the digits `1-9` without repetition.
2. Each column must contain the digits `1-9` without repetition.
3. Each of the nine `3 x 3` sub-boxes of the grid must contain the digits `1-9` without repetition.

**Note:**

- A Sudoku board (partially filled) could be valid, but is not necessarily solvable.
- Only the filled cells need to be validated according to the mentioned rules.

## Solutions

### Java Solution

Located in [`java/Solution.java`](java/Solution.java)

#### Approach

We use **HashSet Validation Across Grid Constraints**:

1. **Rows & Columns:** Iterate through each row `i` and column `j` from `0` to `8`. Use two HashSets (`rows` and `cols`) to track non-dot characters. If a duplicate digit is encountered in the current row or column set, return `false`. Clear both sets at the end of each row/column pass.
2. **3x3 Sub-boxes:** Iterate through each of the nine $3 \times 3$ sub-grids using nested loops (`i` and `j` from `0` to `2`), mapping top-left coordinates via `3 * i` and `3 * j`. Use a third HashSet (`box`) to ensure no character is duplicated within any sub-grid.
3. If all rows, columns, and $3 \times 3$ sub-boxes pass validation without duplicate values, return `true`.

```java
import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> rows = new HashSet<>();
        Set<Character> cols = new HashSet<>();

        // Check rows and columns
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (rows.contains(board[i][j])) return false;
                    rows.add(board[i][j]);
                }
                if (board[j][i] != '.') {
                    if (cols.contains(board[j][i])) return false;
                    cols.add(board[j][i]);
                }
            }
            rows.clear();
            cols.clear();
        }

        // Check 3x3 sub-boxes
        Set<Character> box = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int r = 3 * i; r < 3 * (i + 1); r++) {
                    for (int c = 3 * j; c < 3 * (j + 1); c++) {
                        if (board[r][c] != '.') {
                            if (box.contains(board[r][c])) return false;
                            box.add(board[r][c]);
                        }
                    }
                }
                box.clear();
            }
        }

        return true;
    }
}
```

#### Complexity Analysis

- **Time Complexity:** $\mathcal{O}(1)$ — The grid size is fixed at $9 \times 9 = 81$ cells. We make a constant number of iterations (81 cells checked for rows/columns + 81 cells checked for $3 \times 3$ sub-boxes = 162 total operations).
- **Space Complexity:** $\mathcal{O}(1)$ — HashSets store at most 9 characters at any given time before being cleared, leading to fixed $\mathcal{O}(1)$ auxiliary space.

### Python Solution

Located in [`python/solution.ipynb`](python/solution.ipynb)

#### Approach

The Python implementation mirrors the multi-pass set approach:

1. Iterate over rows and columns simultaneously, using set membership checks (`in rows` / `in cols`) to detect duplicates in linear row/col passes.
2. Iterate through sub-grid boundaries (`3*i` to `3*(i+1)` and `3*j` to `3*(j+1)`) using a set to validate each $3 \times 3$ box independently.
3. Return `False` immediately upon detecting any invalid cell entry, otherwise return `True`.

```python
from typing import List

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        rows = set()
        cols = set()

        # Check rows and columns
        for i in range(9):
            for j in range(9):
                if board[i][j] != ".":
                    if board[i][j] in rows:
                        return False
                    rows.add(board[i][j])

                if board[j][i] != ".":
                    if board[j][i] in cols:
                        return False
                    cols.add(board[j][i])
            rows.clear()
            cols.clear()

        # Check 3x3 sub-boxes
        box = set()
        for i in range(3):
            for j in range(3):
                for r in range(3 * i, 3 * (i + 1)):
                    for c in range(3 * j, 3 * (j + 1)):
                        if board[r][c] != ".":
                            if board[r][c] in box:
                                return False
                            box.add(board[r][c])
                box.clear()

        return True
```

#### Complexity Analysis

- **Time Complexity:** $\mathcal{O}(1)$ — Constant execution time because the board is bounded to a fixed $9 \times 9$ layout.
- **Space Complexity:** $\mathcal{O}(1)$ — Sets hold a maximum of 9 unique elements at a time.

# Daily LeetCode Problem - September 29, 2026

## Problem

[680. Valid Palindrome II](https://leetcode.com/problems/valid-palindrome-ii/)

## Problem Statement

Given a string `s`, return `true` _if the_ `s` _can be palindrome after deleting **at most one** character from it_.

## Solutions

### Java Solution

Located in [`java/validPalindromeII/Solution.java`](java/validPalindromeII/Solution.java)

#### Approach

Employs a **two-pointer** strategy moving from both ends towards the center. When a character mismatch occurs at `(left, right)`, the algorithm branches into a single sub-check: it verifies if the remaining substring is a valid palindrome by either skipping the character at `left` (`left + 1` to `right`) or skipping the character at `right` (`left` to `right - 1`). A helper method performs this range validation in-place.

#### Complexity Analysis

- Time Complexity: $\mathcal{O}(N)$, where $N$ is the length of string `s`. In the worst-case scenario with a mismatch, the string or its sub-ranges are traversed at most twice.
- Space Complexity: $\mathcal{O}(1)$ auxiliary space as comparisons are executed directly using index pointers without allocating additional memory.

### Python Solution

Located in [`python/solution.py`](python/solution.py)

#### Approach

Adapts the two-pointer approach utilizing idiomatic Python string slicing. Pointers traverse inward until a mismatch is detected. Upon mismatch, Python's C-optimized string slicing (`s[left + 1 : right + 1]` and `s[left : right]`) is combined with reverse slicing (`[::-1]`) to evaluate both deletion possibilities concurrently.

#### Complexity Analysis

- Time Complexity: $\mathcal{O}(N)$, traversing the string length in linear time.
- Space Complexity: $\mathcal{O}(N)$ due to temporary substring allocations created during slice comparisons (can be reduced to $\mathcal{O}(1)$ using explicit pointer loops).

## Notes/Explanation

- **Greedy Branching Choice**: When `s[left] != s[right]`, we do not need complex backtracking or dynamic programming. Since only one deletion is allowed throughout the entire string, checking the immediate sub-ranges `(left + 1, right)` and `(left, right - 1)` covers all valid states.
- **Python Slicing vs Loop Performance**: While string slicing incurs an $\mathcal{O}(N)$ memory allocation overhead, `slice == slice[::-1]` executes inside C-level primitives, outperforming pure Python `while` loops in benchmark runtime.

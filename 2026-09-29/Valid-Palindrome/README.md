# Daily LeetCode Problem - September 29, 2026

## Problem

[125. Valid Palindrome](https://leetcode.com/problems/valid-palindrome/)

## Problem Statement

A phrase is a **palindrome** if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string `s`, return `true` _if it is a **palindrome**, or_ `false` _otherwise_.

## Solutions

### Java Solution

Located in [`java/validPalindrome/Solution.java`](java/validPalindrome/Solution.java)

#### Approach

Uses a **two-pointer** technique traversing from both ends towards the center. In-place ASCII bounds checking (`'a'-'z'`, `'A'-'Z'`, `'0'-'9'`) skips non-alphanumeric characters without extra string allocations. Uppercase characters are converted to lowercase using direct ASCII manipulation (`+ 32`).

#### Complexity Analysis

- Time Complexity: $\mathcal{O}(N)$, where $N$ is the length of string `s`. Each character is visited at most once.
- Space Complexity: $\mathcal{O}(1)$ auxiliary space as operations are performed entirely in-place.

### Python Solution

Located in [`python/solution.py`](python/solution.py)

#### Approach

Applies the **two-pointer** strategy adapted for Python idioms. Internal `while` loops leverage Python's built-in `str.isalnum()` method to filter non-alphanumeric characters, and `str.lower()` performs case-insensitive comparisons without allocating modified sub-strings.

#### Complexity Analysis

- Time Complexity: $\mathcal{O}(N)$, traversing the string length once.
- Space Complexity: $\mathcal{O}(1)$ auxiliary space, avoiding string copies or additional memory allocation.

## Notes/Explanation

- **In-Place Two-Pointer vs Preprocessing**: While preprocessing the string (e.g., `filtered = [c.lower() for c in s if c.isalnum()]`) offers clean syntax and fast execution in Python due to C-level optimizations, it incurs $\mathcal{O}(N)$ memory overhead. The two-pointer approach maintains $\mathcal{O}(1)$ space guarantees across both Java and Python implementations.
- **ASCII Conversion**: In ASCII, lowercase and uppercase counterparts differ by a constant offset of $32$ (`'a' - 'A' = 32`).

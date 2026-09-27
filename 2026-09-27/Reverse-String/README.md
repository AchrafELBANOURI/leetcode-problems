# Daily LeetCode Problem - September 27, 2026

## Problem

[LeetCode 344 - Reverse String](https://leetcode.com/problems/reverse-string/)

## Problem Statement

Write a function that reverses a string. The input string is given as an array of characters `s`.

You must do this by modifying the input array in-place with O(1) extra memory.

**Example 1:**

- **Input:** `s = ["h","e","l","l","o"]`
- **Output:** `["o","l","l","e","h"]`

**Example 2:**

- **Input:** `s = ["H","a","n","n","a","h"]`
- **Output:** `["h","a","n","n","a","H"]`

## Solutions

### Java Solution

Located in [`java/reverseString/Solution.java`](java/reverseString/Solution.java)

#### Approach

The solution uses a **Two-Pointer** approach:

1. Initialize two pointers: `i` at index `0` (beginning) and `j` at index `n - 1` (end).
2. Swap the characters at indices `i` and `j` using a temporary variable `tmp`.
3. Increment `i` and decrement `j` in each step until the pointers cross (`i >= j`).

#### Complexity Analysis

- Time Complexity: O(n) — We perform `n / 2` swaps, which simplifies to linear time complexity relative to string length.
- Space Complexity: O(1) — Reverses the character array in-place using a single temporary variable.

### Python Solution

Located in [`python/solution.py`](python/solution.py)

#### Approach

In Python, the **Two-Pointer** pattern is implemented using tuple unpacking (`s[i], s[j] = s[j], s[i]`) to swap values in-place without needing an explicit temporary variable. Alternatively, Python's native `s.reverse()` can be used to reverse the list in-place.

#### Complexity Analysis

- Time Complexity: O(n) — Iterates through half the list, swapping pairs of elements in O(n) time.
- Space Complexity: O(1) — Modifies the input list in-place without allocating additional memory.

## Notes/Explanation

- **In-Place Modification:** Strings in Python are immutable, but the LeetCode problem provides input as a list of characters (`List[str]`), allowing in-place mutations.
- **Python Slicing (`s[::-1]`):** While `s[::-1]` is the idiomatic way to reverse a sequence in Python, it creates a copy of the list, requiring O(n) auxiliary space. To satisfy the O(1) space constraint, `s.reverse()` or a two-pointer loop must be used.

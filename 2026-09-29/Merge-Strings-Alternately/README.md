# Daily LeetCode Problem - September 29, 2026

## Problem

[1768. Merge Strings Alternately](https://leetcode.com/problems/merge-strings-alternately/)

## Problem Statement

You are given two strings `word1` and `word2`. Merge the strings by adding letters in alternating order, starting with `word1`. If a string is longer than the other, append the additional letters onto the end of the merged string.

Return _the merged string_.

## Solutions

### Java Solution

Located in [`java/mergeStrings/Solution.java`](java/mergeStrings/Solution.java)

#### Approach

Used a two-pointer approach to iterate through both input strings while maintaining sequence order with a destination index variable.

1. **Pointer Traversal:**
   - Maintain `p1` for `word1`, `p2` for `word2`, and `k` for the target position in the `res` character array.
   - Alternately append characters while `p1 < word1.length()` and `p2 < word2.length()`.
2. **Tail Cleanup:**
   - Append any remaining characters from `word1` or `word2` using independent `while` loops after the main alternating loop terminates.
3. **Return:**
   - Convert the character array back to a string using `String.valueOf(res)`.

#### Complexity Analysis

- **Time Complexity:** $O(N + M)$ where $N$ and $M$ are the lengths of `word1` and `word2`.
- **Space Complexity:** $O(N + M)$ auxiliary space required for the output character array.

---

### Python Solution

Located in [`python/solution.py`](python/solution.py)

#### Approach

Utilized `itertools.zip_longest` to pair characters from both strings up to the longer string's length, filling missing elements with an empty string.

1. **Functional Zipping:**
   - `zip_longest(word1, word2, fillvalue="")` pairs corresponding characters `(c1, c2)` from both strings.
   - If one string terminates early, `fillvalue=""` ensures no out-of-bounds error occurs.
2. **Concatenation:**
   - Form character pairs using generator expression `c1 + c2`.
   - Join all pairs into a single string using `"".join(...)`.

#### Complexity Analysis

- **Time Complexity:** $O(N + M)$ where $N$ and $M$ are the lengths of `word1` and `word2`.
- **Space Complexity:** $O(N + M)$ to store the merged character sequence before joining.

---

## Notes/Explanation

- **String Immutability in Python:** Constructing a list or generator and calling `"".join()` avoids the performance penalty of $O(K^2)$ string re-allocations associated with repeated in-place `+` string concatenations in Python.
- **Pointer Bounds Edge Case:** In the two-pointer approach, comparing `p1` and `p2` directly inside the primary loop condition fails when $N < M$; explicit bounds checks or single-pass logic are required to handle unequal length inputs correctly.
